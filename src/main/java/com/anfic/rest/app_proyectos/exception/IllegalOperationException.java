package com.anfic.rest.app_proyectos.exception;
/*
 * Excepcion que lanza cuando se realiza una operacion ilegal
 * */
public class IllegalOperationException extends Exception{
	private static final long serialVersionUID = 1L;
	 
	public IllegalOperationException(String message) {
		super (message);
	}
}
