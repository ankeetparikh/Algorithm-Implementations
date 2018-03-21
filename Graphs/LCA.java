package Graphs;

/**
 * Created by ankeet on 1/27/17.
 *
 * This is an algorithm which can be used to compute
 * the least common ancestor of two vertices in a tree.
 * It uses the method of euler tours and sparse tables.
 * The Euler Tour is completed in O(n) time, and the
 * sparse table is constructed in O(nlogn) time. Each
 * Least Common Ancestor Query can be answered in O(1)
 * time.
 */
/**
 * Created by ankeet on 1/30/17.
 */
import java.io.*;
import java.util.*;

public class LCA {

    static FastReader in = null;
    static PrintWriter out = null;

    static int N;
    static int root = 0;
    static int eptr = 0;
    static int[] heights;
    static int[] eulertour;
    static int[] eulertourheights;
    static int[] firstocc;
    static ArrayList<Integer>[] g;

    static int[][] stable;

    static void fillheights(int curr){
        for(int child : g[curr]){
            if(heights[child] == -1){
                heights[child] = heights[curr] + 1;
                fillheights(child);
            }
        }
    }

    static void tour(int curr){
        for(int child : g[curr]){
            if(firstocc[child] == -1){
                firstocc[child] = eptr;
                eulertour[eptr] = child;
                eulertourheights[eptr] = heights[child];
                eptr++;
                tour(child);

                eulertour[eptr] = curr;
                eulertourheights[eptr] = heights[curr];
                eptr++;
            }
        }
    }

    static void buildtable(){
        for(int i=0; i<2*N-1; i++){
            stable[i][0] = i;
        }
        for(int j=1; (1<<j) <= 2*N-1; j++){
            for(int i=0; i + (1<<j) - 1 < 2*N-1; i++){
                if(eulertourheights[stable[i][j-1]] < eulertourheights[stable[i + (1<<(j-1))][j-1]]){
                    stable[i][j] =  stable[i][j-1];
                }
                else{
                    stable[i][j] = stable[i + (1<<(j-1))][j-1];
                }
            }
        }
    }

    static int query(int u, int v){
        int min = Math.min(firstocc[u], firstocc[v]);
        int max = Math.max(firstocc[u], firstocc[v]);
        int d = (int)(Math.log(max-min+1)/Math.log(2));

        int lcaind;
        if(eulertourheights[stable[min][d]] <= eulertourheights[stable[max - (1<<d)+1][d]]){
            lcaind = stable[min][d];
        }
        else{
            lcaind = stable[max - (1<<d) + 1][d];
        }
        //out.printf("Query: %d %d %d %d %d\n", u,v,min,max,lcaind);
        int lca = eulertour[lcaind];
        return lca;

    }

    public static void solve()
    {
        N = in.nextInt();
        heights = new int[N];
        eulertour = new int[2*N-1];
        eulertourheights = new int[2*N-1];
        g = new ArrayList[N];
        stable = new int[2*N-1][20];

        firstocc = new int[N];
        Arrays.fill(heights,-1);
        Arrays.fill(firstocc, -1);

        for(int nn = 0; nn<N; nn++){
            g[nn] = new ArrayList<>();
            int m = in.nextInt();
            for(int mm =1; mm<=m; mm++){
                g[nn].add(in.nextInt());
            }
        }

        firstocc[0] = 0;
        heights[0] = 1;
        eptr++;
        fillheights(0);

        eulertour[0] = 0;
        eulertourheights[0] = heights[eulertour[0]];
        tour(0);

        buildtable();
        int Q = in.nextInt();
        for(int qq = 1; qq<=Q; qq++){
            int a = in.nextInt();
            int b = in.nextInt();
            out.println(query(a,b));
        }



    }

    public static void main(String[] args)
    {
        in = new FastReader(System.in);
        out = new PrintWriter(System.out);
        solve();
        out.flush();
        out.close();

    }

    static class FastReader {

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
        public String nextLine(){

            try
            {
                return read.readLine();
            }
            catch(Exception e)
            {
                throw new RuntimeException(e);
            }
        }
        public int nextInt()
        {
            return Integer.parseInt(next());
        }
        public long nextLong()
        {
            return Long.parseLong(next());
        }
        public double nextDouble()
        {
            return Double.parseDouble(next());
        }

        public int[] nextIntArr(int n)
        {
            int[] a = new int[n];
            for(int i=0; i<n; ++i)
            {
                a[i] = nextInt();
            }
            return a;
        }

        public long[] nextLongArr(int n)
        {
            long[] a = new long[n];
            for(int i=0; i<n; ++i)
            {
                a[i] = nextLong();
            }
            return a;
        }
    }


}



