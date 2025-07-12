package com.example.chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. Arrays.stream(nums)
 *  int[] 를 IntStream 이라는 스트림으로 바꿈
 *  예: int[] nums={1,2,3} -> IntStream= 1 -> 2-> 3
 *
 * 2. .boxed()
 * IntStream -> Stream(Integer)
 *
 * 3. .collect(Collectors.toList())
 *  스트림을 다시 리스트로 모아줌
 */

// n! 문제

public class ch12_37 {
	public void dfs(List<List<Integer>> results, List<Integer> prevElements,List<Integer> elements){
		// 리프노드에 도달하면 결과에 추가
		if(elements.isEmpty()){
			results.add(new ArrayList<>(prevElements));
			//results.add(prevElements.stream().collect(Collectors.toList()));
		}
		for (Integer e : elements) {
			List<Integer> nextElement= new ArrayList<>(prevElements);
			nextElement.remove(e);

			prevElements.add(e);
			dfs(results,prevElements,nextElement);
			prevElements.remove(e);
		}
	}

	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> results= new ArrayList<>();
		List<Integer> lst= Arrays.stream(nums).boxed().collect(Collectors.toList());
		//for (int num : nums) {
		//     lst.add(num);
		// }
		dfs(results, new ArrayList<>(),lst);

		return results;
	}
}
