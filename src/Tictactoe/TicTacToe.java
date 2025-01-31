package Tictactoe;

import Common.Player;
import Common.Cell;
import Common.BoardGame;
import View.View;

import java.util.Scanner;
import static java.lang.System.exit;

public class TicTacToe extends BoardGame {

    private Cell Cell = new Cell();
    View view = new View();

    public TicTacToe(int line, int col) {
        super(line, col, null, null);
    }


    //affiche tableau de départ et fait appel à endGame() getMoveFromPlayer() et setOwner()
    @Override
    public void display() {

       for (int i = 0; i < getBoard().length; i++) {

            String line = "";
            view.getSentence("-----------------");

            for (int j = 0; j < getBoard().length; j++) {

                if (!isNewGame) {
                    getBoard()[i][j] = Cell.getRepresentation();
                }
                line += getBoard()[i][j];
                if (j == getBoard().length - 1) {
                    line += "|";
                }
            }
           view.getSentence(line);
        }
        String separation = "-----------------";
        view.getSentence(separation);

        endGame();

        if (isOver(3, getLine(), getCol())){
            view.getSentence("BRAVO");
            exit(0);
        }
        setOwner();
    }

    public void getPlayer() {

        Scanner scanner = new Scanner(System.in);

        view.getSentence("Combien y a t-il de joueurs humains ?");

        if (scanner.hasNextInt()) {
            int numberOfHumans = scanner.nextInt();

            switch (numberOfHumans) {
                case 0:
                   player1 = new ArtificialPlayer("| O ");
                    player2 = new ArtificialPlayer("| X ");
                    break;

                case 1:
                    player1 = new ArtificialPlayer("| 0 ");
                   player2 = new HumanPlayer("| X ");
                    break;

                case 2:
                    player1 = new HumanPlayer("| O ");
                   player2 = new HumanPlayer("| X ");
                   break;
            }
        }
    }

    public void play() {

        getPlayer();
        display();
    }

}

