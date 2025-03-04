package com.example.chapter6;

class Solution1{

	public boolean isPalindrome(String s){
		int start=0;
		int end=s.length()-1;

		while(start<end){
			if(!Character.isLetterOrDigit(s.charAt(start))){
				start++;
			}else if(!Character.isLetterOrDigit(s.charAt(end))){
				end--;
			}else{
				if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end))){
					return false;
				}
			}
			start ++;
			end --;
		}

		return true;
	}
}

class Solution2{

	public boolean isPalindrom2(String s){
		String s_filtered=s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
		String s_reversed = new StringBuilder(s_filtered).reverse().toString();
		return s_filtered.equals(s_reversed);

		/**
		 * StringBuilder는 스레드 안전하지 않음
		 * 문자열 처리에서 스레드 안전이 필요한 경우는 거의 없지만 알아두긴 하자.
		 */

		/**
		 * 위 풀이와 비교했을 때 (클래스 vs 원시 자료형 char)
		 * 실행속도는 훨씬 느릴 것임.
		 */
	}
}
public class ValidPaindrome {
}
