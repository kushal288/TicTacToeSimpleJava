package com.kushal288.tictactoe.exceptions;

public class ValueOverridingException extends Exception
{
	public ValueOverridingException()
	{
		super();
	}

	public ValueOverridingException(String message)
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
