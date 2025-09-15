package vector;

import static org.junit.Assert.*;
import org.junit.*;

public class VectorTest {

  @Test
  public void test_defaultConstructor(){
    Vector v = new Vector();

    assertEquals(
        "Default constructor must return null vector",
        0.0, v.getX(), 1e-10);

    assertEquals(
        "Default constructor must return null vector",
        0.0, v.getY(), 1e-10);
  }

  @Test
  public void test_initConstructor(){

    Vector v = new Vector(Math.PI, Math.E);

    assertEquals(
        "Init constructor must correctly initialize x",
        Math.PI, v.getX(), 1e-10);

    assertEquals(
        "Init constructor must correctly initialize y",
        Math.E, v.getY(), 1e-10);

  }

  @Test
  public void test_copyContructor(){
    Vector v = new Vector(Math.PI, Math.E);

    Vector w = new Vector(v);

    assertEquals(
        "Copy constructor must correctly copy x",
        v.getX(), w.getX(), 1e-10);

    assertEquals(
        "Copy constructor must correctly copy y",
        v.getY(), w.getY(), 1e-10);
    
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_copyContructorNull(){
    new Vector(null);
  }

  @Test
  public void test_getMagnitude(){
    Vector v = new Vector(3,4);

    assertEquals("Vector(3,4) has magnitude of 5",
        5, v.getMagnitude(), 1e-10);

    v = new Vector(-2,5);
    assertEquals("Vector(-2,5) has magnitude of approx 5.385164",
        5.385164, v.getMagnitude(), 1e-4);

  }

  @Test
  public void test_asNormalized(){
    Vector v = new Vector(-2,5);
    Vector vn = v.asNormalized();

    assertNotNull("asNormalized must not return null", vn);
    assertNotSame("asNormalized must return different instance", vn, v);

    assertEquals("magnitude of vector from asNormalized must be approx. 1",
        1.0, vn.getMagnitude(), 1e-8);

    assertEquals("x coordinate of normalized version of (-2,5) must be approx. -0.37139",
        -0.37139, vn.getX(), 1e-4);

    assertEquals("y coordinate of normalized version of (-2,5) must be approx. 0.92847",
        0.92847, vn.getY(), 1e-4);

  }

  @Test
  public void test_add(){
    Vector v = new Vector(-2,5);
    v.add(new Vector(3.1415, -2.18));

    assertEquals("x coordinate after add is wrong",
        1.1415, v.getX(), 1e-5);

    assertEquals("y coordinate after add is wrong",
        2.82, v.getY(), 1e-5);

  }

  @Test(expected = IllegalArgumentException.class)
  public void test_addGameNull(){
    Vector v = new Vector(-2,5);
    v.add(null);
  }


  @Test
  public void test_fromPolar(){

    Vector v = Vector.fromPolar(1.324, 3.21);

    assertEquals(
        "Magnitude from fromPolar is wrong",
        3.21, v.getMagnitude(), 1e-5);

    assertEquals(
        "x coordinate from fromPolar is wrong",
        0.78419856, v.getX(), 1e-5);

    assertEquals(
        "y coordinate from fromPolar is wrong",
        3.1127371591, v.getY(), 1e-5);

  }

  @Test(expected = IllegalArgumentException.class)
  public void test_fromPolarAngleNegative(){
    Vector.fromPolar(-0.1, 2.1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_fromPolarAngleTooLarge(){
    Vector.fromPolar(2*Math.PI+1.0, 2.1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_fromPolarMagnitudeNegative(){
    Vector.fromPolar(0.21, -0.1);
  }


}
