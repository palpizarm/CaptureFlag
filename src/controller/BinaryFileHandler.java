package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import commons.IContants;
import model.Player;

public class BinaryFileHandler implements IContants {
	private final int  M = AUX_FILES; 
	private final int M2 = AUX_FILES/2;
	private int bytesRangeObject;
	private String fileName;
	private File file;
	private File [] auxiliarFiles;
	private Object []DataStream = null;
	
	/**
	 * 
	 * @param pFileName name of the file 
	 * @throws Exception 
	 */
	public BinaryFileHandler(String pFileName, int pBytes) throws Exception {
		fileName = pFileName;
		bytesRangeObject = pBytes;
		auxiliarFiles = new File[M];
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
		int indexData [] = new int[M];
		int byteRead = 0;
		byte[][] bytesObject = null;
		for (int fileIndex = 0; fileIndex < M; fileIndex++) {
			auxiliarFiles[fileIndex] = new File("File" + fileIndex);
			indexData[fileIndex] = fileIndex;
		}
		try {
			countObject = shareOut();
			do {
				for (int index = 0; index < M; index++) {
					if (index < M2) {
						DataStream[indexData[index]] = new DataInputStream(
								new BufferedInputStream(new FileInputStream(auxiliarFiles[indexData[index]])));
				
					} else {
						DataStream[indexData[index]] = new DataOutputStream(	
								new BufferedOutputStream(new FileOutputStream(auxiliarFiles[indexData[index]])));
					}
				}
				bytesObject = new byte[range][bytesRangeObject];
				for (int index = 0; index < M2; index++) {
					int countBytes = ((DataInputStream)DataStream[indexData[index]]).read(bytesObject[index],byteRead,bytesRangeObject);
				}
				do {
					Player player1 = (Player)getObject(bytesObject[0]);
					Player palyer2 = (Player)getObject(bytesObject[1]);
				} while();
				/**
				 * Buscar iterar en los tramos y para ir ordenando
				 */
			} while (range > countObject);
		} catch (Exception e) {
			System.out.println("ERROR: multiple Balanced Mix throw a error");
			return;
		}

	}
	
	
	private Object getObject(byte[] byteArr) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bis = new ByteArrayInputStream(byteArr);
		ObjectInput in = new ObjectInputStream(bis);
		return in.readObject();
	}
	/**
	 * 
	 * @return the number of object in the file
	 */
	private int findBytesSplit() {
		int bytesCount = (int) file.length();
		int objectCount = bytesCount/bytesRangeObject;
		return objectCount;
	}
	
	/**
	 * To distribute the bytes in the input files
	 * @return number of object in the origin file
	 * @throws IOException 
	 */
	private int shareOut() throws IOException {
		int outputIndex = 0;
		DataInputStream originInput = new DataInputStream(
								new BufferedInputStream(new FileInputStream(file)));
		DataStream = new DataOutputStream[M2];
		
		for (outputIndex = 0; outputIndex < M2; outputIndex++) {
			DataStream[outputIndex] = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(auxiliarFiles[outputIndex])));
		}
		outputIndex = 0;
		int countSplit = findBytesSplit();
		byte []bytes = null;
		int indexFile = 0;
		for (int count = 0; count < countSplit; count++) {
			int countBytes = originInput.read(bytes,indexFile,bytesRangeObject);
			((BufferedOutputStream) DataStream[outputIndex]).write(bytes);
			outputIndex=(outputIndex+1)%M2;
			indexFile += bytesRangeObject;
		}
		originInput.close();
		return countSplit;
	}


	
	/**
	 * 
	 */
	public void sort() {
		multipleBalancedMix();
	}
	
	/**
	 * 
	 */
	public void write() {
		
	}
	
	/**
	 * 
	 */
	public Player read() {
		
		return null;
	}
}
