package com.example.chapter14;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class ch14_47 {
	public class TreeNode<T> {
		public TreeNode<T> right;
		public TreeNode<T> left;
		public T value;
	}

	public int maxDepth(TreeNode root){
		if(root==null){
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int depth=0;

		while (!queue.isEmpty()) {
			depth+=1;
			for(int i=0;i<queue.size();i++){
				TreeNode cur = queue.poll();
				if (cur.right != null) {
					queue.add(cur.right);
				}
				if(cur.left!=null){
					queue.add(cur.left);
				}
			}
		}
		return depth;
	}

	public int maxDepth2(TreeNode roo){
		if(roo==null){
			return 0;
		}

		int left = maxDepth2(roo.left);
		int right = maxDepth2(roo.right);
		return Math.max(left, right)+1;
	}



}
