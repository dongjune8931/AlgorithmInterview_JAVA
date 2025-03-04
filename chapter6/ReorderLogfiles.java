package com.example.chapter6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Solution3_1{
	public String[] recordfiles(String[] logs){

		List<String> letterList=new ArrayList<>();
		List<String> digitList=new ArrayList<>();

		for (String log : logs) {
			if(Character.isDigit(log.split(" ")[1].charAt(0))){
				digitList.add(log);
			}else{
				letterList.add(log);
			}
		}
		/**
		 * sort() 메서드가 compareTo의 반환값을 기반으로 요소들의 순서를 조정
		 */
		letterList.sort((s1,s2)->{
			//식별자와 식별자 나머지 부분으로
			String[] s1x=s1.split(" ",2);
			String[] s2x=s2.split(" ",2);

			//문자 로그 사전순 비교
			int compared= s1x[1].compareTo(s2x[1]);
			// 문자가 동일한 경우 식별자 비교
			if(compared==0){
				return s1x[0].compareTo(s2x[0]);
			}else {
				// 비교 대상의 순서가 동일한 경우 0, 순서가 앞인 경우 1, 순서가 뒤인경우 -1이 됨
				return compared;
			}
		});

		letterList.addAll(digitList);

		return letterList.toArray(new String[0]);
	}
}
public class ReorderLogfiles {

	/**
	 * 로그를 재정렬하라
	 * [기준]
	 * 1.로그의 가장 앞부분은 식별자로서, 순서에 영향을 끼치지 않음
	 * 2.문자로 구성된 로그가 숫자 로그보다 앞에 오며, 문자 로그는 사전순으로 함
	 * 3.문자가 동일한 경우에는 식별자순
	 * 4.숫자 로그는 입력순
	 */

}
