import java.math.*;
import java.util.*;

public class MonteCarlo {
	
	// Calculate x^2 + y^2
	public static double calX2Y2(double x, double y) {
		return Math.pow(x, 2) + Math.pow(y, 2);
	}
	
	// Check string is all digit
	public static boolean isDigit(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] arg) {
		Scanner s = new Scanner(System.in);
		MathContext precision = new MathContext(1000);
		Random rd = new Random(System.currentTimeMillis());
		BigDecimal totalSample = BigDecimal.ZERO;
		BigDecimal insideCount = BigDecimal.ZERO;
		double x, y;
		long numSample = 0;
		String str = "";
		
		System.out.println("This program is calculate a PI value by Monte Carlo Method.");
		System.out.println("===========================================================");
		while (true) {
			System.out.print("Enter amount of sample : ");
			str = s.nextLine();
			if (isDigit(str)) {
				numSample = Long.parseLong(str);
				break;
			} else {
				System.out.println("Invalid input. Please use only numberic input.");
			}
		}
		System.out.println("===========================================================");
		
		for (int i = 0;i<numSample;i++) {
			// Random x,y between 0-1
			x = rd.nextDouble();
			y = rd.nextDouble();
			
			totalSample = totalSample.add(BigDecimal.ONE);
			
			// if x^2+y^2 <= 1 it is inside a circle x^2+y^2 = 1
			if (calX2Y2(x, y) <= 1)	insideCount = insideCount.add(BigDecimal.ONE);
		}
		
		System.out.println("Total Sample = "+totalSample);
		System.out.println("Inside-circle Sample = "+insideCount);
		System.out.println("===========================================================");
		
		// The value of pi is 4 x ratio of sample inside circle / total sample
		BigDecimal ratio = insideCount.divide(totalSample, precision);
		BigDecimal piValue = BigDecimal.valueOf(4).multiply(ratio,precision);
		
		System.out.println("Ratio is "+ratio);
		System.out.println("The valus of Phi is "+piValue);
		System.out.println("===========================================================");
		System.out.println("End program");
	}
}
