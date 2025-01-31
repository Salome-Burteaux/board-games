package Common;

import GameController.GameController;

public abstract class Board {

protected int col;
protected int line;
protected Cell[][] board;


protected int getLine() {
    return line;
}

protected int getCol() {
    return col;
}

protected Cell[][] getBoard() {
    return board;
}

protected Cell[][] BoardGame(int line, int col) {
    this.line = line;
    this.col = col;
    board = new Cell[line][col];

    for(int i = 0; i < line; i++) {
        for(int j = 0; j < col; j++) {
            board[i][j] = new Cell();
        }
    }
    return board;

}





}