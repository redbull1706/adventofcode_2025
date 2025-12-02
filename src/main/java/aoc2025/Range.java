package aoc2025;

import java.math.BigDecimal;

public class Range {

  public BigDecimal start;
  public BigDecimal end;
  public Range(BigDecimal start, BigDecimal end) {
    this.start = start;
    this.end = end;
  }

  public BigDecimal getMatches(){
    double result = 0;
    for(double i = start.doubleValue(); i<=end.doubleValue();i++){
      String number = BigDecimal.valueOf(i).toPlainString();
      if(number.contains(".")){
        number =  number.substring(0, number.indexOf("."));
      }
      int len = number.length();
      if(len%2==0){
        String head =number.substring(0,len/2);
        String tail = number.substring(len/2, len);
        if(head.equals(tail)){
          result+=i;
        }
//      }else{
//        String head =number.substring(0,len/2);
//        String tail = number.substring((len/2)+1, len);
//        if(head.equals(tail)){
//          result+=i;
//        }
      }
    }
    return BigDecimal.valueOf(result);
  }

  public static boolean isRepeatedPattern(String s) {
    return s.matches("(.+)\\1+");
  }


  public BigDecimal getMatchesPart2(){
    double result = 0;
    for(double i = start.doubleValue(); i<=end.doubleValue();i++){
      String number = BigDecimal.valueOf(i).toPlainString();
      if(number.contains(".")){
        number =  number.substring(0, number.indexOf("."));
      }
      int len = number.length();
      if(isRepeatedPattern(number)){
        result+=i;
      }else if(len%2==0){
        String head =number.substring(0,len/2);
        String tail = number.substring(len/2, len);
        if(head.equals(tail)){
          result+=i;
        }
        //      }else{
        //        String head =number.substring(0,len/2);
        //        String tail = number.substring((len/2)+1, len);
        //        if(head.equals(tail)){
        //          result+=i;
        //        }
      }
    }
    return BigDecimal.valueOf(result);
  }


}
