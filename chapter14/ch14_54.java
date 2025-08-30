package com.example.chapter14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ch14_54 {
	public class TreeNode<T> {
		public TreeNode<T> right;
		public TreeNode<T> left;
		public T value;

		public TreeNode(Object value) {
		}

	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges){
		if(n==1)
			return List.of(0);

		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : edges) {
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.putIfAbsent(edge[1], new ArrayList<>());
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		List<Integer> leaves = new ArrayList<>();
		for(int i=0;i<n;i++){
			if (graph.get(i).size() == 1) {
				leaves.add(i);
			}
		}

		while(n>2){
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for (int leaf : leaves) {
				int neighbor = graph.get(leaf).get(0);
				graph.get(neighbor).remove((Object)leaf);
				if(graph.get(neighbor).size()==1)
					newLeaves.add(neighbor);
			}
			leaves=newLeaves;
		}
		return leaves;

	}

}
