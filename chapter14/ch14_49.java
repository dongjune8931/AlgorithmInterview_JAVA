package com.example.chapter14;

import java.util.LinkedList;
import java.util.Queue;

public class ch14_49 {
	public class TreeNode<T> {
		public TreeNode<T> right;
		public TreeNode<T> left;
		public T value;
	}

	int longest=0;

	public int dfs(TreeNode node){
		if(node==null){
			return 0;
		}

		int left = dfs(node.left);
		int right = dfs(node.right);

		if (node.left != null && node.left.value == node.left) {
			left++;
		}else left=0;

		if (node.right != null && node.right.value == node.right) {
			right++;
		}else right=0;

		return this.longest=Math.max(left,right);

	}
	public int longestUnitValuePath(TreeNode root){
		dfs(root);
		return this.longest;
	}



}
