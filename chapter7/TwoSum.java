package com.example.chapter7;

import java.util.HashMap;
import java.util.Map;

class Solution7_1{
	/**
	 * 무차별 대입 방식이 '브루스 포스'
	 * O(n^2)
	 */
	public int[] twoSum1(int[] nums,int target){
		for (int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				if(nums[i]+nums[j]==target) return new int[]{i,j};
			}
		}

		return null;
	}
}

class Solution7_2{
	/**
	 * 비교나 탐색 대신 한번에 정답을 찾을 수 있는 방법을 찾아보자
	 * 평균적으로 조회는 O(1)
	 * 최악은 O(n)
	 */
	public int[] twoSum2(int[] nums,int target){
		Map<Integer,Integer> numMap=new HashMap<>();
		for(int i=0;i<nums.length;i++){
			numMap.put(nums[i],i);
		}

		for(int j=0;j<nums.length;j++){
			if(numMap.containsKey(target-nums[j])&&j!=numMap.get(target-nums[j]))
				return new int[]{j,numMap.get(target-nums[j])};
		}
		return null;
	}
}

class Solution7_3{
	/**
	 * for 문 합치기
	 */
	public int[] twoSum3(int[] nums,int target) {
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (numMap.containsKey(target - nums[i])) {
				return new int[] {numMap.get(target - nums[i]),i};
			}
			numMap.put(nums[i], i);
		}
		return null;
	}
}

class Solution7_4{
	/**
	 * 투 포인터
	 * 하지만 문제에서 nums[] 는 정렬되어 있지 않음
	 * Arrays.sort 로 정렬을 하고 시작해도 답을 찾을 때 인덱스를 찾을 수 없기 때문에
	 * 힘든 작업이 될 듯함
	 */
	public int[] twoSum4(int[] nums, int target){
		int left=0;
		int right=nums.length-1;
		while(left!=right){
			if(nums[left]+nums[right]>target){
				right--;
			}else if(nums[left]+nums[right]<target){
				left++;
			}else return new int[]{left,right};
		}
		return null;
	}
}


public class TwoSum {
	/**
	 * 덧셈하여 타깃을 만들 수 있는 배열의 두 숫자 인덱스를 리턴하라
	 */

}
