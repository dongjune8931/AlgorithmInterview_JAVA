package com.example.chapter14;

public class ch14_56 {
	public class TreeNode<T> {
		public TreeNode<T> right;
		public TreeNode<T> left;
		public T value;

		public TreeNode(Object value) {
		}

	}
	int val=0;

	public TreeNode bstToGst(TreeNode root){
		if (root != null) {
			bstToGst(root.right);
			val+=(Integer)root.value;
			root.value=val;
			bstToGst(root.left);
		}
		return root;
	}



}
