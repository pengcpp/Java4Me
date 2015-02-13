package enumsay;

/**
 * You can give each enum constant a different behavior for some method.
 * 
 * see @link{http://docs.oracle.com/javase/1.5.0/docs/guide/language/enums.html}
 *
 */
public enum EnumOperation {
	
	  PLUS   { double eval(double x, double y) { return x + y; } },
	  MINUS  { double eval(double x, double y) { return x - y; } },
	  TIMES  { double eval(double x, double y) { return x * y; } },
	  DIVIDE { double eval(double x, double y) { return x / y; } };

	  // Do arithmetic op represented by this constant
	  abstract double eval(double x, double y);
}
