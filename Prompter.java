import java.util.Scanner;

public class Prompter {
  private Game game;

  public Prompter(Game game) {
    this.game = game;
  }

  public boolean promptForGuess() {
    Scanner scanner = new Scanner(System.in);
    boolean isHit = false;
    boolean isAcceptable = false;
    do {
      System.out.print("Enter a letter: ");
      String guessInput = scanner.nextLine();
      try {
        isHit = game.applyGuess(guessInput);
        isAcceptable = true;
      } catch (IllegalArgumentException iae) {
        System.out.printf("%s Please try again.\n", iae.getMessage());
      }
    } while (! isAcceptable);
    return isHit;
  }

  public void displayOutcome() {
    if (game.isWon()) {
      System.out.printf("You win! The word was, of course, %s! You had %d tries remaining!\n", game.getAnswer(), game.getRemainingTries());
    } else {
      System.out.printf("You lose. The word was %s.\n", game.getAnswer());
    }
  }

  public void displayProgress() {
    System.out.printf("You have %d tries left to solve: %s\n", game.getRemainingTries(), game.getCurrentProgress());
  }
}
