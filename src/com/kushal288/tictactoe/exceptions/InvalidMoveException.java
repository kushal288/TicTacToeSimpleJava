package com.kushal288.tictactoe.exceptions;

public class InvalidMoveException extends Exception
{
	public InvalidMoveException()
	{
		super();
	}

	public InvalidMoveException(String message)
	{
		super(message);
	}

	@Override
	public String getMessage()
	{
		return super.getMessage();
	}

	@Override
	public String getLocalizedMessage()
	{
		return super.getLocalizedMessage();
	}
}
