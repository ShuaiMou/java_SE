package cn.saul.exception;

/**
 * Thrown when the player remove the invalid number of stone.
 * 
 * @author Saul
 * 2019-05-08
 *
 */

public class InvalidMoveException extends Exception {
	private static final long serialVersionUID = -4128450668958195683L;
	
	public InvalidMoveException(){
		super();
	}
	
	public InvalidMoveException(String message){
		super(message);
	}

}
