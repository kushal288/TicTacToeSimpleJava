package com.kushal288.tictactoe.beans;

import com.kushal288.tictactoe.enums.GameResultStates;

public final class GameResult
{
	private final GameResultStates gameResultStates;
	private final Player winner;

	public GameResult(GameResultStates gameResultStates, Player winner)
	{
		this.gameResultStates = gameResultStates;
		this.winner = winner;
	}

	public GameResultStates getGameResultStates()
	{
		return gameResultStates;
	}

	public Player getWinner()
	{
		return winner;
	}

	@Override
	public String toString()
	{
		return "GameResult{" + "gameResultStates=" + gameResultStates + ", winner=" + winner + '}';
	}
}
