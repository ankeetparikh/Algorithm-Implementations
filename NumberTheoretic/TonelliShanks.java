package NumberTheoretic;

import java.util.Arrays;

/**
 * Created by ankeet on 7/25/16.
 */
public class TonelliShanks {

    //The Tonelli Shanks algorithm is used to solve a modular congruence of the form
    // x^2 = n (mod p)
    // where p is a prime, and n is a quadratic residue mod p



    public static long[] TonelliShanks(long n, long p)
    {
        // preprocessing step: check if n is really a quadratic residue mod p
        if(p == 2) return null;
        long check = powmod(n, (p-1)/2, p);
        if(check != 1 ) return null;

        //step 1 (these steps are from wikipedia)
        long Q = (p-1), S = 0;
        while(Q%2 == 0)
        {
            Q/=2;
            S++;
        }
        if(S == 1)
        {
            long R = powmod(n, (p+1)/4, p);
            return new long[]{R, (-R+p)%p};
        }

        //step 2
        long z = 1;
        while(LegendreSymbol(z,p) != -1) z++;
        long c = powmod(z, Q, p);

        //step 3
        long R = powmod(n,(Q+1)/2, p);
        long t = powmod(n,Q, p);
        long M = S;

        //step 4
        while(true)
        {
            if(t == 1)
            {
                break;
            }
            int i = 1;
            for(; i<M; i++)
            {
                if(powmod(t, (1L<<i) , p) == 1)
                {
                    break;
                }
            }

            long b = powmod(c, 1L<<(M-i-1), p);
            R = R * b % p;
            t = t * (b*b%p) % p;
            c = b * b % p;
            M = i;

        }

        return new long[]{R, p-R};

    }

    public static long LegendreSymbol(long a, long p)
    {
        long val = powmod(a, (p-1)/2, p);
        if(val == p-1) return -1;
        return val;
    }

    public static long powmod(long a, long b, long m)
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


    public static void main(String[] args)
    {
        long a = 10;
        long p = 13;
        long[] ans = TonelliShanks(a,p);
        System.out.println(Arrays.toString(ans));
    }

}
