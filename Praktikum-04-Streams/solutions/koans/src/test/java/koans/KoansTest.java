package koans;

import org.junit.*;
import static org.junit.Assert.*;
import static koans.Koans.*;

import java.util.Collection;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class KoansTest {

  @Test
  public void testDistinctEntries() {

    List<Integer> numbers = List.of(1,2,3,4,4,3,2,1);
    assertEquals(4, distinctEntries(numbers));

    List<String> strings = List.of("a", "b", "b", "a", "c", "d", "c");
    assertEquals(4, distinctEntries(strings));

  }

  @Test
  public void koansCountEvenNumbers(){
    assertEquals( 3, 
        countEvenNumbers(new int[] {4,1,7,2,5,8,1,11,19}));
    assertEquals( 50, 
        countEvenNumbers(IntStream.rangeClosed(1,100).toArray()));
  }

  @Test
  public void koansIntsFromStrings(){
    assertArrayEquals(
        new int[] {1,2,3,4,5,6,7},
        Koans.intsFromStrings("1","2","3","4","5","6","7"));
  }

  @Test(expected = NumberFormatException.class)
  public void koansIntsFromStringsInvalid(){
    intsFromStrings("1","2","Zwei", "3");
  }

  // @Test
  // public void koansIntsFromStringsEmpty(){
  //   assertArrayEquals(
  //       new int[] {},
  //       Koans.intsFromStrings());
  // }

  @Test
  public void koansRandomSum(){
    double[] result = randomSum(10);

    assertNotNull(result);
    assertEquals(10, result.length);

    assertEquals(0.0, result[0], 1e-15);

    for (int i = 1; i < result.length; i++){
      assertTrue( result[i]-result[i-1] >= 0 );
      assertTrue( result[i]-result[i-1] < 1 );
    }



  }



  @Test
  public void koansDotProduct(){
    double[] v1 = {0.98909510799448504783, 0.51080125558694004582, 0.72887316220670377334, 0.19018707158727165309, 0.33141459949323331442, 0.33597903390470381167, 0.39380463271529446683, 0.45792259241150492173, 0.04689367875386725810, 0.03786283831542148175};
   double[] v2 = {0.78768803550160578516, 0.1668398460391853498, 0.6060313936517445804, 0.91682136937839495883, 0.1787814552797922012, 0.79811590975788233511, 0.01019162408664592606, 0.11841618544642980502, 0.27633949342146407424, 0.05302976304691972415};

    assertEquals(1.881014359959148794, Koans.dotProduct(v1,v2), 1e-5);
  }

  @Test
  public void testStringsForLength(){

    Collection<String> strings = List.of("a", "bb", "ccc", "aaa", "b");

    Map<Integer, List<String>> result = stringsForLength(strings);

    assertNotNull(result);
    assertEquals( 3, result.size() );

    assertTrue(result.containsKey(1));
    assertTrue(result.containsKey(2));
    assertTrue(result.containsKey(3));

    assertEquals(2, result.get(1).size());
    assertEquals(1, result.get(2).size());
    assertEquals(2, result.get(3).size());

    assertTrue(result.get(1).contains("a"));
    assertTrue(result.get(1).contains("b"));
    assertTrue(result.get(2).contains("bb"));
    assertTrue(result.get(3).contains("aaa"));
    assertTrue(result.get(3).contains("ccc"));

  }


  @Test
  public void koansCollatzSeries(){
    assertArrayEquals(
        new long[] {6, 3, 10, 5, 16, 8, 4, 2},
        Koans.collatzSeries(6).limit(8).toArray());

    assertArrayEquals(
        new long[] {15, 46, 23, 70, 35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2},
        Koans.collatzSeries(15).limit(17).toArray());
  }

  @Test
  public void koansCollatzTruncated(){
    assertArrayEquals(
        new long[] {6, 3, 10, 5, 16, 8, 4, 2, 1 },
        Koans.collatzTruncated(6).limit(100).toArray());
    assertArrayEquals(
        new long[] {15, 46, 23, 70, 35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2, 1},
        Koans.collatzTruncated(15).limit(100).toArray());
  }

  @Test
  public void koansCollatzOrbit(){
    assertTrue(Koans.collatzOrbit(6));
    assertTrue(Koans.collatzOrbit(16));
    assertTrue(Koans.collatzOrbit(123));
    assertTrue(Koans.collatzOrbit(930_192_190));
  }

  @Test
  public void koansCollatzTrueForLimit(){
    assertTrue(Koans.collatzTrueForLimit(100_000));
  }

  @Test
  public void koansFibonacciStream(){
    assertArrayEquals(
        new long[] {0, 1, 1, 2, 3, 5, 8, 13, 21, 34 },
       Koans.fibonacciStream().limit(10).toArray());
  }

  
}
