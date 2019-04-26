package com.kushal288.tictactoe.beans;

import com.kushal288.tictactoe.enums.TicTacValue;

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

	public boolean insertMark(final Coordinates coordinates, final TicTacValue mark){
		TicTacValue prevVal = this.boardArray[coordinates.getX()][coordinates.getY()];
		if(prevVal != null || prevVal != TicTacValue.EMPTY){
			return false;
		}

		this.boardArray[coordinates.getX()][coordinates.getY()] = mark;
		return true;
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
			System.out.println("---------------");
			for (int j = 0; j < boardArray[i].length; j++)
			{
				TicTacValue value = boardArray[i][j];
				if(value == TicTacValue.EMPTY){
					System.out.print("   |");
				}else{
					System.out.print(" " + value + " |");
				}
			}
		}
	}
}
