package com.example.chapter13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ch13_45 {

	public int findCheapestPrice(int n, int[][] flights,int src, int dst, int k){
		Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
		for (int[] flight : flights) {
			graph.putIfAbsent(flight[0], new HashMap<>());
			graph.get(flight[0]).put(flight[0], flight[1]);
		}
		//(도착지, 비용, 진행 경로)
		Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
		pq.add(Arrays.asList(src, 0, 0));

		//타임아웃을 방지하기 우히ㅏㄴ 한 번 방문한 경로는 저장해두는 맵
		Map<Integer, Integer> visited = new HashMap<>();

		while (!pq.isEmpty()) {
			List<Integer> cur = pq.poll();
			int u=cur.get(0);
			int price_u = cur.get(1);
			int k_visited=cur.get(2);

			if (u == dst) {
				return price_u;
			}
			visited.put(u, k_visited);

			if (k_visited <= k) {
				k_visited+=1;
				//u 지점을 출발지로 한 경로가 있다면 시작
				if (graph.containsKey(u)) {
					for(Map.Entry<Integer,Integer> v:graph.get(u).entrySet()){
						if (!visited.containsKey(v.getKey()) || k_visited < visited.get(v.getKey())) {
							int alt= price_u+v.getValue();
							pq.add(Arrays.asList(v.getKey(), alt, k_visited));
						}

					}
				}
			}
		}
		return -1;
	}
}
