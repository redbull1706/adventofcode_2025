package aoc2025;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class App_Day1_PART2 extends Application{


  public String run() throws IOException {
    Iterator<String> moves = getIterator(Day.ONE);

    int zeroCrossings = 0;
    int position = 50;
    int row = 1;
    boolean skipPreviousZero = false;

    while (moves.hasNext()) {
      String line = moves.next().trim();

      Direction dir = Direction.fromChar(line.charAt(0));
      int movement = Integer.parseInt(line.substring(1));

      int startPosition = position;

      System.out.printf("Row %d\tMoving %s\t( %d )", row++, line, movement);

      // Hunderter direkt mitzählen
      zeroCrossings += movement / 100;
      movement = movement % 100;

      // Allgemeine Move-Methode mit Enum
      MoveResult result = move(position, movement, dir, skipPreviousZero);
      position = result.position();
      zeroCrossings += result.zeroCrossings();
      skipPreviousZero = result.skipPreviousZero();

      // Auf 0 landen zählt immer
      if (position == 0) {
        zeroCrossings++;
        skipPreviousZero = true;
      }

      System.out.printf("\t\tPosition: %d -> %d\t\tcounted: %d%n",
          startPosition, position, zeroCrossings);
    }

    return zeroCrossings + " is the solution ";
  }


  public enum Direction {
    LEFT, RIGHT;

    public static Direction fromChar(char c) {
      return (c == 'R') ? RIGHT : LEFT;
    }
  }


  public record MoveResult(int position, int zeroCrossings, boolean skipPreviousZero) {}


  private MoveResult move(int pos, int movement, Direction dir, boolean skipPrevZero) {

    int zeroCross = 0;
    int newPos = pos;

    switch (dir) {
      case RIGHT -> {
        newPos += movement;
        if (newPos > 100) zeroCross++;
        newPos = newPos % 100;
      }
      case LEFT -> {
        newPos -= movement;
        if (newPos < 0) {
          if (!skipPrevZero) zeroCross++;
          newPos += 100;
        }
      }
    }

    boolean skip = (newPos == 0);

    return new MoveResult(newPos, zeroCross, skip);
  }


}


