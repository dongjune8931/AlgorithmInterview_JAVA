package com.example.chapter14;

public class ch14_48 {

	public class TreeNode<T> {
		public TreeNode right;
		public TreeNode left;
		public T value;
	}

	int longest=0;
	public int dfs(TreeNode nod){
		if(nod==null){
			return -1;
		}

		int left = dfs(nod.left);
		int right = dfs(nod.right);

		this.longest=Math.max(longest,left+right+2);
		return Math.max(left,right)+1;

	}
	public int diameterOfBinaryTree(TreeNode root){
		dfs(root);
		return this.longest;
	}
}
