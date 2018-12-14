// To start the game, enter into the game directory and type the following into the command line in order to clear the hidden word from the screen upon starting (replace yourWord with the word that you want the other player to guess):

// clear && javac Hangman.java && java Hangman yourWord

public class Hangman {
  public static void main(String[] args) {
    // This allows you to set the hidden word when you type 'java Hangman' into the command line (after you have already compiled with 'javac Hangman.java') by typing 'java Hangman *your word*' into the command line. If you do not pass in an answer, then it will throw an error and not let you play!
    if (args.length == 0) {
      System.out.println("Usage: java Hangman <answer>");
      System.err.println("Answer is required!");
      System.exit(1);
    }
    Game game = new Game(args[0]);
    Prompter prompter = new Prompter(game);
    while (game.getRemainingTries() > 0 && !game.isWon()) {
      prompter.displayProgress();
      prompter.promptForGuess();
    }
    prompter.displayOutcome();
  }
}
