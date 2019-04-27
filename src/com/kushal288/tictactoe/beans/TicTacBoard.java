package com.kushal288.tictactoe.beans;

import com.kushal288.tictactoe.enums.TicTacValue;
import com.kushal288.tictactoe.exceptions.ValueOverridingException;

import java.util.Arrays;

public final class TicTacBoard
{
	private final TicTacValue[][] boardArray;
	private final int order;

	private final String HORIZONTAL_SEPARATOR = "--- ";

	public TicTacBoard(){
		this(3);
	}

	public TicTacBoard(int boardOrder)
	{
		if (boardOrder < 3)
		{
			boardOrder = 3;
		}
		this.order = boardOrder;
		boardArray = new TicTacValue[order][order];
		init();
	}

	private void init(){
		for (int i = 0; i < order; i++)
		{
			for (int j = 0; j < order; j++)
			{
				boardArray[i][j] = TicTacValue.EMPTY;
			}
		}
	}

	public void insertMark(final Coordinates coordinates, final TicTacValue mark) throws ValueOverridingException
	{
		TicTacValue prevVal = this.boardArray[coordinates.getX()][coordinates.getY()];
		if(prevVal != null && prevVal != TicTacValue.EMPTY){
			throw new ValueOverridingException("Value exists at: "+coordinates + ", Value: " + mark);
		}

		this.boardArray[coordinates.getX()][coordinates.getY()] = mark;
	}

	public TicTacValue[][] getBoardArray()
	{
		return boardArray.clone();
	}

	@Override
	public String toString()
	{
		printBoardOnConsole();
		return "TicTacBoard{" + "boardArray=" + Arrays.toString(boardArray) + '}';
	}

	public void printBoardOnConsole(){
		System.out.println();
		for (int i = 0; i < order; i++)
		{
			if(i!=0)
				System.out.println(horizontalLineSeparator());
			for (int j = 0; j < order; j++)
			{
				TicTacValue value = boardArray[i][j];
				if(value == TicTacValue.EMPTY){
					System.out.print("   ");
				}else{
					System.out.print(" " + value + " ");
				}
				if (j != order - 1)
				{
					System.out.print("|");
				}
			}
			System.out.println();
		}
	}

	private String horizontalLineSeparator()
	{

		StringBuilder sb = new StringBuilder(order * HORIZONTAL_SEPARATOR.length());
		for (int i = 0; i < order; i++)
		{
			sb.append(HORIZONTAL_SEPARATOR);
		}
		return sb.toString();
	}
}
