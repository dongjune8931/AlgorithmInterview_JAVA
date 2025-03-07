package com.example.chapter7;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution8_1{
	/**
	 * 투포인터가 최대를 향해 이동하는 풀이
	 *
	 */
	public int trap(int[] height){
		int volume=0;
		int left=0;
		int right=height.length-1;
		int leftMax=height[left];
		int rightMax=height[right];

		while(left<right){
			leftMax=Math.max(height[left],leftMax);
			rightMax=Math.max(height[right],rightMax);

			if(leftMax<=rightMax){
				volume+=leftMax-height[left];
				left++;
			}else{
				volume+=rightMax-height[right];
				right--;
			}

		}return volume;
	}
}

class Solution8_2{
	/**
	 * 스택 쌓기
	 */
	public int trap(int[] height){
		Deque<Integer> stack=new ArrayDeque<>();
		int volume=0;

		for(int i=0;i<height.length;i++){
			while(!stack.isEmpty() && height[i]>height[stack.peek()]){
				Integer top= stack.pop();

				if(stack.isEmpty()){
					break;
				}

				int distance = i-stack.peek()-1;
				int waters=Math.min(height[i],height[stack.peek()]-height[top]);

				volume+=distance*waters;
			}
			stack.push(i);
		}
		return volume;
	}
}
public class TrappingRainWater {
	/**
	 * 높이를 입력받아 비 온 후 얼마나 많은 물이 쌓일 수 있는지..
	 */

}
