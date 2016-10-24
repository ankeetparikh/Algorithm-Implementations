package NumberTheoretic; /**
 * Created by ankeet on 6/7/16.
 */
import java.math.BigInteger;
public class KaratsubaBigInteger {

    /*
    Uses Karatsuba Multiplication to compute
    the product of two integers a and b.
    a and b are represented as BigIntegers.

    Note: The implementation here does not outperform the
    built in multiply method for the BigInteger class. I
    wrote it just to see an implementation of Karatsuba.

     */
    public static BigInteger Karatsuba(BigInteger a, BigInteger b)
    {
        BigInteger cutoff = new BigInteger("10");
        if(a.compareTo(cutoff) < 0 || b.compareTo(cutoff) < 0)
        {
            return a.multiply(b);
        }

        int half = Math.max(a.bitLength(), b.bitLength()) / 2;

        BigInteger div = BigInteger.ONE.shiftLeft(half);
        BigInteger a0 = a.remainder(div);
        BigInteger a1 = a.shiftRight(half);
        BigInteger b0 = b.remainder(div);
        BigInteger b1 = b.shiftRight(half);

        BigInteger z2 = Karatsuba(a1, b1);
        BigInteger z0 = Karatsuba(a0, b0);
        BigInteger z1 = Karatsuba(a1.add(a0), b1.add(b0)).subtract(z2).subtract(z0);
        return z2.shiftLeft(half*2).add(z1.shiftLeft(half)).add(z0);

    }

    public static void main(String[] args)
    {

        int size = 10000;
        char[] v = new char[size]; //create a really long string of numbers
        for(int i=0; i<size; i++)
            v[i] = (char)('0'+Math.random()*10);

        String val = new String(v);
        BigInteger a = new BigInteger(val.substring(0, val.length()/2));
        BigInteger b = new BigInteger(val.substring(val.length()/2));

        double s = System.currentTimeMillis();
        BigInteger c = Karatsuba(a,b);
        double e = System.currentTimeMillis();
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("Product: "  +  c);
        System.out.println("Time for Karatsuba: " + (e-s)/1000 + " seconds");

    }
}
