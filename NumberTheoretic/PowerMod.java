package NumberTheoretic;

/**
 * Created by ankeet on 7/14/16.
 */
public class PowerMod {

    //returns a^b modulo m
    public static long powmod(long a, long b, long m)
    {
        if(b == 0) return 1;
        long c = powmod(a, b/2, m);
        c = c * c % m;
        if(b%2 == 1) c = c * a % m;
        return c;
    }

    public static long powmoditer(long a, long b, long m)
    {
        long res = 1;
        while(b>0)
        {
            if(b%2 == 1) res = (res * a) % m;
            a = (a * a) % m;
            b/=2;
        }
        return res%m;
    }


}
