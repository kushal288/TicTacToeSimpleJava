package com.kushal288.tictactoe;

import com.kushal288.tictactoe.beans.Coordinates;
import com.kushal288.tictactoe.beans.Player;
import com.kushal288.tictactoe.enums.TicTacValue;
import com.kushal288.tictactoe.exceptions.GameAlreadyCompletedException;
import com.kushal288.tictactoe.exceptions.InvalidMoveException;
import com.kushal288.tictactoe.processors.Game;

public class Main {

    public static void main(String[] args) {

        System.out.println("Tic tac toe");

        try
        {
            Player p1 = new Player("Kushal", TicTacValue.O);
            Player p2 = new Player("Aarti", TicTacValue.X);

            Game game = new Game(p1, p2);
            game.move(p1, new Coordinates(0, 2));
            System.out.println(game);
            game.move(p2, new Coordinates(1, 2));
            System.out.println(game);

            game.move(p1, new Coordinates(1, 1));
            System.out.println(game);
            game.move(p2, new Coordinates(2, 2));
            System.out.println(game);

            game.move(p1, new Coordinates(2, 0));
            System.out.println(game);
            game.move(p2, new Coordinates(1, 0));
            System.out.println(game);
        }
        catch (InvalidMoveException e)
        {
            e.printStackTrace();
        }
        catch (GameAlreadyCompletedException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
