package com.example.chapter8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ch12_43 {



	public boolean dfs1(Map<Integer, ArrayList<Integer>> finishToTakeMap,Integer finish, List<Integer> takes){

		if (takes.contains(finish)) {
			return false;
		}
		if(finishToTakeMap.containsKey(finish)){
			takes.add(finish);
			for (Integer take : finishToTakeMap.get(finish)) {
				dfs1(finishToTakeMap,take,takes);
				return false;
			}
			takes.remove(finish);
		}
		return true;
	}


	public boolean canFinish(int numCourse, int[][] prerequisites){

		Map<Integer, ArrayList<Integer>> finishToTakeMap = new HashMap<>();
		for (int[] pre : prerequisites) {
			finishToTakeMap.putIfAbsent(pre[0], new ArrayList<>());
			finishToTakeMap.get(pre[0]).add(pre[1]);
		}

		List<Integer> takes=new ArrayList<>();
		for (Integer finish : finishToTakeMap.keySet()) {
			if (!dfs1(finishToTakeMap, finish, takes)) {
				return false;
			}
		}

		return true;

	}

	//가지치기
	public boolean dfs2(Map<Integer, List<Integer>> finishToTakeMap, Integer finish, List<Integer> takes,
		List<Integer> taken) {

		if (takes.contains(finish)) {
			return false;
		}
		if (taken.contains(finish)) {
			return true;
		}

		if(finishToTakeMap.containsKey(finish)){
			takes.add(finish);
			for (Integer take : finishToTakeMap.get(finish)) {
				if (!dfs2(finishToTakeMap, take, takes, taken)) {
					return false;
				}
			}
			takes.remove(finish);
			taken.add(finish);
		}
		return true;
	}
}
