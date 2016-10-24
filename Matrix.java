/**
 * Created by ankeet on 6/21/16.
 */
public class Matrix {

    public static long mod = Long.MAX_VALUE;
    public long[][] mat = null;
    public Matrix(long[][] in)
    {
        //assume it's rectangular
        mat = new long[in.length][0];
        for(int i=0; i<in.length; i++)
        {
            mat[i] = new long[in[i].length];
            for (int j = 0; j < in[i].length; j++)
            {
                mat[i][j] = in[i][j];
            }
        }

    }
    public static long[][] I(int s)
    {
        long[][] id = new long[s][s];
        for(int i=0; i<s; i++) id[i][i] = 1;
        return id;
    }
    public long[][] mult(Matrix b)
    {
        return mult(this.mat, b.mat);
    }

    public long[][] mult(long[][] b)
    {
        return mult(this.mat, b);
    }

    public static long[][] mult(long[][] a, long[][] b)
    {
        return multmod(a, b);
    }

    public static long[][] multmod(long[][] a, long[][] b)
    {
        long[][] c = new long[a.length][b[0].length];
        for(int i=0; i<a.length; i++)
        {
            for(int j = 0; j<b[0].length; j++)
            {
                for(int k = 0; k<a[0].length; k++)
                {
                    c[i][j] = (c[i][j] + a[i][k]*b[k][j]) % mod;

                }
            }
        }
        return c;
    }

    public long[][] powmod(long e, long m)
    {
        this.mod=m;
        return powmod(this.mat, e);
    }
    public static long[][] powmod(long[][] a, long e, long m)
    {
        Matrix.mod = m;
        return powmod(a,e);
    }
    public static long[][] powmod(long[][] a, long e)
    {
        long[][] c = I(a.length);
        while(e > 0)
        {
            if(e%2==1) c = multmod(c,a);
            a = multmod(a,a);
            e>>=1;

        }

        return c;
    }

}
