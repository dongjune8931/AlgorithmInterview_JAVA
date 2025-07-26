package com.example.chapter8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//nCk 문제
public class ch12_38 {

	public void dfs(List<List<Integer>> results, LinkedList<Integer> elements,int n,int start, int k){
		if(k==0){
			results.add(elements.stream().collect(Collectors.toList()));
			return;
		}
		for(int i=start;i<=n;i++){
			elements.add(i);
			dfs(results,elements,n,i+1,k-1);
			elements.removeLast();
		}
	}


	public List<List<Integer>> combine(int n, int k){
		List<List<Integer>> results= new ArrayList<>();
		dfs(results,new LinkedList<>(),n,1,k);
		return results;
	}

}
