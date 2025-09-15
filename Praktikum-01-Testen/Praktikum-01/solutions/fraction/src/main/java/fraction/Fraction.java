package fraction;

public class Fraction {

  private int nom;
  private int denom;

  public Fraction(int nom, int denom){

    if (denom == 0)
      throw new IllegalArgumentException("denom must not be 0");

    this.nom = nom;
    this.denom = denom;
  }

  public Fraction(Fraction f){

    if (f == null)
      throw new IllegalArgumentException("f must not be null");

    this.nom = f.nom;
    this.denom = f.denom;
  }

  public int getNom() { return nom; }
  public int getDenom() { return denom; }

  public void setNom(int nom) { this.nom = nom; }

  public void setDenom(int denom) {
    if (denom == 0)
      throw new IllegalArgumentException("denom must not be 0");

    this.denom = denom;
  }

  public void normalizeSign(){
    if (denom < 0){
      this.denom *= -1;
      this.nom *= -1;
    }

    if (nom == 0){
      this.denom = 1;
    }
  }

  public Fraction asReduced(){
    int gcd = gcd(abs(nom), abs(denom));
    int reducedNom = nom/gcd;
    int reducedDenom = denom/gcd;

    return new Fraction(reducedNom, reducedDenom);
  }

  public double value() {
    return ((double) nom)/denom;
  }

  @Override
  public boolean equals(Object other){
    if (other == null) 
      return false;

    if (other == this) 
      return true;

    if (other.getClass() != this.getClass())
      return false;

    Fraction otherFraction = (Fraction) other;

    if (nom != otherFraction.nom)
      return false;

    if (denom != otherFraction.denom)
      return false;

    return true;
  }
  
  public boolean valueEquals(Fraction f){
    if (f == null)
      return false;

    if (this == f)
      return true;

    // normalize both fractions by reduction 
    // and normalizing the sign
    Fraction thisNormalized = this.asReduced();
    thisNormalized.normalizeSign();

    Fraction otherNormalized = f.asReduced();
    otherNormalized.normalizeSign();

    return thisNormalized.equals(otherNormalized);
  }

  private int gcd(int p, int q){
    return (q != 0 ? gcd(q, p % q) : p);
  }

  private int abs(int p){
    return (p < 0 ? -p : p);
  }

}
