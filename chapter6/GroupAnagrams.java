package com.example.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution{
	public List<List<String>> groupAnagrams(String[] strs){
		Map<String, List<String>> results=new HashMap<>();
		for (String s : strs) {
			char[] chars=s.toCharArray();
			Arrays.sort(chars);
			String key=String.valueOf(chars);

			if(!results.containsKey(key)){
				results.put(key,new ArrayList<>());
			}
			results.get(key).add(s);
		}



		return new ArrayList<>(results.values());
	}
}
public class GroupAnagrams {
}
