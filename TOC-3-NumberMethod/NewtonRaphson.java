import java.io.*;
import java.math.*;

/* To finding a value of square root of "a" from Newton-Raphson Method
 * sqr of a equal x^2 - a = 0
 * Newton-Raphson Method find xn+1 = xn - f(xn)/f'(xn)
 */
public class NewtonRaphson {

	public static final int NUM_PRECISION = 2000;
	public static final MathContext PRECISION = new MathContext(NUM_PRECISION, RoundingMode.HALF_UP);
	public static final BigDecimal TWO = new BigDecimal("2");
	public static final String PATH = "c://1.txt";

	// Find a square root of c from x^2 - c = 0 when x is a answer
	// Find an value of f(x) when f(x) = x^2 - c
	public static BigDecimal function(BigDecimal x, BigDecimal c) {
		return x.pow(2, PRECISION).subtract(c, PRECISION);
	}

	// Find an value of f'(x) when f(x) = x^2 - c = 0
	public static BigDecimal functionDif(BigDecimal x) {
		return TWO.multiply(x, PRECISION);
	}

	// Count the number of matching from 2 strings
	public static int matchCount(String str, String str2) {
		int count = 0;
		for (int i = 0; i < str.length() && i < str2.length(); i++) {
			if (str.charAt(i) != str2.charAt(i))
				break;
			count++;
		}
		return count;
	}

	public static void main(String[] arg) {
		BigDecimal c = new BigDecimal(3, PRECISION);
		BigDecimal x = new BigDecimal(5, PRECISION);
		BigDecimal realValue = null;
		int matchCount = 0;
		BufferedReader br = null;
		String str = "", line = "";

		System.out.println("Starting Program");
		System.out
				.println("Finding sqr(" + c + ") using Newton-Raphson method");
		System.out.println("Number of percision is " + NUM_PRECISION);
		System.out.println("================================================");

		// Read file to get a actual value of sqr(a) from "PATH"
		try {
			br = new BufferedReader(new FileReader(PATH));
			while ((line = br.readLine()) != null) {
				str += line;
			}
			System.out.println("Read File from "+PATH+" -> success.");
			realValue = new BigDecimal(str, PRECISION);
			System.out.println("Set a actual value -> success.");
			System.out
					.println("Actual value of sqr(" + c + ") is " + realValue);
			System.out
					.println("================================================");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		// Initialize of x0
		System.out.println("Initialize x0 = " + x);

		// Find a xn+1
		for (int i = 1;; i++) {
			x = x.subtract(function(x, c).divide(functionDif(x), PRECISION), PRECISION);
			matchCount = matchCount(x.toPlainString(), realValue.toPlainString());
			System.out.println("Round " + i + " Match Count = " + matchCount);
			System.out.println("x" + i + " = " + x);
			if (matchCount >= NUM_PRECISION)
				break;
		}
		System.out.println("================================================");
		System.out.println("End of Program");
	}
}
