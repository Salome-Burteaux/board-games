package Puissance4;

import Common.Player;
import Common.Cell;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class ArtificialPlayer extends Player {

    public ArtificialPlayer(String representation) {
        super(representation);
    }

    @Override
    public int[] getMoveFromPlayer(String[][] board, int line, int col) {
        Cell Cell = new Cell();
        int[] coordoAP = new int[2];

        Random rand = new Random();
        int APCol = rand.nextInt(col);
        coordoAP[1] = APCol;


        for (int APLine = line-1; APLine >= 0; APLine--) {
            if (board[APLine][APCol].equals(Cell.getRepresentation())) {
                coordoAP[0] = APLine;
                return coordoAP;
            }

        }
        return coordoAP;
    }
}
