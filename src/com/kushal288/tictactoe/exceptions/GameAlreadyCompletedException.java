package com.kushal288.tictactoe.exceptions;

public class GameAlreadyCompletedException extends Exception
{
	public GameAlreadyCompletedException()
	{
		super();
	}

	public GameAlreadyCompletedException(String message)
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
