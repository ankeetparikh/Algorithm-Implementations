package Graphs;

/**
 * Created by ankeet on 11/19/16.
 *
 *
 * Given a tree (an undirected, acyclic graph),
 * this program determines the diamater of the
 * graph. The diameter is defined as the maximum
 * distance between 2 nodes in the graph.
 *
 * the graph {1 ->2 , 2->3} has a diameter of 3
 */

import java.util.*;
public class TreeDiameter {

    static int[] diam = null;
    static int[] height = null;
    static boolean[] vis = null;
    static ArrayList<Integer>[] g = null;
    public static int ComputeTreeDiameter(ArrayList<Integer>[] graph)
    {
        g = graph;
        int n = g.length;

        diam = new int[n];
        vis = new boolean[n];
        height = new int[n];

        int rootc = -1;
        for(int i=0; i<g.length; i++)
            if(g[i]!=null && g[i].size() > 1)
                rootc = i;

        dfs(rootc);
        return diam[rootc];
    }

    public static void dfs(int curr){
        vis[curr] = true;
        int maxh1 = 0;
        int maxh2 = 0;
        for(int i=0; i<g[curr].size(); ++i){
            int child = g[curr].get(i);
            if(!vis[child]){
                dfs(child);
                if(height[child] >= maxh1) {
                    maxh2 = maxh1;
                    maxh1 = height[child];
                }
                else if(height[child] >= maxh2){
                    maxh2 = height[child];
                }
            }
        }

        if(maxh1 == 0 && maxh2 == 0) diam[curr] = 1;
        if(maxh1 > 0 && maxh2 == 0) diam[curr] = Math.max(diam[curr], maxh1+1);
        else{
            diam[curr] = Math.max(diam[curr], maxh1 + maxh2 + 1);
        }
    }



}
