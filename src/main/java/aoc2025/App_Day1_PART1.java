package aoc2025;

import java.io.IOException;
import java.util.Iterator;

public class App_Day1_PART1 extends Application{
	
	
	public String run() throws IOException{
		Iterator<String> iterator = getIterator(Day.ONE);
		int countZeroes = 0;
		int position = 50;
    int rowCount = 1;
		while (iterator.hasNext()) {
			try {
        String line = iterator.next();
        char dir = line.charAt(0);
        int movement =Integer.parseInt(line.substring(1));
        if(movement > 99){
          movement = movement%100;
        }
				if(dir == 'R'){
          position += movement;
        }else{
          position -= movement;
        }
        if(position>99){
          position = position%100;
        }
        if(position<0){
          position = position%100+100;
        }
        if(position == 0){
          countZeroes++;
        }
        System.out.print("Row "+ rowCount++ +"\t");
        System.out.print("Moving "+line+"\t( "+movement+" )");
        System.out.println("Current Position: "+position);

			}catch(NumberFormatException nfe) {

			}
		}
		return countZeroes +" is the solution ";
	}

}
