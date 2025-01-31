package Common;

import Puissance4.Puissance4;
import Tictactoe.TicTacToe;
import View.View;
import GameController.GameController;


public class Main {

    public static void main(String[] args) {

        GameController gameController = new GameController();


        gameController.startGame();
    }
}