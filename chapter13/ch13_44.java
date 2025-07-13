package com.example.chapter13;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Map.Entry : 하나의 key-value 쌍을 나타낼 때 사용
 * 보통 Map을 반복문으로 돌릴 때 쓰임
 * map.entrySet()
 * entry.getKey()
 * entry.getValue()
 *
 * [참고]
 * 자바에서 Map.Entry 는 인터페이스라 직접 new로 만들수 없음.
 * new AbstractMap.SimpleEntry<>(K, 0) 이런식으로 만들어야 한다.
 */

public class ch13_44 {

	public int networkDelayTime(int[][] times, int n, int k){

		Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
		for (int[] time : times) {
			graph.putIfAbsent(time[0], new HashMap<>());
			graph.get(time[0]).put(time[0], time[1]);
		}
		//<도착지, 소요시간>
		Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
		pq.add(new AbstractMap.SimpleEntry<>(k, 0));

		Map<Integer, Integer> dist = new HashMap<>();
		while (!pq.isEmpty()) {
			//소요 시간이 가장 빠른 값 추출
			Map.Entry<Integer, Integer> cur = pq.poll();
			//우선 순위 큐의 항목이 Map.Entry이므로 순회 과정없이
			//간단히 getKey,Value로 조회 가능
			int u = cur.getKey();
			int dist_u = cur.getValue();

			//u 지점까지의 소요 시간이 아직 계산되지 않았다면 처리하자
			if(!dist.containsKey(u)){
				dist.put(u, dist_u);

				//u지점을 출발지로 한 경로 있으면 처리
				if (graph.containsKey(u)) {
					for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
						//u 지점까지 소요시간 + u 지점을 출발지로 한 도착지까지의 소요시간
						int alt = dist_u + v.getValue();
						//우선순위 큐에 (도착지, 소요 시간)을 삽입
						pq.add(new AbstractMap.SimpleEntry<>(v.getKey(), alt));
					}
				}
			}


		}
		if(dist.size()==n){
			return Collections.max(dist.values());
		}
		return -1;

	}

}
