package com.example.chapter14;

public class ch14_51 {
	public class TreeNode<T> {
		public TreeNode<T> right;
		public TreeNode<T> left;
		public T value;

		public TreeNode(Object value) {
		}

	}

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null) {
			return root2;
		}
		if (root2 == null) {
			return root1;
		}
		TreeNode node = new TreeNode(root1.value.toString()+root2.value.toString());


		node.left = mergeTrees(root1.left, root2.left);
		node.right = mergeTrees(root1.right, root2.right);
		return node;
	}
}
