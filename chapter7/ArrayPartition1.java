package com.example.chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution10_1{
	public int arrayPairSum(int[] nums){
		int sum=0;
		Arrays.sort(nums);
		List<Integer> pair=new ArrayList<>();

		for(int n :nums){
			pair.add(n);
			if(pair.size()==2){
				sum+= Collections.min(pair);
				pair.clear();
			}
		}
		return sum;
	}
}
class Solution10_2 {
	public int arrayPairSum(int[] nums) {
		int sum=0;
		Arrays.sort(nums);

		for(int i=0;i< nums.length;i++){
			if(i%2==0){
				sum+=nums[i];
			}
		}return sum;
	}
}
public class ArrayPartition1 {

	/**
	 * n개의 페어를 이용한 min(a,b)의 합으로 만들 수 있는 가장 큰수를 출력하라.
	 */

}
