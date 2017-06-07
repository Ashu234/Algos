package com.algo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DFS {
	
	private int vertexCount;
	private List<Integer> adjList[]; 
	private static List<Integer> visited;
	
	public DFS(int vertexCount)
	{
		this.vertexCount = vertexCount;
		visited = new ArrayList<Integer>();
		adjList = new LinkedList[this.vertexCount];
		
		for(int i = 0;i<this.vertexCount;i++)
		{
			adjList[i] = new LinkedList<Integer>();
		}
		
	}
	
	public void addEdge(int vertex, int node)
	{
		adjList[vertex].add(node);
	}
	
	public void dfSearch(int vertex, List visited)
	{
		
		if(visited.contains(vertex))
		{
			return;
		}
		visited.add(vertex);
		Iterator<Integer> adjIter = adjList[vertex].iterator();
		while(adjIter.hasNext())
		{
			int n = adjIter.next();
			dfSearch(n, visited);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFS g = new DFS(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        g.dfSearch(2, visited);
        
        System.out.println("print dfs :");
        Iterator setItr = visited.iterator();
        while(setItr.hasNext())
        {
        	System.out.print(setItr.next() + " ");
        }

	}


}










