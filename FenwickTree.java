/**
 * Created by ankeet on 7/9/16.
 */
public class FenwickTree {

    static int N = 0;
    static long[] f = null;

    // make the fenwick tree of size n+1 to 1 index it
    public static void build(int n)
    {
        N = n;
        f = new long[N+1];
    }
    // x[i] += d
    public static void add(int i, int d)
    {
        i++;

        for(;i<=N;i += i&(-i))
        {
            f[i]+=d;
        }
    }

    //return

    public static long sum(int i)
    {

        long res = 0;
        i++;
        for(;i>0;i -= i&(-i)) res += f[i];
        return res;
    }

    public static void main(String[] args)
    {
        int n = 500000;
        build(n);
        for(int i=0; i<n; i++) add(i,i+1);
        System.out.println(sum(n-1));
    }

}
