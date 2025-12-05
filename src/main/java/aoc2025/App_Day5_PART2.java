package aoc2025;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class App_Day5_PART2 extends App_Day5{

  class Range{
    long start;
    long end;
    public Range(long start,long end){
      this.start = start;
      this.end = end;
    }

    public long getStart() {
      return start;
    }

    public long getEnd() {
      return end;
    }

    @Override
    public String toString() {
      return "Range{" + "start=" + BigDecimal.valueOf(start).toPlainString() + ", end=" + BigDecimal.valueOf(end).toPlainString() +" -> "+BigDecimal.valueOf(getSize()).toPlainString()+ '}';
    }

    public long getSize(){
      return end-start+1;
    }
  }

  public String run() throws IOException {
    Iterator<String> itr = getIterator(Day.FIVE);
    List<Range> ranges = new LinkedList<>();
    double count = 0;
    while (itr.hasNext()) {
      String line = itr.next();
    //  System.out.println("Parsing line: " + line);
      if(line.isEmpty()){
        break;
      }
    }
    List<Range> totalIngredientsRanges = new ArrayList<>();
    ranges.sort(Comparator.comparing(Range::getStart));
    Range current = null;
    for(Range range : ranges){
      if(totalIngredientsRanges.size() == 0){
        totalIngredientsRanges.add(range);
        current=range;

      }else{
        if(current.end>=range.start ){
          if(current.end<=range.end)
            current.end = range.end;
        }else{
          totalIngredientsRanges.add(range);
          current=range;
        }
      }
    }
    long result = 0;
    for (Range range : totalIngredientsRanges) {
      result += range.getSize();
    }
    return "the result is "+ BigDecimal.valueOf(result).toPlainString();
  }
}
