package controller;

import java.io.FileOutputStream;


import model.Player;

public class BinaryFileHandler {
	private String fileName;
	private FileOutputStream file;
	
	/**
	 * 
	 * @param pFileName name of the file
	 */
	public BinaryFileHandler(String pFileName) {
		fileName = pFileName+ ".bin";
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
