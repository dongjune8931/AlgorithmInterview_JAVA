package com.example.chapter6;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution4_1{
	/**
	 * 데이터 클렌징이라 부르는, 입력값에 대한 전처리 작업이 필요함.
	 * 좀 더 편리하게 사용하기 위해 정규식을 섞어쓰자.
	 */

	public String mostCommonWord(String p ,String[] banned){
		Set<String> ban=new HashSet<>(Arrays.asList(banned));
		Map<String,Integer> counts= new HashMap<>();

		//연속적으로 단어 문자가 아닌 값을 모두 공백으로 치환
		//replaceAll() 메소드에서 역슬래시는 앞에 한번 더 역슬래시로 처리해야 함
		// \W 는 단어 문자가 아닌 것을 의미
		// \w 는 단어문자를 의미
		String[] words= p.replaceAll("\\W+", " ").toLowerCase().split(" ");

		for (String w : words) {
			if(!ban.contains(w)){
				counts.put(w,counts.getOrDefault(w,0)+1);
			}
		}

		return Collections.max(counts.entrySet(),Map.Entry.comparingByValue()).getKey();
	}
}
public class MostCommonWord {
	/**
	 * 금지된 단어를 제외하고 가장 흔하게 등장하는 단어를 출력하라. 대소문자를 구분하지 않고 구두점(마침표,쉼표 등) 또한 무시하자.
	 */

}
