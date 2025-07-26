package com.example.chapter14;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class ch14_50 {


	public class TreeNode<T> {
		public TreeNode<T> right;
		public TreeNode<T> left;
		public T value;

		public TreeNode(Object value) {
		}
	}

	public TreeNode invertTree(TreeNode root){
		if (root == null) {
			return null;
		}
		//현재 노드 값을 복사한 신규 노드 생성
		TreeNode newNode = new TreeNode(root.value);
		newNode.left = invertTree(root.right);
		newNode.right = invertTree(root.left);
		return newNode;
	}


	public TreeNode invertTree2(TreeNode root){
		if(root!=null){

			invertTree2(root.left);
			invertTree2(root.right);

			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
	}

	public TreeNode invertTree3(TreeNode root){
		if(root!=null){

			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;

			invertTree3(root.left);
			invertTree3(root.right);

		}
		return root;
	}

	public TreeNode invertTree4(TreeNode root){
		if (root == null) {
			return null;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			TreeNode temp = node.left;
			node.left = node.right;
			node.right=temp;

			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
		}
		return root;
	}

	public TreeNode invertTree5(TreeNode root){
		if (root == null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode node= queue.poll();
			TreeNode temp = node.left;
			node.left=node.right;
			node.right=temp;

			if (node.left != null) {
				queue.offer(node.left);
			}
			if(node.right!=null){
				queue.offer(node.right);
			}

		}
		return root;


	}

}
