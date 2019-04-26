package com.kushal288.tictactoe.beans;

import com.kushal288.tictactoe.enums.TicTacValue;

public final class Player
{
	private final String name;
	private final TicTacValue ticTacValue;

	public Player(String name, TicTacValue ticTacValue)
	{
		this.name = name;
		this.ticTacValue = ticTacValue;
	}

	public String getName()
	{
		return name;
	}

	public TicTacValue getTicTacValue()
	{
		return ticTacValue;
	}

	@Override
	public String toString()
	{
		return "Player{" + "name='" + name + '\'' + ", ticTacValue=" + ticTacValue + '}';
	}
}
