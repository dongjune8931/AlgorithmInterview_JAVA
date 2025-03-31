package com.example.programmers.week1;

import java.util.*;

class Solution2 {
	public int[] solution(int[][] edges) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		Map<Integer, Integer> in = new HashMap<>();
		Map<Integer, Integer> out = new HashMap<>();

		// 1. 그래프와 차수 정보 구성
		for (int[] edge : edges) {
			int from = edge[0];
			int to = edge[1];

			graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
			in.put(to, in.getOrDefault(to, 0) + 1);
			out.put(from, out.getOrDefault(from, 0) + 1);
		}

		// 2. 생성된 정점 찾기 (진입 차수 0, 진출 차수 2 이상)
		int generatedNode = -1;
		for (int node : out.keySet()) {
			if (!in.containsKey(node) && out.get(node) >= 2) {
				generatedNode = node;
				break;
			}
		}

		// 3. 방문 체크 및 그래프 유형 카운트
		Set<Integer> visited = new HashSet<>();
		int donut = 0;
		int bar = 0;
		int eight = 0;

		for (int next : graph.get(generatedNode)) {
			if (visited.contains(next)) continue;

			Queue<Integer> queue = new LinkedList<>();
			queue.add(next);
			visited.add(next);

			int nodeCount = 0;
			int edgeCount = 0;
			boolean hasEndNode = false;

			while (!queue.isEmpty()) {
				int cur = queue.poll();
				nodeCount++;

				int outDeg = out.getOrDefault(cur, 0);
				edgeCount += outDeg; // 현재 노드의 간선 수 누적

				if (outDeg == 0) hasEndNode = true;

				if (graph.containsKey(cur)) {
					for (int adj : graph.get(cur)) {
						if (!visited.contains(adj)) {
							visited.add(adj);
							queue.add(adj);
						}
					}
				}
			}

			if (edgeCount > nodeCount) {
				eight++;
			} else if (hasEndNode) {
				bar++;
			} else {
				donut++;
			}
		}

		return new int[]{generatedNode, donut, bar, eight};
	}


	public int[] solution2(int[][] edges) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		int[] in = new int[1_000_001];
		int[] out = new int[1_000_001];


		for (int[] edge : edges) {
			int from = edge[0];
			int to = edge[1];

			graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
			in[to]++;
			out[from]++;
		}


		int root = -517;
		for (int i = 1; i < in.length; i++) {
			if (in[i] == 0 && out[i] >= 2) {
				root = i;
				break;
			}
		}

		Set<Integer> visited = new HashSet<>();
		int bar = 0;
		int eight = 0;

		for (int next : graph.get(root)) {
			if (visited.contains(next)) continue;

			Queue<Integer> queue = new LinkedList<>();
			queue.add(next);
			visited.add(next);

			int nodeCount = 0;
			int edgeCount = 0;
			boolean hasEndNode = false;

			while (!queue.isEmpty()) {
				int cur = queue.poll();
				nodeCount++;
				edgeCount += out[cur];

				if (out[cur] == 0) hasEndNode = true;

				if (graph.containsKey(cur)) {
					for (int adj : graph.get(cur)) {
						if (!visited.contains(adj)) {
							visited.add(adj);
							queue.add(adj);
						}
					}
				}
			}

			if (edgeCount > nodeCount) {
				eight++;
			} else if (hasEndNode) {
				bar++;
			}
		}


		int donut = out[root] - bar - eight;

		return new int[]{root, donut, bar, eight};
	}
}



public class donut_bar_graphs {

	public static void main(String[] args) {
		Solution solution=new Solution();
	}
}
