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

    public TicTacToe(int line, int col) {
        super(line, col);
    }


    //affiche tableau de départ et fait appel à endGame() getMoveFromPlayer() et setOwner()
    public void display() {

       for (int i = 0; i < board.length; i++) {

            String line = "";
            view.getSentence("-----------------");

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
        String separation = "-----------------";
        view.getSentence(separation);

        endGame();
        if (isOver(player1)) {
            view.getSentence("BRAVO");
            exit(0);
        }
        else if (isOver(player2)) {
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

    // récupère les positions des players et les attribue dans le board
    public void setOwner() {
        int[]position;

        if (actualPlayer == 1) {
            position = player1.getMoveFromPlayer(board, size, size);
            board[position[0]][position[1]] = player1.getRepresentation();
            actualPlayer = 2;

        } else {

            position = player2.getMoveFromPlayer(board, size, size);
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
    public void endGame() {
        int nbCellFull = 0;

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != Cell.getRepresentation()) {
                    nbCellFull += 1;
                }
            }
        }
        if (nbCellFull == size * size) {
            exit(0);
        }
    }


    //conditions de victoire
    public boolean isOver(Player player) {

        // vérifie lignes
        for (int i = 0; i < size; i++) {
            if(board[i][0].equals(player.getRepresentation()) && board[i][1].equals(player.getRepresentation()) && board[i][2].equals(player.getRepresentation())) {
                return true;
            }
        }

        // vérifie colonnes
        for (int i = 0; i < size; i++) {
            if(board[0][i].equals(player.getRepresentation()) && board[1][i].equals(player.getRepresentation()) && board[2][i].equals(player.getRepresentation())) {
                return true;
            }
        }

        //vérifie diagonale descendante
        if(board[0][0].equals(player.getRepresentation()) && board[1][1].equals(player.getRepresentation()) && board[2][2].equals(player.getRepresentation())) {
            return true;
        }

        // vérifie diagonale montante
        if(board[2][0].equals(player.getRepresentation()) && board[1][1].equals(player.getRepresentation()) && board[0][2].equals(player.getRepresentation())) {
            return true;
        }

        return false;
    }


}

