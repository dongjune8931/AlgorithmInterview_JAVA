package com.example.chapter6;

/**
 * '최장 공통 부분 문자열'
 *  다이나믹 프로그래밍으로 풀 수 있는 전형적인 문제이지만
 *  이 문제는 그렇게 풀면 직관적으로 이해가 어렵고 실행속도가 느림
 *  그래서 '투 포인터' 를 이용해서 풀어보자.
 *  투 포인터가 팰린드롬을 발견하면 확장하는 형태.
 *  1. 두칸(짝수), 세칸(홀수) 로 먼저 찾고
 *  2. 해당 펠린드롬에서 확장해보자.
 */

class Solution6{

	int left,maxLen;
	public void extendPalindrome(String s, int j, int k){
		// 투 포인터가 유효한 범위 내에 있고, 양쪽 끝 문자가 일치하는 팰린드롬인 경우 범위 확장
		while(k>=0 && k<s.length()&&s.charAt(j)==s.charAt(k)){
			j--;
			k++;
		}

		//기존 최대 길이보다 큰 경우 값 교체
		if(maxLen<k-j-1){
			left=k+1;
			maxLen=k-j-1;
		}
	}
	public String palindrome(String s){
		//문자 길이 저장
		int len= s.length();

		if(len<2) return s;

		for(int i=0;i<len-1;i++){
			extendPalindrome(s,i,i+1); //두칸짜리 투 포인터
			extendPalindrome(s,i,i+2); // 세칸짜리 투포인터
		}

		return s.substring(left,left+maxLen);
	}
}
public class LongestPalindromeSubstring {

	/**
	 * 가장 긴 팰린드롬 부분 문자열을 출력하라
	 */


}
