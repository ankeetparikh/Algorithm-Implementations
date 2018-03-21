package Graphs;

/**
 * Created by ankeet on 12/17/16.
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Djikstra {

    static FastReader in = null;
    static PrintWriter out = null;

    static long inf = 1L<<55;
    static int n = 0, m = 0;
    static ArrayList<Edge>[] g = null;
    static long[] tent = null;
    static boolean[] vis = null;
    static int[] path = null;

    public static void solve()
    {
        n = in.nextInt();
        m = in.nextInt();
        g = new ArrayList[n+1];
        tent = new long[n+1];
        vis = new boolean[n+1];
        path = new int[n+1];
        Arrays.fill(tent, inf);
        for(int i=0; i<=n; i++) g[i] = new ArrayList<Edge>();
        for(int i=0; i<m; i++)
        {
            int u = in.nextInt();
            int v = in.nextInt();
            long w = in.nextInt();
            g[u].add(new Edge(v, w));
            g[v].add(new Edge(u, w));
        }


        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

        for(int i=2; i<=n; i++)
        {
            pq.add(new Pair(i, inf));
        }

        tent[1] = 0;
        path[1] = 1;
        int curr = 1;
        pq.add(new Pair(1, 0));
        while(!pq.isEmpty())
        {

            Pair lowest = pq.remove();
            curr = lowest.f;
            if(lowest.s == inf) break;
            if(vis[curr]) continue;

            for(int i=0; i<g[curr].size(); i++)
            {
                Edge e = g[curr].get(i);
                int nb = e.n;
                long t = tent[curr] + e.w;
                if(t < tent[nb])
                {
                    tent[nb] = t;
                    path[nb] = curr;
                    pq.add(new Pair(nb, t));
                }
            }
            vis[curr] = true;
            if(vis[n]) break;

        }

        if(tent[n] == inf)
            out.println(-1);
        else
        {
            int[] sol = new int[n+1];
            int i = n;
            int p = n;
            while(path[p] != p)
            {
                sol[i--] = p;
                p = path[p];
            }
            sol[i] = 1;
            for(;i<=n; i++)
            {
                out.print(sol[i] + " ");
            }
        }

    }
    static class Edge{
        int n;
        long w;
        public Edge(int nb, long we)
        {
            this.n = nb;
            this.w = we;
        }
    }

    static class Pair implements Comparable<Pair>{
        int f;
        long s;
        public Pair(int ff, long ss)
        {
            this.f = ff;
            this.s = ss;
        }

        @Override
        public int compareTo(Pair o) {
            long d = this.s - o.s;
            if(d < 0) return -1;
            if(d > 0) return 1;
            return 0;
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