package koans;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Koans {


public static <T> long distinctEntries(Collection<T> entries){

    return entries
      .stream() // Stream<T>
      .distinct() // Stream<T> 
      .count(); // long

  }

  public static long countEvenNumbers(int[] numbers){

    return Arrays
      .stream(numbers) // <- IntStream: 1,2,3,4,3,2,1
      .filter( n -> n % 2 == 0 ) // IntStream: 2,4,2
      .count(); // long: 3

  }

  public static int[] intsFromStrings(String... strings){

    return Arrays
      .stream(strings) // Stream<String>
      .mapToInt( string -> Integer.parseInt(string)) // IntStream
      .toArray(); // int[]

  }

  public static double[] randomSum(int n){

    return DoubleStream
      .iterate( 0.0, x -> x + Math.random() ) // DoubleStream (unbeschränkt)
      .limit(n) // DoubleStream (beschränkt)
      .toArray(); // double[]

  }

  public static double dotProduct(double[] v1, double[] v2){

    return IntStream
      .range(0, v1.length) // IntStream: 0, 1, 2, ..., (v1.length-1)
      .mapToDouble( i -> v1[i] * v2[i]) // DoubleStream: v1[0]*v2[0], v1[1]*v2[1], ...
      .sum(); // dot

  }

  public static Map<Integer, List<String>> stringsForLength(Collection<String> strings){

    return strings
      .stream()
      .collect(Collectors.groupingBy( string -> string.length() ));

  }

  public static LongStream collatzSeries(int start){

    return LongStream
      .iterate( start, n -> (n%2==0) ? (n/2) : (3*n+1) ); // LongStream (unbeschränkt)

  }

  public static LongStream collatzTruncated(int start){

    Predicate<Long> p = duplicateChecker();

    return collatzSeries(start)
      .takeWhile(i -> !p.test(i)); // 16, 8, 4, 2, 1, 4 <- Abbruch

  }

  public static <T> Predicate<T> duplicateChecker(){
    Set<T> cache = new HashSet<T>();
    return x -> !cache.add(x);
  }


  public static boolean collatzOrbit(int start){
    return collatzTruncated(start)
      .anyMatch( n -> n == 1 );
  }


  public static boolean collatzTrueForLimit(int limit){

    return IntStream // 1, 2, 3, ..., limit -> collatzOrbit(i) == true
      .rangeClosed(1, limit)
      .parallel()
      .allMatch( n -> collatzOrbit(n) );

  }

  private static class FibPair{

    private final long first;
    private final long second;

    public FibPair(long first, long second) {
      this.first = first;
      this.second = second;
    }

    public long getFirst() {
      return first;
    }

    public long getSecond() {
      return second;
    }

    public long sum() {
      return first + second;
    }

  }

  public static LongStream fibonacciStream(){

    return Stream
      .iterate( new FibPair(0,1),
          pair -> new FibPair(pair.getSecond(), pair.sum())) // Stream<FibPair>
      .mapToLong( pair -> pair.getFirst() );


  }

}
