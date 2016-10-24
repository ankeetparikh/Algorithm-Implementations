package Strings;

import java.util.Arrays;

/**
 * Created by ankeet on 10/23/16.
 *
 * Implementation of the Knuth-Morris-Pratt Algorithm
 *
 * For reference: See CLRS section 32.4
 */
public class KMP {

    // versatile method, all it does is print the ocurrences
    // of the pattern P in the text T
    public static void printocc(char[] T, char[] P)
    {
        int n = T.length;
        int m = P.length;
        int[] pf = preffunc(P);
        int q = 0;
        for(int i=0; i<n; i++)
        {
            while(q>0 && P[q] != T[i]){
                q = pf[q-1];
            }
            if(P[q] == T[i]) q++;
            if(q == m){
                System.out.printf("Pattern found at shift %d.\n", i-m+1);
                q = pf[q-1];
            }
        }
    }

    public static int[] preffunc(char[] P)
    {
        int m = P.length;
        int[] pf = new int[m];
        pf[0] = 0;
        int k = 0;
        for(int q=1; q<m; q++)
        {
            while(k>0 && P[k] != P[q]){
                k = pf[k];
            }
            if(P[k] == P[q]) k++;
            pf[q] = k;

        }
        return pf;

    }

    public static void main(String[] args)
    {
        char[] T = "canyouhearme".toCharArray();
        char[] P = "nyou".toCharArray();

        printocc(T,P);
    }

}
