package FFT; /**
 * Created by ankeet on 6/10/16.
 */
import java.util.*;
public class FFTTester {

    public static void main(String[] args)
    {

        int size = 10000000;
        long[] a = {1,0,1};
        long[] b = {2,1,0};
        long[] c = FFT.multiply(a,b);
        System.out.println(Arrays.toString(c));

    }







}
