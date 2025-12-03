package aoc2025;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class App_Day3_PART2 extends Application{



  public String run() throws IOException{

    Iterator<String> iterator = getIterator(Day.THREE);
    double joltage = 0d;
    while (iterator.hasNext()) {
      String line = iterator.next();
      String newJoltage = parseLine(line);
      System.out.println("Joltage for line: "+line+" = "+ newJoltage);
      joltage += Double.parseDouble(newJoltage);
    }
    return "result: "+ BigDecimal.valueOf(joltage).toPlainString();
  }

  private String parseLine(String line){
    String currentLine = String.valueOf(line);
    char[] chars = line.toCharArray();
    char[] joltage  = initJoltage(chars);
    int pointer = 0;
    for(int i = 11; i>=0; i--){
      currentLine = line.substring(pointer++,line.length() - i);
      int maxForPosition = findMaxForPosition(currentLine);
      if(maxForPosition > -1) {
        joltage[11 - i] = currentLine.charAt(maxForPosition);
        pointer += maxForPosition;
      }else{
        pointer++;
      }
    }
    return  String.valueOf(joltage);
  }

  private int findMaxForPosition(String line) {
    char maxChar = '0';
    for (char c : line.toCharArray()) {
      if (c > maxChar) {
        maxChar = c;
      }
    }
    return line.indexOf(maxChar);
  }

  private char[] initJoltage(char[] chars){
    char[] joltage = new char[12];
    return joltage;
  }

}
