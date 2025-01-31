package Common;

import static java.lang.System.exit;

public abstract class BoardGame {

    protected int line;
    protected int col;
    protected boolean isNewGame = false;
    protected int actualPlayer = 1;

    private String[][] board;
    protected Player player1;
    protected Player player2;
    private Board board1;
    private Cell Cell = new Cell();


    protected int getLine(){
        return line;
    }

    protected int getCol(){
        return col;
    }

    protected String[][] getBoard(){
        return board;
    }

    protected BoardGame(int line, int col, Player player1, Player player2) {
        this.line = line;
        this.col = col;
        this.board = new String[line][col];
    }


    public abstract void display();


    // récupère les positions des players et les attribue dans le board
    public void setOwner() {
        int[]position;

        if (actualPlayer == 1) {
            position = player1.getMoveFromPlayer(board, line, col);
            board[position[0]][position[1]] = player1.getRepresentation();
            actualPlayer = 2;

        } else {
            position = player2.getMoveFromPlayer(board, line, col);
            board[position[0]][position[1]] = player2.getRepresentation() ;
            actualPlayer = 1;
        }
        isNewGame = true;
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
        if (nbCellFull == line * col) {
            exit(0);
        }
    }

    //vérifie les conditions de victoire
    public boolean isOver(int nbSymbols, int nbLines, int nbCols) {
        int i = 0;
        int j = 0;
        boolean hasWinner = false;

        // Vérification des lignes
        while (i < nbLines && !hasWinner) {
            int cpt = 1;
            j = 1; // On commence à la deuxième colonne
            while (j < nbCols && !hasWinner) {
                if (board[i][j] != "|    " && board[i][j].equals(board[i][j-1])) {
                    cpt++;
                } else {
                    cpt = 1;
                }

                // Si une séquence de nbSymbols symboles consécutifs est trouvée
                if (cpt == nbSymbols && board[i][j] != "|    ") {
                    hasWinner = true;
                    return hasWinner;
                }
                j++;
            }
            i++;
        }

        // Vérification des colonnes
        if (!hasWinner) {
            j = 0; // On redémarre pour vérifier les colonnes
            while (j < nbCols && !hasWinner) {
                i = 1; // On commence à la deuxième ligne
                int cpt = 1;
                while (i < nbLines && !hasWinner) {
                    if (board[i][j] != "|    " && board[i][j].equals(board[i-1][j])) {
                        cpt++;
                    } else {
                        cpt = 1;
                    }

                    // Si une séquence de nbSymbols symboles consécutifs est trouvée
                    if (cpt == nbSymbols && board[i][j] != "|    ") {
                        hasWinner = true;
                        return hasWinner;
                    }
                    i++;
                }
                j++;
            }
        }

        // Vérification diagonale descendante
        if (!hasWinner) {
            i = 0;
            while (i <= nbLines - nbSymbols && !hasWinner) {
                j = 0;
                while (j <= nbCols - nbSymbols && !hasWinner) {
                    int cpt = 1;
                    int k = 1;
                    while (k < nbSymbols && !hasWinner) {
                        if (board[i+k][j+k] != "|    " && board[i+k][j+k] == (board[i+k-1][j+k-1])) {
                            cpt++;
                        } else {
                            break;
                        }

                        // Si une séquence de nbSymbols symboles consécutifs est trouvée
                        if (cpt == nbSymbols && board[i+k][j+k] != "|    " && board[i+k][j+k] != "|    ") {
                            hasWinner = true;
                        }
                        k++;
                    }
                    j++;
                }
                i++;
            }
        }

        // Vérification diagonale montante
        if (!hasWinner) {
            i = nbSymbols - 1;  // Commence dans la dernière ligne où une diagonale peut commencer
            while (i < nbLines && !hasWinner) {
                j = 0;
                while (j <= nbCols - nbSymbols && !hasWinner) {
                    int cpt = 1;
                    int k = 1;
                    while (k < nbSymbols && !hasWinner) {
                        if (board[i-k][j+k] != "|    " && board[i-k][j+k] == (board[i-k+1][j+k-1])) {
                            cpt++;
                        } else {
                            break;
                        }

                        // Si une séquence de nbSymbols symboles consécutifs est trouvée
                        if (cpt == nbSymbols && board[i-k][j+k] != "|    " && board[i-k][j+k] != "|    ") {
                            hasWinner = true;
                        }
                        k++;
                    }
                    j++;
                }
                i++;
            }
        }

        return hasWinner;
    }

}






