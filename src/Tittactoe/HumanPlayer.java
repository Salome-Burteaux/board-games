package Tittactoe;

import Common.InteractionUtilisateur;
import Common.Player;
import View.View;

import java.util.Arrays;

public class HumanPlayer extends Player {

    public HumanPlayer(String representation) {
        super(representation);
    }

    //demande les coordonnées et les stockent
    @Override
    public int[] getMoveFromPlayer(String[][] board, int line, int col) {

        int[] coordoPlayer = new int[2];
        InteractionUtilisateur interactionUtilisateur = new InteractionUtilisateur();
        View view = new View();

        while(true) {

            view.getSentence("Sur quelle ligne souhaitez-vous poser votre pion ?");
            line = interactionUtilisateur.getPlayerChoice();

            if (line >= 0 && line < board.length) {
                break;
            } else {
                view.getSentence("Veuillez entrer un nombre entre 0 et " + (board.length - 1));
            }
        }

        while (true) {
            view.getSentence("Sur quelle colonne souhaitez-vous poser votre pion ?");
            col = interactionUtilisateur.getPlayerChoice();

            if (col >= 0 && col < board[0].length) {
                break;
            } else {
                view.getSentence("Veuillez entrer un nombre entre 0 et " + (board[0].length - 1));
            }
        }

        if (board[line][col] == "|   ") {

            coordoPlayer[0] = line;
            coordoPlayer[1] = col;
            view.getSentence("coordoPlayer : " + Arrays.toString(coordoPlayer));

        } else {
            view.getSentence("L'emplacement est déjà occupé.");
        }

        return coordoPlayer;
    };
}
