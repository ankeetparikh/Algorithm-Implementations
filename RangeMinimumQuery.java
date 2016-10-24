/**
 * Created by ankeet on 6/21/16.
 */

/*
    Given: an Array a = {a_0, a_1, a_2, ..., a_n}
           and a list of m queries. Each query is
           of the form
           i j
           which means that it is asking for the
           minimum element in a[i, ..., j] (the
           contiguous subarray from i to j
           inclusive).

           Can compute each query in log(n) time
 */
public class RangeMinimumQuery {

    public int[] a = null;
    public int[] st = null;
    public int inf = Integer.MAX_VALUE;
    public RangeMinimumQuery(int[] a)
    {
        this.a = a;
        int segSize = getSegmentTreeSize(a.length);
        this.st = new int[segSize];
        this.buildTree(0, 0, a.length-1);
    }

    public int getSegmentTreeSize(int N)
    {
        // returns 2 * 2 ^ ceil(log base 2 of N) - 1
        int s = 0;
        while((1<<s) < N) s++;
        return ((1 << (s+1)) - 1 );

    }

    public void buildTree(int cind, int ns, int ne)
    {
        if(ns == ne)
        {
            st[cind] = a[ns];
            return;
        }
        else
        {
            int mid = (ns+ne)/2;
            buildTree(2*cind+1, ns, mid);
            buildTree(2*cind+2, mid+1, ne);
        }

        st[cind] = Math.min(st[2*cind+1], st[2*cind+2]);


    }
    // cind = current index in tree
    // ns = starting index of segment represented by current node
    // ne = ending index of segment represented by current node
    // qe = starting index of query
    // qs = ending index of query
    public int RMQ(int qs, int qe)
    {
        return RMQ(0, 0, a.length-1, qs, qe);
    }
    public int RMQ(int cind, int ns, int ne, int qs, int qe)
    {
        if(qs <=ns && qe >=ne) return st[cind];
        if(qs > ne || qe < ns) return inf;
        int mid = (ne+ns)/2;
        return Math.min(RMQ(2*cind+1, ns, mid, qs, qe), RMQ(2*cind+2, mid+1, ne, qs, qe));

    }
}
