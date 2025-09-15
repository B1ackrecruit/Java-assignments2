package fraction;

import static org.junit.Assert.*;
import org.junit.*;

public class FractionTest{ 

  @Test
  public void test_initConstructor(){
    Fraction f = new Fraction(-2,5);

    assertEquals("nominator is not correct", -2, f.getNom());
    assertEquals("denominator is not correct", 5, f.getDenom());
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_initConstructor0Denom(){
    new Fraction(-2,0);
  }

  @Test
  public void test_fractionCopy(){
    // Arrange
    Fraction f = new Fraction(-3,5);

    // Act
    Fraction copy = new Fraction(f);

    // Assert
    assertEquals(-3, copy.getNom());
    assertEquals( 5, copy.getDenom());
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_fractionCopyNull(){
    new Fraction(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_setDenom0(){
    Fraction f = new Fraction(-2,5);
    f.setDenom(0);
  }

  @Test
  public void test_normalizeSign(){

    // Arrange
    Fraction f = new Fraction(2,-4);

    // Act
    f.normalizeSign();

    // Assert
    assertEquals("nominator is wrong after normalizeSign", -2, f.getNom());
    assertEquals("denominator is wrong after normalizeSign", 4, f.getDenom());

    f = new Fraction(-6,-3);
    f.normalizeSign();
    assertEquals("nominator is wrong after normalizeSign", 6, f.getNom());
    assertEquals("denominator is wrong after normalizeSign", 3, f.getDenom());

    f = new Fraction(0,-18);
    f.normalizeSign();
    assertEquals("nominator is wrong after normalizeSign",
        0, f.getNom());
    assertEquals("denominator is wrong after normalizeSign",
        1, f.getDenom());

    f = new Fraction(2,9);
    f.normalizeSign();
    assertEquals("nominator is wrong after normalizeSign",
        2, f.getNom());
    assertEquals("denominator is wrong after normalizeSign",
        9, f.getDenom());
  }

  @Test
  public void test_asReduced(){
    Fraction f = new Fraction(2,4);
    Fraction fr = f.asReduced();

    assertNotNull("asReduced must not return null", fr);
    assertNotSame("asReduced must not return same instance", f, fr);

    assertEquals("nom is wrong after asReduced", 1, fr.getNom());
    assertEquals("denom is wrong after asReduced", 2, fr.getDenom());

    fr = (new Fraction(-6,3)).asReduced();
    assertEquals("nom is wrong after asReduced", -2, fr.getNom());
    assertEquals("denom is wrong after asReduced", 1, fr.getDenom());

    fr = (new Fraction(-12,-18)).asReduced();
    assertEquals("nom is wrong after asReduced", -2, fr.getNom());
    assertEquals("denom is wrong after asReduced", -3, fr.getDenom());

    fr = (new Fraction(0,-18)).asReduced();
    assertEquals("nom is wrong after asReduced", 0, fr.getNom());
    assertEquals("denom is wrong after asReduced", -1, fr.getDenom());
  }

  @Test
  public void test_value(){
    Fraction f = new Fraction(1,3);
    assertEquals("1/3 is approx. 0.3333", 0.33333, f.value(), 1e-4);

    f = new Fraction(-21,932);
    assertEquals("-21/932 is approx. -0.02253", -0.02253, f.value(), 1e-4);

    f = new Fraction(0,-28921);
    assertEquals("0/-28921 is 0", 0.0, f.value(), 1e-10);



  }

  @Test
  public void test_equals(){

    Fraction f = new Fraction(-2,4);

    assertFalse("equals(null) must be false", f.equals(null));
    assertTrue("f.equals(f) must be true", f.equals(f));
    assertFalse("equals(\"foo\") must be false", f.equals("foo"));

    assertTrue("equals must return true on equals instances", 
        f.equals(new Fraction(-2,4)));

    assertFalse("equals must return false if nominators are different", 
        f.equals(new Fraction(-1,4)));

    assertFalse("equals must return false if denominators are different", 
        f.equals(new Fraction(-2,8)));

    assertFalse("equals must return false event if fractions are numerically equal", 
        f.equals(new Fraction(-1,2)));
  }


  @Test
  public void test_valueEquals(){

    Fraction f = new Fraction(-2,4);

    assertFalse("valueEquals(null) must be false", f.valueEquals(null));
    assertTrue("f.valueEquals(f) must be true", f.valueEquals(f));
    assertTrue("valueEquals must return true on equal instances", 
        f.valueEquals(new Fraction(-2,4)));

    assertTrue("valueEquals must return true if fractions are numerically equal", 
        f.valueEquals(new Fraction(-1,2)));

    assertFalse("valueEquals must return false on non-equal instances", 
        f.valueEquals(new Fraction(-2,78)));

    assertFalse("valueEquals must return false on non-equal instances", 
        f.valueEquals(new Fraction(5,4)));

    assertTrue("valueEquals must return true equal instances", 
        (new Fraction(0,7)).valueEquals(new Fraction(0,4)));

    Fraction f1 = new Fraction(2,4);
    Fraction f2 = new Fraction(-2,-4);

    assertTrue("valueEquals must return true equal instances", 
        f1.valueEquals(f2));

  }


}
