package com.example.chapter8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ch12_41 {

	public void dfs(List<String> results, Map<String, PriorityQueue<String>> fromToMap,String from){
		while(fromToMap.containsKey(from)&&!fromToMap.get(from).isEmpty()){
			dfs(results, fromToMap, fromToMap.get(from).poll());
		}
		results.add(0,from);

	}


	//재귀 풀이
	public List<String> findItinerary(List<List<String>> tickets){
		List<String> results= new LinkedList<>();
		Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

		for (List<String> ticket : tickets) {
			fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
			fromToMap.get(ticket.get(0)).add(ticket.get(1));
		}
		dfs(results, fromToMap, "JFK");
		return results;
	}

	//반복풀이
	public List<String> findItinerary2(List<List<String>> tickets){
		List<String> results= new LinkedList<>();
		Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

		for (List<String> ticket : tickets) {
			fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
			fromToMap.get(ticket.get(0)).add(ticket.get(1));
		}

		Deque<String> stack=new ArrayDeque<>();
		stack.push("JFK");
		while(!stack.isEmpty()){
			while(fromToMap.containsKey(stack.getFirst()) && !fromToMap.get(stack.getFirst()).isEmpty()) {
				stack.push(fromToMap.get(stack.getFirst()).poll());
			}
			results.add(0, stack.pop());
		}
		return results;
	}
}
