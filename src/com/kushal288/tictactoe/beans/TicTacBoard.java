package com.kushal288.tictactoe.beans;

import com.kushal288.tictactoe.enums.TicTacValue;
import com.kushal288.tictactoe.exceptions.ValueOverridingException;

import java.util.Arrays;

public final class TicTacBoard
{
	private final TicTacValue[][] boardArray;

	public TicTacBoard(){
		boardArray = new TicTacValue[3][3];
		init();
	}

	private void init(){
		for (int i = 0; i < boardArray.length ; i++)
		{
			for (int j = 0; j < boardArray[i].length; j++)
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
		for (int i = 0; i < boardArray.length ; i++)
		{
			if(i!=0)
				System.out.println("------------");
			for (int j = 0; j < boardArray[i].length; j++)
			{
				TicTacValue value = boardArray[i][j];
				if(value == TicTacValue.EMPTY){
					System.out.print("   ");
				}else{
					System.out.print(" " + value + " ");
				}
				if(j != boardArray.length -1){
					System.out.print("|");
				}
			}
			System.out.println();
		}
	}
}
