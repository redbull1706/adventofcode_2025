package aoc2025;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;

public class App_Day2_PART2 extends Application{

  public String run() throws IOException {
    Iterator<String> iterator = getIterator(Day.TWO);
    double result = 0;
    while (iterator.hasNext()) {
      String line = iterator.next();
      String[] ranges = line.split(",");
      for(int i=0;i< ranges.length;i++){
        String[] parts = ranges[i].split("-");
        String start = parts[0];
        String end = parts[1];
        Range range = new Range (new BigDecimal(parts[0]),new BigDecimal(parts[1]));
        BigDecimal rangeResult = range.getMatchesPart2();
        result += rangeResult.doubleValue();
        System.out.println("Range "+start+" - "+end+" -> "+ rangeResult.toPlainString());
      }
    }
    return BigDecimal.valueOf(result).toPlainString() +" in total";
  }

}
