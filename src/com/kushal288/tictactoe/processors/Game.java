package com.kushal288.tictactoe.processors;

import com.kushal288.tictactoe.exceptions.InvalidMoveException;
import com.kushal288.tictactoe.beans.TicTacBoard;
import com.kushal288.tictactoe.beans.Coordinates;
import com.kushal288.tictactoe.beans.Player;
import com.kushal288.tictactoe.enums.GameState;
import com.kushal288.tictactoe.enums.TicTacValue;

public final class Game
{
	private final Player player1;
	private final Player player2;
	private final TicTacBoard board;

	private TicTacValue prevMove;
	private GameState gameState;

	public Game(Player player1, Player player2)
	{
		this.player1 = player1;
		this.player2 = player2;
		this.board = new TicTacBoard();
		this.gameState = GameState.INPROGRESS;
	}

	public boolean makeMove(final Player player, final Coordinates coordinates) throws InvalidMoveException
	{
		isValidMove(player);
		boolean result = board.insertMark(coordinates, player.getTicTacValue());
		prevMove = player.getTicTacValue();
		return result;
	}

	private void isValidMove(final Player player) throws InvalidMoveException
	{
		if(player.getTicTacValue() == prevMove){
			throw new InvalidMoveException("Player "+player.getName()+" has already moved!");
		}
	}

}
