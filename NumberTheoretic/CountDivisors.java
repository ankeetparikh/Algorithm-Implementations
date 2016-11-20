package NumberTheoretic;

import java.math.BigInteger;

/**
 * Created by ankeet on 10/30/16.
 *
 * Given an integer N, this method will return the
 * number of divisors of N.
 * Runtime = O(n^(1/3))
 *
 */
public class CountDivisors {

    public static long countDivisors(long N)
    {
        long[] pr = primes(1000000);
        long ans = 1;
        int len = pr.length;
        for(int i=0; i<len; i++)
        {
            long p = pr[i];
            if(p*p*p > N) break;
            long count = 1;
            while(N%p == 0) {
                N/=p;
                count++;
            }
            ans = ans*count;
        }

        if(new BigInteger(""+N).isProbablePrime(20)){
            ans*=2;
        }
        else
        {
            long rt = Math.round(Math.sqrt(N));
            if(rt*rt==N && new BigInteger(""+rt).isProbablePrime(20)){
                ans*=3;
            }
            else if(N!=1) ans*=4;
        }

        return ans;
    }


    public static long[] primes(int upto)
    {
        int ct = 0;
        boolean[] pr = new boolean[upto+1];
        for(int i=2; i<=upto; i++) pr[i] = true;
        for(int i=2; i<=upto; i++)
        {
            if(pr[i]){
                ct++;
                for(int j = 2*i; j<=upto; j+=i) pr[j] = false;
            }
        }
        long[] p = new long[ct];
        for(int i=2, j=0; i<=upto; i++) if(pr[i]) p[j++] = i;
        return p;
    }


    public static void main(String[] args)
    {
        long k = (long)(1e18)-1;
        System.out.println(countDivisors(k));
    }
}
