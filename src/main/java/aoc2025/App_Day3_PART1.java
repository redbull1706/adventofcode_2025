package aoc2025;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App_Day3_PART1 extends Application{
	
	
	
	public String run() throws IOException{
		
		Iterator<String> iterator = getIterator(Day.THREE);
		double joltage = 0d;
		while (iterator.hasNext()) {
			String line = iterator.next();
			String newJoltage = parseLine(line);
      System.out.println("Joltage for line: "+line+" = "+ newJoltage);
      joltage += Double.parseDouble(newJoltage);
		}
		return "result: "+ joltage;
	}

  private String parseLine(String line){
    char[] chars = line.toCharArray();
    char firstHighest, secondHighest,thirdHighest;
    firstHighest = chars[0];
    secondHighest = '0';
    for(int i=1; i<chars.length; i++){
      if(chars[i]>firstHighest && i<chars.length-1){
        firstHighest = chars[i];
        secondHighest = '0';
      }else if(chars[i]>secondHighest){
        secondHighest = chars[i];
      }
    }
    return firstHighest + String.valueOf(secondHighest);
  }

}
