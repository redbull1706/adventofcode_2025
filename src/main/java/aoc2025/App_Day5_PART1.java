package aoc2025;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App_Day5_PART1 extends App_Day5{
	
	class Range{
    float start;
    float end;
    public Range(float start,float end){
      this.start = start;
      this.end = end;
    }
  }
	
	public String run() throws IOException {
		Map<String, LinkedList<String>> stack = initializeStack();
		Iterator<String> itr = getIterator(Day.FIVE);
    boolean isIngredientsList = false;
    List<Range> ranges = new LinkedList<>();
    double count = 0;
		while (itr.hasNext()) {
			String line = itr.next();
      System.out.println("Parsing line: " + line);
      if(line.isEmpty()){
        isIngredientsList = true;
        continue;
      }
      if(!isIngredientsList){
        String[] borders = line.split("-");
        ranges.add(new Range(Float.parseFloat(borders[0]),Float.parseFloat(borders[1])));
      }else{
        Float ingredient =  Float.parseFloat(line);
        if(ranges.stream().anyMatch(r -> r.start <= ingredient && ingredient <= r.end)){
          count++;
        }
      }

		}
		return "the result is "+count;
	}
}
