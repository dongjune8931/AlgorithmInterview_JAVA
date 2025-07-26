package com.example.chapter14;

import java.util.LinkedList;
import java.util.Queue;

public class ch14_52 {
	public class TreeNode<T> {
		public TreeNode<T> right;
		public TreeNode<T> left;
		public T value;

		public TreeNode(Object value) {
		}

	}

	public String serialize(TreeNode root){
		if (root == null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		StringBuilder sb = new StringBuilder();
		sb.append("#,"+root.value);

		while (!queue.isEmpty()) {
			TreeNode node=queue.poll();
			if (node.left != null) {
				queue.add(node.left);
				sb.append(","+node.left.value);
			} else
				sb.append(",#");

			if (node.right != null) {
				queue.add(node.right);
				sb.append(","+node.right.value);
			} else
				sb.append(",#");
		}
		return sb.toString();

	}

	public TreeNode deserialize(String data){
		if (data.equals("")) {
			return null;
		}

		String[] nodes = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(nodes[1]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int index=2;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();

			if (!nodes[index].equals("#")) {
				node.left = new TreeNode(Integer.parseInt(nodes[index]));
				queue.add(node.left);
			}

			index+=1;

			if (!nodes[index].equals("#")) {
				node.right = new TreeNode(Integer.parseInt(nodes[index]));
				queue.add(node.right);
			}
			index+=1;

		}
		return root;

	}


}
