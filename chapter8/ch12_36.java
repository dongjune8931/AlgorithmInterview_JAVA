package com.example.chapter8;
//2에서 9까지 숫자가 주어졌을 때 전화번호로 조합가능한 모든 문자 출력

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [StringBuilder]
 * 문자열을 효율적으로 수정할 수 있도록 제공하는 클래스
 * String은 불변이지만 StringBuilder는 가변이므로 반복적으로 문자열 덧붙일 때 좋음
 * appned(String) ,insert(int,string),delete(int start,int end) ,reverse() , toString()
 */

public class ch12_36 {

	public void dfs(List<String> result,Map<Character,List<Character>> dic,String digits,int index,StringBuilder path){
		if(path.length()==digits.length()){
			result.add(String.valueOf(path));
			return;
		}

		for(Character c:dic.get(digits.charAt(index))){
			dfs(result, dic, digits, index + 1, new StringBuilder(path).append(c));
			// DFS 경로가 공유되지 않게 하기 위해 새로운 인스턴스로 기입
		}
	}
	public List<String> letterCombination(String digits){
		List<String> result= new ArrayList<>();
		if(digits.isEmpty()){
			return result;
		}
		Map<Character, List<Character>> dic = new HashMap<>();
		dic.put('0', List.of());
		dic.put('1', List.of());
		dic.put('2', List.of('a','b','c'));
		dic.put('3', List.of('d','e','f'));
		dic.put('4', List.of('g','h','i'));
		dic.put('5', List.of('j','k','l'));
		dic.put('6', List.of('m','n','o'));
		dic.put('7', List.of('p','q','r','s'));
		dic.put('8', List.of('t','u','v'));
		dic.put('9', List.of('w','x','y','z'));

		dfs(result,dic,digits,0,new StringBuilder());
		return result;

	}

	public static void main(String[] args) {
		ch12_36 sol=new ch12_36();
		List<String> dap=sol.letterCombination("24");
		for (String s : dap) {
			System.out.println(s);
		}
	}
}
