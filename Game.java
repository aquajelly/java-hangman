public class Game {
  public static final int MAX_MISSES = 7;
  private String answer;
  private String hits;
  private String misses;

  public String getAnswer() {
    return answer;
  }

  public Game(String answer) {
    this.answer = answer.toLowerCase();
    hits = "";
    misses = "";
  }

  public int getRemainingTries() {
    return MAX_MISSES - misses.length();
  }

  private char normaliseGuess(char letter) {
    if (! Character.isLetter(letter)) {
      throw new IllegalArgumentException(letter + " is not a valid letter!");
    }
    letter = Character.toLowerCase(letter);
    boolean alreadyHit = hits.indexOf(letter) != -1;
    boolean alreadyMissed = misses.indexOf(letter) != -1;
    if (alreadyHit || alreadyMissed) {
      throw new IllegalArgumentException(letter + " has already been guessed!");
    }
    return letter;
  }

  public boolean applyGuess(String letters) {
    if (letters.length() == 0) {
      throw new IllegalArgumentException("No letter found.");
    }
    return applyGuess(letters.charAt(0));
  }

  public boolean applyGuess(char letter) {
    letter = normaliseGuess(letter);
    boolean isHit = answer.indexOf(letter) != -1;
    if (isHit) {
      // This concatonates the 'hits' string by adding the correctly guessed letter to it:
      hits += letter;
    } else {
      misses += letter;
    }
    return isHit;
  }

  public String getCurrentProgress() {
    String progress = "";
    for (char letter : answer.toCharArray()) {
      char display = '-';
      if (hits.indexOf(letter) != -1) {
        display = letter;
      }
      progress += display;
    }
    return progress;
  }

  public boolean isWon() {
    return getCurrentProgress().indexOf('-') == -1;
  }
}
