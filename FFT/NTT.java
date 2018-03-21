package FFT;

/**
 * Created by ankeet on 11/19/16.
 */
public class NTT {

    static final long mod = 7;
    static final long primroot = 3;

    public static void NTT(long[] A, boolean inv){
        int n = A.length;




        if(inv){
            long inverseVal = pow(n, mod-2, mod);
            for(int i=0; i<n; i++) A[i] = (A[i] * inverseVal) % mod;
        }
    }

    public static long[] multiply(long[] a , long[] b){
        int n = 1;
        while(n < Math.max(a.length, a.length)){
            n*=2;
        }
        n*=2;

        long[] A = new long[n];
        long[] B = new long[n];

        System.arraycopy(a,0,A,0,a.length);
        System.arraycopy(b,0,B,0,b.length);

        NTT(A,false);
        NTT(B,false);
        for(int i=0; i<n; ++i) A[i] = (A[i] * B[i]) % mod;
        NTT(A,true);
        return A;




    }

    public static long pow(long a, long b, long m){
        long res = 1;
        while(res > 0){
            if(b%2==1) res = res * a % m;
            a = a * a % m;
            b/=2;
        }
        return res%m;
    }


}
