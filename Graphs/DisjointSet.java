package Graphs;

/**
 * Created by ankeet on 6/7/16.
 */
public class DisjointSet {

    public int[] parent;
    private int[] rank; //for Union speedup
    public int[] setSize;
    public DisjointSet(int size)
    {
        this.parent = new int[size];
        this.rank = new int[size];
        this.setSize = new int[size];
        for(int i=0; i<size; i++)
        {
            this.parent[i] = i;
            this.rank[i] = 0;
            this.setSize[i] = 1;
        }
    }

    public int Find(int i)
    {
        return this.parent[i] = (this.parent[i] == i ? i : Find(this.parent[i]));
    }

    public void Union(int p, int q)
    {
        int prep = Find(p);
        int qrep = Find(q);
        if(prep == qrep) return; // already in the same set

        if(this.rank[prep] < this.rank[qrep])
        {
            this.parent[prep] = qrep;
            this.setSize[qrep] += this.setSize[prep];
        }
        else if(this.rank[prep] > this.rank[qrep])
        {
            this.parent[qrep] = prep;
            this.setSize[prep] += this.setSize[qrep];
        }
        else
        {
            this.parent[prep] = qrep;
            this.setSize[qrep] += this.setSize[prep];
            this.rank[qrep]++;
        }
    }


}
