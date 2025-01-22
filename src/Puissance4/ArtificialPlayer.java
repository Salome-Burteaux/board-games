package Puissance4;

import Common.Player;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class ArtificialPlayer extends Player {

    public ArtificialPlayer(String representation) {
        super(representation);
    }

    @Override
    public int[] getMoveFromPlayer(String[][] board) {

        ArrayList<int[][]> emptyCells = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("|   ")) {
                    //chaque cellule vide est enregistrée dans emptyCells
                    emptyCells.add(new int[][]{{i, j}});
                }
            }
        }

        Random rand = new Random();

        //génère un index aléatoire entre 0 et le nombre de d'éléments dans emptyCells
        int randomIndex = rand.nextInt(emptyCells.size());

        //récupère élément à index aléatoire dans empyCells
        int[] randomCell = emptyCells.get(randomIndex)[0];

        System.out.println(Arrays.toString(randomCell));

        return randomCell;
    };
}
