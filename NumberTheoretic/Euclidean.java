package NumberTheoretic;

/**
 * Created by ankeet on 6/7/16.
 */
public class Euclidean {

    // returns the greatest common factor of a and b
    public static long Euclidean(long a, long b)
    {
        return b == 0 ? a : Euclidean(b, a % b);
    }

    // returnss the greatest common factor of a and b,
    // but does not use recursion
    public static long EuclideanNoRec(long a, long b)
    {
        while(b != 0)
        {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args)
    {
        long a = 10000000;
        long b = 125000000;
        System.out.println(Euclidean(a, b));
        System.out.println(EuclideanNoRec(a, b));
    }
}
