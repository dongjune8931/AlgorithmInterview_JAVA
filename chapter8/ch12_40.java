package com.example.chapter8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

//부분집합
public class ch12_40 {
	public void dfs(List<List<Integer>> results, int[] nums, int index, Deque<Integer> path) {

		results.add(path.stream().collect(Collectors.toList()));

		for(int i=index;i<nums.length;i++){
			path.add(nums[i]);
			dfs(results,nums,i++,path);
			path.removeLast();
		}

	}

	public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> results= new ArrayList<>();
		dfs(results, nums, 0, new ArrayDeque<>());
		return results;
	}
}
