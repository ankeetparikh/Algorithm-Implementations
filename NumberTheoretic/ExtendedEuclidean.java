package NumberTheoretic; /**
 * Created by ankeet on 6/7/16.
 */
import java.util.Arrays;
public class ExtendedEuclidean {
    // returns integers x and y such that
    // a*x + b*y = gcd(a,b)
    // array returned: {x, y}

    public static long[] ExtendedEuclidean(long a, long b)
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
        return new long[]{xp, yp};
    }

    public static void main(String[] args)
    {
        long a = 3023492384l;
        long b = 9602349l;
        System.out.println(Arrays.toString(ExtendedEuclidean(a, b)));
    }

}
