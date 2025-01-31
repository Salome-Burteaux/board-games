package View;

public class View {

    public View() {

    }

    public void getSentence (String sentence){
        System.out.println(sentence);
    }

    public void displayGamesChoice() {
        System.out.println("A quel jeu voulez-vous jouer ? 1 : Puissance 4, 2 : TicTacToe");
    }

    public void displayPuissance4BoardLines() {
        System.out.println("------------------------------------");
    }

    public void displayCongrats() {
        System.out.println("BRAVO !");
    }

    public void displayHowManyPlayerChoice() {
        System.out.println("Combien y a t-il de joueurs humains ?");
    }



}
