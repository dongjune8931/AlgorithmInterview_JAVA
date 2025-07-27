package com.example.chapter14;

import java.util.LinkedList;
import java.util.Queue;

public class ch14_53 {
	public class TreeNode<T> {
		public TreeNode<T> right;
		public TreeNode<T> left;
		public T value;

		public TreeNode(Object value) {
		}

	}

	public int dfs(TreeNode node){
		if (node == null) {
			return 0;
		}

		int left = dfs(node.left);
		int right = dfs(node.right);

		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left,right)+1;
	}
	public boolean isBalanced(TreeNode root){
		return dfs(root)!=-1;
	}





}
