package aoc2025;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class App_Day4_PART2 extends Application{

  private class Triple{
    int x, y;
    char sign;
    Triple(int x, int y, char sign){
      this.x = x;
      this.y = y;
      this.sign = sign;
    }

    @Override
    public String toString() {
      return "(" + x + "," + y + ", " + sign + ")";
    }
  }
  //int gridSize = 10;
  int gridSize = 138;
  int result = 0;
  public String run() throws IOException{

    Iterator<String> iterator = getIterator(Day.FOUR);
    char[][] grid =  new char[gridSize][gridSize];
    int counter = 0;
    while (iterator.hasNext()) {
      String line = iterator.next();
      char[] lineChars = line.toCharArray();
      grid[counter++] = lineChars;
    }
    long previous;
    long current = getAmountOfRoles(grid);
    do{
      previous  = current;
      current = doRemove(grid);
    }while(current < previous);
    return "result: "+ result;
  }

  private long getAmountOfRoles(char[][] grid){
    long count = 0;
    for(int y = 0; y < gridSize;y++) {
      for (int x = 0; x < gridSize; x++) {
        if(grid[y][x] == '@') count++;
      }
    }
    return count;
  }

  private long doRemove(char[][] grid) {
    List<Triple> canBeRemoved = new ArrayList<>();
    for(int y = 0; y < gridSize;y++){
      for(int x = 0; x < gridSize;x++){
        Triple current = new  Triple(x,y, grid[y][x]);
        if(current.sign == '@'){
          List<Character> adjacents = getAdjacents(current, grid);
          long accNeighbourRoles = adjacents.stream().filter(c -> c == '@').count();
          System.out.println(current+" has rolesAdjacents "+ accNeighbourRoles);
          if(accNeighbourRoles<4){
            canBeRemoved.add(current);
          }
        }
      }
    }
    result+=canBeRemoved.size();
    canBeRemoved.forEach(t-> grid[t.y][t.x] = '.');
    return getAmountOfRoles(grid);
  }

  private List<Character> getAdjacents(Triple current,char[][] grid){
    List<Character> adjacents = new ArrayList<Character>();
    if(current.y==0){
      getNeighbours(false, current.x, grid[current.y+1], adjacents);
    }else if(current.y==gridSize-1){
      getNeighbours(false, current.x, grid[current.y-1], adjacents);
    }else{
      getNeighbours(false, current.x, grid[current.y-1], adjacents);
      getNeighbours(false, current.x, grid[current.y+1], adjacents);
    }
    getNeighbours(true, current.x, grid[current.y], adjacents);
    return adjacents;
  }

  private void getNeighbours(boolean isSameLine, int x,  char[] gridLine, List<Character> adjacents){
    if(x>0) {
      adjacents.add(gridLine[x - 1]);
    }
    if(!isSameLine) {
      adjacents.add(gridLine[x]);
    }
    if(x<gridSize-1) {
      adjacents.add(gridLine[x + 1]);
    }
  }

}
