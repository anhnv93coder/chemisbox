package com.chemisbox.exception;

public class ChemisboxException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ChemisboxException(Exception e) {
		super(e);
	}
	
	public ChemisboxException(String msg) {
		super(msg);
	}

}
