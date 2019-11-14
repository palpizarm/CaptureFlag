package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;

import commons.IContants;
import model.Player;

public class BinaryFileHandler implements IContants {
	private final int  M = AUX_FILES; 
	private final int inputFiles = AUX_FILES/2;
	private int bytesRange;
	private String fileName;
	private File file;
	private File [] auxiliarFiles;
	
	/**
	 * 
	 * @param pFileName name of the file 
	 * @throws Exception 
	 */
	public BinaryFileHandler(String pFileName, int pBytes) throws Exception {
		fileName = pFileName+ ".bin";
		bytesRange = pBytes;
		auxiliarFiles = new File[M];
		try {
		file = new File(fileName);
		} catch (Exception e) {
			throw new Exception("Couldn't open File input");
		}
		for (int fileIndex = 0; fileIndex < M; fileIndex++) {
			auxiliarFiles[fileIndex] = new File("File" + fileIndex + ".bin");
		}
	}
	
	/**
	 * sort algorithm method
	 */
	private void multipleBalancedMix() {
		DataInputStream inputData = null;
		DataOutputStream outputData = null;
	}
	
	private int findBytesSplit() {
		int bytesCount = (int) file.length();
		int objectCount = bytesCount/bytesRange;
		return objectCount;
	}
	
	/**
	 * 
	 */
	public void sort() {
		
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
