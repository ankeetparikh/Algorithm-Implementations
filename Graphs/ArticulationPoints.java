/*
	Determine the articulation points in a graph.
	An articulation point is a vertex whose removal (the 
	vertex itself, and the edges connected to it)
	will result in an increase in the number of connected 
	components in the graph.
*/

/*
	Note: this should be put in a class, and then 
	called with an instance of that class
*/

import java.util.*;

public class ArticulationPoints{
	
	// make N the number of nodes
	// make it larger than necessary!
	// 1 indexed
	int INF = Integer.MAX_VALUE;
	int N = 100000; 
	ArrayList<Integer>[] g = new ArrayList[N];
	int[] discovery = new int[N];
	int[] low       = new int[N];
	int[] parentdfs = new int[N];
	
	boolean[] vis = new boolean[N];
	boolean[] ap = new boolean[N];
	
	public void dfs(int vertex, int time){
		vis[vertex] = true;
		discovery[vertex] = low[vertex] = time;
		int numchildren = 0;
		for(int child : g[vertex]){
			if(!vis[child]){
				numchildren++;
				parentdfs[child] = vertex;
				dfs(child, time+1);
				low[vertex] = Math.min(low[vertex], low[child]);
				if(parentdfs[vertex] == -1 && numchildren > 1){
					ap[vertex] = true;
				}
				if(parentdfs[vertex] != -1 && low[child] > discovery[vertex]){
					ap[vertex] = true;
				}
				
			}
			else{
				if(parentdfs[vertex] != child){
					low[vertex] = Math.min(low[vertex], discovery[child]);
				}
			}
		}
	}
	
	public void init(){
		Arrays.fill(vis, false);
		Arrays.fill(low, INF);
		Arrays.fill(parentdfs, -1);
	}
}