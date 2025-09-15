package vector;

public class Vector {

  private double x;
  private double y;

  public Vector(){
    this.x = 0;
    this.y = 0;
  }

  public Vector(Vector v){
    
    if (v == null)
      throw new IllegalArgumentException("Other vector v must not be null");

    this.x = v.x;
    this.y = v.y;
  }

  public Vector(double x, double y){
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double getMagnitude() {
    return Math.sqrt(x*x + y*y);
  }

  public void add(Vector v){
    if (v == null)
      throw new IllegalArgumentException("Other vector v must not be null");

    this.x += v.x;
    this.y += v.y;
  }

  public Vector asNormalized(){
    double mag = this.getMagnitude();

    if (!Double.isFinite(this.x / mag) || !Double.isFinite(this.y / mag))
      throw new IllegalStateException("Cannot normalize Vector as it is (approximately) a Nullvector");

    return new Vector(this.x/mag, this.y/mag);
  }

  public static Vector fromPolar(double angle, double magnitude){

    if (angle < 0 || angle > 2*Math.PI)
      throw new IllegalArgumentException("angle must be between 0 and 2*Math.PI");

    if (magnitude < 0)
      throw new IllegalArgumentException("Magnitude must be >= 0");

    return new Vector(magnitude * Math.cos(angle), magnitude * Math.sin(angle));
  }



}
