package GameController;

import Common.InteractionUtilisateur;
import Puissance4.Puissance4;
import Tictactoe.TicTacToe;
import View.View;


public class GameController {

    //private GameState currentState;
    private InteractionUtilisateur interactionUtilisateur;
    private View view;

    public GameController() {
        view = new View();
        interactionUtilisateur = new InteractionUtilisateur();
        //curentState = GameState.INITIALIZATION;
    }

    //demande au joueur quel jeu il veut choisir et lance la partie en fonction
    public void startGame() {

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
            default:
                view.invalidChoice();
                view.displayGamesChoice();
                break;
        }
    }
}

