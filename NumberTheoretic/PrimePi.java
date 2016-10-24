package NumberTheoretic;

import java.util.HashMap;

/**
 * Created by ankeet on 8/30/16.
 */
public class PrimePi {
    //returns the number of prime numbers less than or equal to n
    public static long PrimePi(long n)
    {
        int r = (int)Math.sqrt(n);
        long[] V = new long[r + r];
        int ct = 0;
        for(int i=1; i<r+1; i++)
        {
            V[ct++] = n/i;
        }
        for(long i = V[ct-1]-1; i>0; i--)
        {
            V[ct++] = i;
        }


        HashMap<Long, Long> S = new HashMap<Long, Long>();
        for(int i=0; i<V.length; i++)
            S.put(V[i], V[i]-1);
        for(long p = 2; p<r+1; p++)
        {
            if(S.get(p) > S.get(p-1))
            {
                long sp = S.get(p-1);
                long p2 = p*p;
                for(int v = 0; v<V.length; v++)
                {
                    if(V[v]<p2) break;
                    S.put(V[v], S.get(V[v])- (S.get(V[v]/p) - sp));
                }
            }
        }

        return S.get(n);

    }

    public static void main(String[] args)
    {
        System.out.println(PrimePi(500000000000L));

    }
}
