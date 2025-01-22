package Common;

public abstract class Player {

    protected final String representation;

    protected Player(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    //déclaration d'une méthode getMoveFromPlayer qui sera personnalisée dans chaque classe enfant
    public abstract int[] getMoveFromPlayer(String[][] board);
}


