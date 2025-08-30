package com.example.chapter17;

import java.util.Arrays;
import java.util.StringTokenizer;

public class ch17_68 {
	public String sort(String s){
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	public boolean isAnagram(String s1,String s2){
		if(s1.length()!=s2.length()){
			return false;
		}
		return sort(s1).equals(sort(s2));
	}
}
