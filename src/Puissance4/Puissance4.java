package Puissance4;

import Common.BoardGame;
import Common.Player;
import Common.Cell;
import View.View;


import static java.lang.System.exit;
import java.util.Scanner;

public class Puissance4 extends BoardGame {


    private Cell Cell = new Cell();
    View view = new View();

    public Puissance4(int line, int col) {
        super(line, col, null, null);
    }


    //affiche tableau de départ et fait appel à endGame() getMoveFromPlayer() et setOwner()
    public void display() {

       for (int i = 0; i < line; i++) {

            String line = "";
            view.displayPuissance4BoardLines();

            for (int j = 0; j < col; j++) {

                if (!isNewGame) {
                    getBoard()[i][j] = Cell.getRepresentation();
                }
                line += getBoard()[i][j];

                if (j == col - 1) {
                    line += "|";
                }
            }
           view.getSentence(line);
        }
        view.displayPuissance4BoardLines();

        endGame();

        if (isOver(4, line, col)){
            view.displayCongrats();
            exit(0);
        }

        setOwner();
    }

    public void getPlayer() {

        Scanner scanner = new Scanner(System.in);

        view.displayHowManyPlayerChoice();

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



    public void play() {

        getPlayer();
        display();
    }


}