package com.example.chapter7;

import java.util.List;

class Solution11_1{
	public int[] productException(int[] nums){
		int[] results=new int[nums.length];
		int p=1;
		//왼쪽 곱셈
		for(int i=0;i<nums.length;i++){
			results[i]=p;
			p*=nums[i];
		}
		p=1;
		for(int i=nums.length-1;i>=0;i--){
			results[i]*=p;
			p*=nums[i];
		}
		return results;
	}
}


public class ProductOfArrayExceptSelf {
	/**
	 * 배열을 입력받아 output[i] 가 자신을 제외한 나머지 모든 엘리먼트의 곱셈 겨로가가 되도록 출력
	 * */
}
