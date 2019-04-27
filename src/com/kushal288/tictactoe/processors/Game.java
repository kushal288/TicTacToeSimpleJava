package com.kushal288.tictactoe.processors;

import com.kushal288.tictactoe.beans.Coordinates;
import com.kushal288.tictactoe.beans.GameResult;
import com.kushal288.tictactoe.beans.Player;
import com.kushal288.tictactoe.beans.TicTacBoard;
import com.kushal288.tictactoe.enums.GameResultStates;
import com.kushal288.tictactoe.enums.GameState;
import com.kushal288.tictactoe.enums.TicTacValue;
import com.kushal288.tictactoe.exceptions.GameAlreadyCompletedException;
import com.kushal288.tictactoe.exceptions.InvalidMoveException;
import com.kushal288.tictactoe.exceptions.ValueOverridingException;

public final class Game
{
	private final Player player1;
	private final Player player2;
	private final TicTacBoard board;

	private TicTacValue prevMove;
	private GameState gameState;
	private GameResult result;

	public Game(Player player1, Player player2)
	{
		this(player1, player2, 3);
	}

	public Game(Player player1, Player player2, int boardOrder)
	{
		this.player1 = player1;
		this.player2 = player2;
		this.board = new TicTacBoard(boardOrder);
		this.gameState = GameState.INPROGRESS;
	}

	public void move(final Player player, final Coordinates coordinates)
			throws InvalidMoveException, GameAlreadyCompletedException, ValueOverridingException
	{
		isValidMove(player);
		System.out.println("Moving for [" + player + "], coordinates = [" + coordinates + "]");
		board.insertMark(coordinates, player.getTicTacValue());
		prevMove = player.getTicTacValue();
		BoardStateComputer computer = new BoardStateComputer(board);
		TicTacValue winner = computer.getWinner();
		if (winner == TicTacValue.EMPTY)
		{
			if (!computer.isMovesRemaining())
			{
				gameState = GameState.COMPLETED;
				result = new GameResult(GameResultStates.DRAWN, null);
			}
		}
		else
		{
			gameState = GameState.COMPLETED;
			result = new GameResult(GameResultStates.RESULT, winner == player1.getTicTacValue() ? player1 : player2);
		}
	}

	private void isValidMove(final Player player) throws InvalidMoveException, GameAlreadyCompletedException
	{
		if(player.getTicTacValue() == prevMove){
			throw new InvalidMoveException("Player "+player.getName()+" has already moved!");
		}
		if (gameState == GameState.COMPLETED)
		{
			throw new GameAlreadyCompletedException("Game is Already Completed!");
		}
	}

	public Player getPlayer1()
	{
		return player1;
	}

	public Player getPlayer2()
	{
		return player2;
	}

	public GameState getGameState()
	{
		return gameState;
	}

	public GameResult getResult()
	{
		return result;
	}

	public TicTacBoard getBoard()
	{
		return board;
	}

	@Override
	public String toString()
	{
		board.printBoardOnConsole();
		return "Game{" + "player1=" + player1 + ", player2=" + player2 + ", gameState=" + gameState
				+ ", result=" + result + '}';
	}
}
