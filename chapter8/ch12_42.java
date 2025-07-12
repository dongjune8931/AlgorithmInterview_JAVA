package com.example.chapter8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ch12_42 {


	public String[] solution(String[][] tickets){
		Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();
		for (String[] ticket : tickets) {
			fromToMap.putIfAbsent(ticket[0], new PriorityQueue<>());
			fromToMap.get(ticket[0]).add(ticket[1]);
		}
		List<String> results = new LinkedList<>();
		Deque<String> stack = new ArrayDeque<>();
		stack.push("ICN");
		while (!stack.isEmpty()) {
			while (fromToMap.containsKey(stack.getFirst()) && !fromToMap.get(stack.getFirst()).isEmpty()) {
				stack.push(fromToMap.get(stack.getFirst()).poll());
			}
			results.add(0, stack.pop());
		}

		return results.toArray(new String[0]);

		/**
		 * String[]으로 변환
		 * => toArray() 사용
		 * toArray 메소드에 자료형을 파라미터로 전달하면 해당 배열로 리턴해줌
		 * 또한 크기를 0으로 지정하면 나중에 JVM이 크기에 맞춰서 실행을 최적화해줌.
		 */



	}
}
