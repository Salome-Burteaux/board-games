package Puissance4;

import Common.Player;
import Common.Cell;
import View.View;


import static java.lang.System.exit;
import java.util.Scanner;

public class Puissance4 {

    private final int line = 6;
    private final int col = 7;
    private final String[][] board = new String[line][col];
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
            view.getSentence("--------------------------");

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
        String separation = "--------------------------";
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

    private void getPlayer() {

        Scanner scanner = new Scanner(System.in);

        view.getSentence("Combien y a t-il de joueurs humains ?");

        if (scanner.hasNextInt()) {
            int numberOfHumans = scanner.nextInt();

            switch (numberOfHumans) {
                case 0:
                   player1 = new ArtificialPlayer("| 👻 ");
                   player2 = new ArtificialPlayer("| 👽 ");
                    break;

                case 1:
                   player1 = new ArtificialPlayer("| 👻 ");
                   player2 = new HumanPlayer("| 👽 ");
                    break;

                case 2:
                   player1 = new HumanPlayer("| 👻 ");
                   player2 = new HumanPlayer("| 👽 ");
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
        if (nbCellFull == line * col) {
            exit(0);
        }
    }


    //conditions de victoire
    private boolean isOver(Player player) {

        for (int i = 0; i < line; i++) {
            // Vérifie les conditions horizontales
            for (int j = 0; j < col - 3; j++) {
                //comparer le contenu de la cell par rapport à la représentation du joueur
                if (board[i][j] != null && board[i][j].equals(player.getRepresentation()) && board[i][j] != null && board[i][j + 1].equals(player.getRepresentation()) &&
                        board[i][j] != null && board[i][j + 2].equals(player.getRepresentation()) && board[i][j] != null && board[i][j + 3].equals(player.getRepresentation())) {
                    return true;
                }
            }
        }

        // Vérifie les conditions verticales
        for (int i = 0; i < line - 3; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != null && board[i][j].equals(player.getRepresentation()) && board[i][j] != null && board[i + 1][j].equals(player.getRepresentation()) &&
                        board[i][j] != null && board[i + 2][j].equals(player.getRepresentation()) && board[i][j] != null && board[i + 3][j].equals(player.getRepresentation())) {
                    return true; // Victoire verticale
                }
            }
        }

        // Vérifie les diagonales descendantes
        for (int i = 0; i < line - 3; i++) {
            for (int j = 0; j < col - 3; j++) {
                if (board[i][j] != null && board[i][j].equals(player.getRepresentation()) && board[i][j] != null && board[i + 1][j + 1].equals(player.getRepresentation()) &&
                        board[i][j] != null && board[i + 2][j + 2].equals(player.getRepresentation()) && board[i][j] != null && board[i + 3][j + 3].equals(player.getRepresentation())) {
                    return true; // Victoire diagonale descendante
                }
            }
        }

        // Vérifie les diagonales montantes
        for (int i = 3; i < line; i++) {
            for (int j = 0; j < col - 3; j++) {
                if (board[i][j] != null && board[i][j].equals(player.getRepresentation()) && board[i][j] != null && board[i - 1][j + 1].equals(player.getRepresentation()) &&
                        board[i][j] != null && board[i - 2][j + 2].equals(player.getRepresentation()) && board[i][j] != null && board[i - 3][j + 3].equals(player.getRepresentation())) {
                    return true; // Victoire diagonale montante
                }
            }
        }

        return false;
    }






}