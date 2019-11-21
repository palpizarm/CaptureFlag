package controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import commons.IContants;
import model.Player;

public class BinaryFileHandler implements IContants {
	private final int  M = AUX_FILES; 
	private final int M2 = AUX_FILES/2;
	private String fileName;
	private File file;
	private File [] auxiliarFiles;
	private Object []DataStream = null;
	
	/**
	 * 
	 * @param pFileName name of the file 
	 * @throws Exception 
	 */
	public BinaryFileHandler() throws Exception {
		fileName = "players";
		auxiliarFiles = new File[M];
		DataStream = new Object[M];
		try {
		file = new File(fileName);
		} catch (Exception e) {
			throw new Exception("Couldn't open File input");
		}

	}
	
	/**
	 * sort algorithm method
	 */
	private void multipleBalancedMix() {
		int range = 1, countObject = 0;
		int byteRead = 0;
		int outputIndex = 0;
		boolean readble = true;
		Player player1 = null , player2 = null;
		int index[] = new int[M];
		for (int fileIndex = 0; fileIndex < M; fileIndex++) {
			auxiliarFiles[fileIndex] = new File("File" + fileIndex);
			index[fileIndex] = fileIndex;
		}
		try {
			// the first split of the object in the inputFile
			countObject = shareOut();
			if (countObject < 2) {
				return;
			}
			do {
				for (int indexFile = 0; indexFile < M; indexFile++) {
					if (indexFile < M2) {
						FileInputStream fileIn = new FileInputStream(auxiliarFiles[index[indexFile]]);
						DataStream[index[indexFile]] = (ObjectInput)new ObjectInputStream(fileIn);

					} else {
						FileOutputStream fileOutput = new FileOutputStream(auxiliarFiles[index[indexFile]]);
						DataStream[index[indexFile]] = (ObjectOutput)new ObjectOutputStream(fileOutput);
					}
				}
				outputIndex = M2;
				int splitRange = 0;
				while (readble) {
					player1 = (Player)(((ObjectInputStream)DataStream[index[0]]).readObject());
					player2 = (Player)(((ObjectInputStream)DataStream[index[1]]).readObject());
					while (splitRange < range ) {
						try {
							if (player1.compareTo(player2) > 0) {
								((ObjectOutputStream)DataStream[index[outputIndex]]).writeObject(player1);
								((ObjectOutputStream)DataStream[index[outputIndex]]).writeObject(player2);
							} else {
								((ObjectOutputStream)DataStream[index[outputIndex]]).writeObject(player2);
								((ObjectOutputStream)DataStream[index[outputIndex]]).writeObject(player1);
							}
							if(outputIndex == M) {
								outputIndex = M2;
							} else {
								outputIndex++;
							}
						} catch (Exception e) {
							readble = false;
						}
					}
				}
				player1 = null; player2 = null;
			} while (range < countObject);
			// Change the order of file
			for (int i = 0; i < M2; i++)
			{
				int aux;
				aux = index[i];
				index[i] = index[i+M2];
				index[i+M2] = aux;
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ERROR: multiple Balanced Mix throw a error");
			return;
		}

	}
	
	/**
	 * To distribute the bytes in the input files
	 * @return number of object in the origin file
	 * @throws IOException 
	 */
	private int shareOut() throws IOException {
		int outputIndex = 0;
		Player player = null;
		boolean readble = true;
		int objectCount = 0;
		FileInputStream fileIn = new FileInputStream(file);
		ObjectInputStream originInput =	new ObjectInputStream(fileIn);
		System.out.println(file.length());
		for (outputIndex = 0; outputIndex < M2; outputIndex++) {
			FileOutputStream fileOutput = new FileOutputStream(auxiliarFiles[outputIndex]);
			DataStream[outputIndex] = (ObjectOutput)new ObjectOutputStream(fileOutput);
		}
		outputIndex = 0;
		while (readble) { 
			try {
				player = (Player)originInput.readObject();
				((ObjectOutputStream)DataStream[outputIndex]).writeObject(player);
				((ObjectOutputStream)DataStream[outputIndex]).flush();
				outputIndex=(outputIndex+1)%M2;
				objectCount++;
			} catch (EOFException e) {
				readble = false;
				originInput.close();
			} catch (Exception e) {
				readble = false;
			}
		}
		return objectCount;
	}


	
	/**
	 * Sort the players with external balanced mix
	 */
	public void sort() {
		multipleBalancedMix();
	}
	
	/**
	 * Save the new player in the file
	 */
	public void write(Player pPlayer) {
		try {
			FileOutputStream fileOutput = new FileOutputStream(file,true);
			ObjectOutputStream out = new ObjectOutputStream(fileOutput);
			out.writeObject(pPlayer);
			out.flush();
			out.close();
			fileOutput.close();
			multipleBalancedMix();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public Player search(char[] pUser) {
		Player player= null;
		FileInputStream fileIn = null;
		ObjectInputStream originInput = null;
		boolean readble = true;
		try {
			fileIn = new FileInputStream(file);
			originInput =	new ObjectInputStream(fileIn);
			while (readble) { 
				try {
					player = (Player)originInput.readObject();
					if (player.getUser() == pUser) {
						readble = false;
					}
				} catch (ClassNotFoundException | IOException e) {
					readble = false;
					player = null;
					fileIn.close();
				}
			}
		} catch (IOException e) {
			//e.printStackTrace();
		}
		return player;
	}
}
