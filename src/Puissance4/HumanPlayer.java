package Puissance4;

import Common.Cell;
import Common.Player;
import Common.InteractionUtilisateur;
import View.View;

import javax.swing.*;
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
        Cell Cell = new Cell();
        View view = new View();
        int playerCol = 0;
        while(true) {

            view.getSentence("Sur quelle colonne souhaitez-vous poser votre pion ?");
            playerCol = interactionUtilisateur.getPlayerChoice();

            if (playerCol >= 0 && playerCol < col) {
                break;
            } else {
                view.getSentence("Veuillez entrer un nombre entre 0 et " + (col - 1));
            }
        }

        for (int playerLine = line - 1; playerLine >= 0; playerLine--) {

            if (board[playerLine][playerCol].equals(Cell.getRepresentation())) {
                coordoPlayer[0] = playerLine;
                coordoPlayer[1] = playerCol;
                board[playerLine][playerCol] = super.representation;
                return coordoPlayer;
            }
        }

    return coordoPlayer;
    }
}
