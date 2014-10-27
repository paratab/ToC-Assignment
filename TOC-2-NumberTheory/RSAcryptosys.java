import java.math.*;
import java.util.*;

public class RSAcryptosys {
	public static final BigInteger P2_30 = new BigInteger("1073741824");
	public static final BigInteger E = new BigInteger("65537");
	public static final BigInteger ID1 = new BigInteger("55011093");
	public static final BigInteger ID2 = new BigInteger("55011357");

	public static void main(String[] arg){
		Random rgen = new Random(System.currentTimeMillis());
		BigInteger p,q;
		
		System.out.println("RSA cryptosys Start");
		System.out.println("================================");
		
		while(true){
			p = BigInteger.probablePrime(32, rgen);
			if(p.compareTo(P2_30) == 1) break;
		}
		while(true){
			q = BigInteger.probablePrime(32, rgen);
			if(q.compareTo(P2_30) == 1 &&!p.equals(q)) break;
		}
		
		System.out.println("p = "+p);
		System.out.println("q = "+q);
		
		BigInteger n = p.multiply(q);
		BigInteger phi_n = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		
		System.out.println("\nn = "+n);
		System.out.println("phi_n = "+phi_n);
		
		BigInteger d = E.modPow(new BigInteger("-1"), phi_n);
		
		System.out.println("\nPrivate Key = ("+n+","+d+")");
		System.out.println("Public Key = ("+n+","+E+")");
		
		BigInteger m = ID1.multiply(ID2);
		BigInteger c = m.modPow(E, n);
		
		System.out.println("\nm = "+ID1 +" x "+ID2 +" = "+ m);
		System.out.println("c = "+c);
		
		BigInteger m_pi = c.modPow(d, n);
		
		System.out.println("\nm' = "+m_pi);
		
		System.out.print("\nm == m' ? ");
		if(m.equals(m_pi))System.out.println("Succeed");
		else System.out.println("Fail");
	
	}
}
