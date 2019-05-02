package util;

public class DoubleUtil {
	
	public static final int DOS_DECIMALES = 2;
	
	public static double format(double value, int decimales) {
	
	    long factor = (long) Math.pow(10, decimales);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

}
