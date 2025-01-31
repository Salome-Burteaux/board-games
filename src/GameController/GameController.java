package GameController;

import Common.InteractionUtilisateur;
import Puissance4.Puissance4;
import Tictactoe.TicTacToe;
import View.View;


public class GameController {

    static InteractionUtilisateur interactionUtilisateur;
    static View view;

    public GameController() {
        view = new View();
        interactionUtilisateur = new InteractionUtilisateur();
    }

    public static void startGame(String action) {


        switch (action) {
            case "userChooseGame":
                view.displayGamesChoice();

                switch (interactionUtilisateur.getPlayerChoice()) {
                    case 1:
                        Puissance4 puissance4 = new Puissance4(6,7);
                        puissance4.play();
                        break;
                    case 2:
                        TicTacToe ticTacToe = new TicTacToe(3,3);
                        ticTacToe.play();
                        break;
                }
                break;

            case "userChoosePlayer":
                ;
                break;


        }

    }

}
