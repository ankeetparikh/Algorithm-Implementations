package Graphs;

/**
 * Created by ankeet on 6/7/16.
 */
public class DisjointSet {

    static int SIZE = 100;
    static int[] P = new int[SIZE];

    public static int find(int x){
        return P[x]==x?x:(P[x] = find(P[x]));
    }

    public static void union(int p, int q){
        P[find(p)] = find(q);
    }


}
