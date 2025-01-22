package Tittactoe;

import Common.Player;
import Common.Cell;
import Common.BoardGame;
import View.View;

import java.util.Scanner;
import static java.lang.System.exit;

public class TicTacToe extends BoardGame {

    private final int size = 3;
    private final String[][] board = new String[size][size];
    private boolean isNewGame = false;
    private int actualPlayer = 1;
    private Player player1;
    private Player player2;
    private Cell Cell = new Cell();
    View view = new View();




    //affiche tableau de départ et fait appel à endGame() getMoveFromPlayer() et setOwner()
    private void display() {

       for (int i = 0; i < board.length; i++) {

            String line = "";
            view.getSentence("-------------");

            for (int j = 0; j < board.length; j++) {

                if (!isNewGame) {

                    board[i][j] = Cell.getRepresentation();

                }

                line += board[i][j];

                if (j == board.length - 1) {

                    line += "|";
                }


            }
           view.getSentence(line);
        }
        String separation = "-------------";
        view.getSentence(separation);

        endGame();
        if (isOver()) {
            view.getSentence("BRAVO");

            exit(0);
        }


        setOwner();


    }

    private void getPlayer() {

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

    // récupère les positions des players et les attribue dans le board
    private void setOwner() {
        int[]position;

        if (actualPlayer == 1) {
            position = player1.getMoveFromPlayer(board);
            board[position[0]][position[1]] = player1.getRepresentation();
            actualPlayer = 2;

        } else {

            position = player2.getMoveFromPlayer(board);
            board[position[0]][position[1]] = player2.getRepresentation() ;
            actualPlayer = 1;
        }

        isNewGame = true;
        display();

    }


    public void play() {

        getPlayer();
        display();
    }

    //vérifie le nombre de cases vides restantes
    private void endGame() {
        int nbCellFull = 0;

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != "|   " && board[i][j] != "   |") {
                    nbCellFull += 1;
                }

                if (board[i][j] != "|   " && board[i][j] != "   |") {}
            }
        }
        if (nbCellFull == size * size) {
            exit(0);
        }
    }


    //conditions de victoire
    private boolean isOver() {

        if(board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != "|   ") {

            return true;
        }

        if(board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != "|   ") {

            return true;
        }

        if(board[2][0] == board[2][1] && board[2][0] == board[2][2] && board[2][0] != "|   ") {

            return true;
        }

        if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != "|   ") {

            return true;
        }

        if(board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != "|   ") {

            return true;
        }

        if(board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != "|   ") {

            return true;
        }

        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != "|   ") {

            return true;
        }

        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != "|   ") {

            return true;
        }

        return false;
    }


}

