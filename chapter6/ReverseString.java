package com.example.chapter6;

class Solution2_1{
	public void reverseString(char[] s){
		int start =0;
		int end=s.length-1;
		while(start<end){
			char temp= s[start];
			s[start]=s[end];
			s[end]=temp;

			start++;
			end--;
		}
	}
}

class Solution2_2{
	public void reverseString(char[] s){

	}
}
public class ReverseString {
	/**
	 * 문제 : 문자열을 뒤집는 함수를 작성하라
	 * 입력값은 문자 배열이며, 리턴 없이 입력 배열 내부를 직접 조작하라.
	 */

}
