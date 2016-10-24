import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ankeet on 7/17/16.
 *
 * Fast I/O utils for Java Competitive Programming
 */
public class FastReader {

    BufferedReader read;
    StringTokenizer tokenizer;

    public FastReader(InputStream in)
    {
        read = new BufferedReader(new InputStreamReader(in));
    }

    public String next()
    {
        while(tokenizer == null || !tokenizer.hasMoreTokens())
        {
            try{
                tokenizer = new StringTokenizer(read.readLine());
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nint()
    {
        return Integer.parseInt(next());
    }
    public long nlong()
    {
        return Long.parseLong(next());
    }
    public double ndouble()
    {
        return Double.parseDouble(next());
    }

    public int[] narr(int n)
    {
        int[] a = new int[n];
        for(int i=0; i<n; ++i)
        {
            a[i] = nint();
        }
        return a;
    }

    public long[] nlarr(int n)
    {
        long[] a = new long[n];
        for(int i=0; i<n; ++i)
        {
            a[i] = nlong();
        }
        return a;
    }
}
