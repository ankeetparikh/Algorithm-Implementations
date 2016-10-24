package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by ankeet on 7/21/16.
 */
public class TopSort {

    // Topsort on a directed graph
    // returns a linkedlist of the sorted values if topsort is possible
    // in the case that there is a cycle, returns null

    static ArrayList<Integer>[] adj = null;
    static LinkedList<Integer> sorted = new LinkedList<Integer>();
    static byte[] stat = null;

    public static boolean topsortRec(int curr)
    {
        stat[curr] = 1;
        for(int i=0; i < adj[curr].size(); i++)
        {
            int nei = adj[curr].get(i);
            if(stat[nei] == 0)
            {
                boolean can = topsortRec(nei);
                if(!can) return false;
            }
            if(stat[nei] == 1)
            {
                //encountered cycle
                return false;
            }
        }
        stat[curr] = 2;
        sorted.addFirst(curr);
        return true;
    }




    public static LinkedList<Integer> topsort(ArrayList<Integer>[] a)
    {
        int n = a.length;
        adj = a;
        stat = new byte[n];
        boolean cyc = false;
        for(int i=0; i<n; i++)
        {
            if(stat[i] == 0)
            {
                boolean ret = topsortRec(i);
                if(!ret)
                {
                    //encountered a cycle
                    return null;
                }
            }
        }
        return sorted;
    }

    public static void main(String[] args)
    {
        int n = 5;
        ArrayList<Integer>[] a = new ArrayList[n];
        for(int i=0; i<n; i++) a[i] = new ArrayList<>();
        //a[3].add(4);
        System.out.println(topsort(a));
    }



}
