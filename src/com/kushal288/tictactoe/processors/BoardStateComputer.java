package com.kushal288.tictactoe.processors;

import com.kushal288.tictactoe.beans.TicTacBoard;
import com.kushal288.tictactoe.enums.TicTacValue;

public final class BoardStateComputer
{

	final private TicTacBoard board;

	public BoardStateComputer(TicTacBoard board)
	{
		this.board = board;
	}

	public boolean isGameCompleted(){
		TicTacValue[][] boardArray = board.getBoardArray();
		for (int i = 0; i < boardArray.length ; i++)
		{
			for (int j = 0; j < boardArray[i].length; j++)
			{
				if(boardArray[i][j] == TicTacValue.EMPTY)
					return false;
			}
		}

		return true;
	}

	public  TicTacValue getWinner(){
		TicTacValue[][] boardArray = board.getBoardArray();

		// Horizontal run
		for (int i = 0; i < boardArray.length ; i++)
		{
			TicTacValue value = boardArray[i][0];
			boolean res = true;
			for (int j = 0; j < boardArray[i].length; j++)
			{
				res = boardArray[i][j] == value && res;
				value = boardArray[i][j];
			}
			if(res){
				return value;
			}
		}

		// Vertical run
		for (int i = 0; i < boardArray.length ; i++)
		{
			TicTacValue value = boardArray[0][i];
			boolean res = true;
			for (int j = 0; j < boardArray[i].length; j++)
			{
				res = boardArray[j][i] == value && res;
				value = boardArray[j][i];
			}
			if(res){
				return value;
			}
		}

		// forward cross run
		for (int i = 0; i < boardArray.length ; i++)
		{
			TicTacValue value = boardArray[0][0];
			boolean res = true;
			for (int j = 0; j < boardArray[i].length; j++)
			{
				if(j==i){
					res = boardArray[i][j] == value && res;
					value = boardArray[i][j];
				}
			}
			if(res){
				return value;
			}
		}

		// backward cross run
		for (int i = 0; i < boardArray.length ; i++)
		{
			TicTacValue value = boardArray[0][0];
			boolean res = true;
			for (int j = boardArray[i].length - 1; j > -1; j--)
			{
				if(j + i + 1 == boardArray.length){
					res = boardArray[i][j] == value && res;
					value = boardArray[i][j];
				}
			}
			if(res){
				return value;
			}
		}

		return TicTacValue.EMPTY;
	}
}
