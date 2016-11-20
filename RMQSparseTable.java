/**
 * Created by ankeet on 7/8/16.
 */

import java.util.Scanner;


public class RMQSparseTable {

    static int[] arr = null;
    static int[][] spt = new int[0][0];

    public static void buildTable(int[] A)
    {
        int n = A.length;
        arr = A;
        spt = new int[n+1][20];

        for(int i=0; i<n; i++)
        {
            spt[i][0] = A[i];
        }

        for(int j=1; (1<<j)<=n; j++) {

            for(int i=0; (i+(1<<j)-1) < n; i++)
            {
                spt[i][j] = Math.min(spt[i][j-1], spt[i+(1 << (j-1))][j-1]);
            }
        }
    }

    public static int RMQ(int l, int r)
    {
        int d = (int)(Math.log(r-l+1)/Math.log(2));
        return Math.min(spt[l][d], spt[r-(1<<d)+1][d]);
    }

    public static void main(String[] args)
    {
        /*Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++) A[i] = scan.nextInt();
        buildTable(A);
        int Q = scan.nextInt();
        while(Q-->0)
        {
            int l = scan.nextInt();
            int r = scan.nextInt();
            System.out.println(RMQ(l,r));
        }*/
        int n = 10000;
        int[] log2 = new int[n+1];
        for(int i=2; i<=n; i++) log2[i] = log2[i/2]+1;
        int l = 0;
        int r = 1;
        int d1 = (int)(Math.log(r-l+1)/Math.log(2));
        int d2 = log2[r-l+1];
        System.out.println(d1 + " " + d2);


    }

}
