package com.example.chapter14;

public class ch14_55 {
	public class TreeNode<T> {
		public TreeNode<T> right;
		public TreeNode<T> left;
		public T value;

		public TreeNode(Object value) {
		}

	}

	public TreeNode construct(int[] nums, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid=lo+(hi-lo)/2;
		TreeNode node = new TreeNode(nums[mid]);

		node.left = new TreeNode(node.left);
		node.right = new TreeNode(node.right);
		return node;

	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length==0) return null;
		return construct(nums, 0, nums.length-1);
	}



}
