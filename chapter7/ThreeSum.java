package com.example.chapter7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution9_1{
	/**
	 *  브루스 포스로 계산
	 */
	public List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> results= new LinkedList<>();
		Arrays.sort(nums);

		for(int i=0;i<nums.length-2;i++){
			if(i>0 && nums[i]==nums[i-1]){
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				if (j > 0 && nums[j] == nums[j - 1]) {
					continue;
				}
				for(int k=j+1;k<nums.length;k++){
					if(k>0&&nums[k]==nums[k-1]){
						continue;
					}
					if(nums[i]+nums[j]+nums[k]==0){
						results.add(Arrays.asList(nums[i],nums[j],nums[k]));
					}
				}
			}
		}
		return results;

	}
}
class Solution9_2{
	/**
	 * 투포인터로 계산  O(n^2)
	 */
	public List<List<Integer>> threeSum(int[] nums){
		int left,right,sum;
		List<List<Integer>> results= new LinkedList<>();
		Arrays.sort(nums);

		for(int i=0;i<nums.length-2;i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			left=i+1;
			right=nums.length-1;
			while(left<right){
				sum=nums[left]+nums[right]+nums[i];
				//합이 0보다 작다면 왼쪽 포인터 이동
				if(sum<0) left++;
				else if(sum>0) right++;
				else results.add(Arrays.asList(nums[i],nums[left],nums[right]));

				while(left<right&&nums[left]==nums[left+1]){
					left+=1;
				}
				while(left<right&&nums[right]==nums[right+1]){
					right+=1;
				}
				left+=1;
				right+=1;
			}
		}
		return results;

	}
}
public class ThreeSum {

	/**
	 * 배열을 입력받아 합으로 0을 만들수 있는 3개의 엘리먼트 출력
	 */

}
