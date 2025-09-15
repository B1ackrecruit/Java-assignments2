package realfunc;

@FunctionalInterface
public interface RealFunction{
  double apply(double x);

  public static RealFunction constant(double c){
    return x -> c;
  }

  public static RealFunction linear(double a, double b){
    return x -> a*x + b;
  }

  public static RealFunction sine(double a, double f){
    return x -> a*Math.sin(f*x);
  }

  public static RealFunction exp(){
    return x -> Math.exp(x);
  }

  default RealFunction addTo(RealFunction f){
    return x -> this.apply(x) + f.apply(x);
  }

  default RealFunction composeWith(RealFunction f){
    return x -> this.apply(f.apply(x));
  }

  default RealFunction multiplyWith(RealFunction... funs){
    return x -> {
      double result = this.apply(x);
      for (RealFunction f : funs){
        result *= f.apply(x);
      }
      return result;
    };
  }

  default RealFunction approxDiff(double h){
    return x -> (this.apply(x+h) - this.apply(x))/h;
  }

  default RealFunction max(RealFunction... funs){
    return x -> {
      double max = this.apply(x);

      for (RealFunction g : funs){
        max = Math.max(max, g.apply(x));
      }

      return max;
    };
  }


}
