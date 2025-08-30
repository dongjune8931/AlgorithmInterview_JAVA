package com.example.chapter14;

public class ch14_57 {
	public class TreeNode<T> {
		public TreeNode<T> right;
		public TreeNode<T> left;
		public T value;

		public TreeNode(Object value) {
		}

	}

	public int rangeSumBST(TreeNode root, int low, int high){
		if(root==null)return 0;

		int result=0;
		if (low <= (Integer)root.value && (Integer)root.value <= high) {
			result=(Integer)root.value;
		}
		result += rangeSumBST(root.left, low, high);
		result += rangeSumBST(root.right, low, high);
		return result;
	}


	public int rangeSumBST2(TreeNode root, int low, int high){
		if(root==null)return 0;

		int result=0;
		if ((Integer)root.value > high) {
			return rangeSumBST2(root.left, low, high);
		}
		if ((Integer)root.value < low) {
			return rangeSumBST2(root.right, low, high);
		}

		return (Integer)root.value+rangeSumBST2(root.left,low,high)+rangeSumBST2(root.right,low,high);
	}




}
