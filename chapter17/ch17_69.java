package com.example.chapter17;

public class ch17_69 {
	public void sortColor(int[] nums){
		int red=0;
		int white=0;
		int blue=nums.length;

		while(white<blue){
			if(nums[white]<1){
				int temp=nums[red];
				nums[red]=nums[white];
				nums[white]=temp;

				red++;
				white++;
			}else if(nums[white]>1){
				blue--;
				int temp=nums[white];
				nums[white]=nums[blue];
				nums[blue]=temp;
			}else white++;

		}
	}
}
