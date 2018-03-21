package NumberTheoretic; /**
 * Created by ankeet on 6/7/16.
 */
import java.util.Arrays;
public class ExtendedEuclidean {
    // sets integers x, y, g such that
    // a*x + b*y = g
    // where g = gcd(a,b);

	long x, y, g;	
    void ExtendedEuclidean(long a, long b)
    {
        long xp = 1, xn = 0;
        long yp = 0, yn = 1;
        while(b != 0)
        {
            long q = a / b;
            long r = a % b;

            long temp = b;
            b = a - b * q;
            a = temp;

            temp = xn;
            xn = xp - xn * q;
            xp = temp;

            temp = yn;
            yn = yp - yn * q;
            yp = temp;

        }
        x = xp;
        y = yp;
        g = a*x+b*y;
    }

    public static void main(String[] args)
    {
        long a = 3023492384l;
        long b = 9602349l;
        ExtendedEuclidean eed = new ExtendedEuclidean();
        eed.ExtendedEuclidean(a,b);
    	System.out.println(eed.x + " " + eed.y + " " + eed.g);
    }

}
