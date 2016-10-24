package FFT;

import java.util.Arrays;

/**
 * Created by ankeet on 6/10/16.
 *
 * Crude implementation of the Fast Fourier Transform
 * In this one, the length of the input array must be
 * a power of two. Also, this algorithm has precision
 * issues because it uses double precision decimal
 * point values.
 */

public class FFT {


    public static long[] multiply(long[] a, long[] b)
    {
        int s = 1;
        while(s < a.length+b.length) s*=2;
        double[][] arr1 = new double[2][s];
        double[][] arr2 = new double[2][s];
        for(int i=0; i<a.length; i++)
        {
            arr1[0][i] = a[i];
        }

        for(int i=0; i<b.length; i++)
        {
            arr2[0][i] = b[i];
        }

        FFT(arr1, false);
        FFT(arr2, false);
        for(int i=0; i<s; i++)
        {
            double t1 = arr1[0][i]*arr2[0][i] - arr1[1][i]*arr2[1][i];
            double t2 = arr1[0][i]*arr2[1][i] + arr1[1][i]*arr2[0][i];
            arr1[0][i] = t1;
            arr1[1][i] = t2;
        }
        FFT(arr1, true);
        long[] ans = new long[s];
        for(int i=0; i<s; i++)
        {
            ans[i] = Math.round(arr1[0][i]);
        }
        return ans;

    }

    /*
    This is an iterative version of the FFT.FFT. Also, it does not
    use the Complex class, which makes it a much more efficient
    implementation.
    This algorithm is based off the pseudocode provided in CLRS
    intro to algorithms.
     */
    public static double[][] FFT(double[][] A, boolean invert)
    {
        // Bit-Reverse-Copy(a,A)
        BitReverseCopy(A);
        int n = A[0].length;
        for(int s = 1; 1<<s <= n; s++)
        {
            int m = 1<<s;
            double exp = 2*Math.PI / m * (invert? -1 : 1);
            double nrtre = Math.cos(exp);
            double nrtim = Math.sin(exp);
            for(int k=0; k<n; k+=m)
            {
                double wre = 1.0;
                double wim = 0.0;
                for(int j=0; j < m/2; j++)
                {
                    //t = w * A[k+j+m/2];
                    double tr = wre*A[0][k+j+m/2] - wim*A[1][k+j+m/2];
                    double ti = wre*A[1][k+j+m/2] + wim*A[0][k+j+m/2];

                    //u = A[k+j];
                    double ur = A[0][k+j];
                    double ui = A[1][k+j];



                    //A[k+j] = u+t;
                    A[0][k+j] = ur+tr;
                    A[1][k+j] = ui+ti;


                    //A[k+j+m/2] = u-t;
                    A[0][k+j+m/2] = ur-tr;
                    A[1][k+j+m/2] = ui-ti;


                    //w = w * w_m
                    double wnr = wre*nrtre - wim*nrtim;
                    double wni = wre*nrtim + wim*nrtre;
                    wre = wnr;
                    wim = wni;
                }
            }
        }

        if(invert)
        {
            for(int i=0; i<n; i++)
            {
                A[0][i]/=n;
                A[1][i]/=n;
            }
        }
        return A;
    }

    public static void BitReverseCopy(double[][] in)
    {
        int n = in[0].length;
        int s = Integer.numberOfLeadingZeros(n)+1;

        for(int i=0; i<n; i++)
        {
            int rev = Integer.reverse(i);
            rev >>>= s;
            if(rev > i) {
                double temp = in[0][i];
                in[0][i] = in[0][rev];
                in[0][rev] = temp;

                temp = in[1][i];
                in[1][i] = in[1][rev];
                in[1][rev] = temp;
            }
        }

    }






}
