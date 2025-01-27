package Common;

import Puissance4.Puissance4;
import Tittactoe.TicTacToe;
import View.View;



public class Main {

    static InteractionUtilisateur interactionUtilisateur;
    static View view;


    public static void main(String[] args) {

        view = new View();
        interactionUtilisateur = new InteractionUtilisateur();

        view.getSentence("A quel jeu voulez-vous jouer ?");
        view.getSentence("1 : Puissance 4");
        view.getSentence("2 : TicTacToe");
        view.getSentence("3 : Gomoku");

        switch (interactionUtilisateur.getPlayerChoice()) {
            case 1:
                Puissance4 puissance4 = new Puissance4(6,7);
                puissance4.play();
                break;
            case 2:
                TicTacToe ticTacToe = new TicTacToe(3,3);
                ticTacToe.play();
                break;
            case 3:
                //Gomoku gomoku = new Gomoku();
                //gomoku.play();
                break;
        }

        //TicTacToe ticTacToe = new TicTacToe();
        //ticTacToe.play();

        //Puissance4 puissance4 = new Puissance4();
        //puissance4.play();



    }
}