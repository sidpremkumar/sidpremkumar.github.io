package labs;

import java.util.Iterator;
import java.util.Stack;

public class BinaryTree<T> implements Iterable<T> {

	private static class Node<T>
	{
		private T data;
		private Node<T> left;
		private Node<T> right;

		public Node(T d)
		{
			data=d;
		}
	}
	private Node<T> root;



	@Override
	public Iterator<T> iterator() {
		// Auto-generated method stub
		return new BinaryTreeIterator();
	}

	private class BinaryTreeIterator implements Iterator<T>
	{

		private Stack<Node<T>> s;
		public BinaryTreeIterator()
		{
			s=new Stack<>();
			if (root!=null)
				s.push(root);
		}
		@Override
		public boolean hasNext() {
			return false;
			// TO DO: Complete this method
		}

		@Override
		public T next() {
			return null;
			// TO DO:  Complete this method


	}

	/********************/
	public BinaryTree<Integer> buildTreeOfInts()
	{
		BinaryTree<Integer> tree1=new BinaryTree<>();
		tree1.root=new BinaryTree.Node<>(100);
		tree1.root.left=new BinaryTree.Node<>(-2000);
		tree1.root.right=new BinaryTree.Node<>(3);
		return tree1;
	}

	/*
	 * 14th November
	 */
	public BinaryTree<Integer> buildBSTOfInts()
	{
		BinaryTree<Integer> tree1=new BinaryTree<>();
		tree1.root=new BinaryTree.Node<>(100);
		tree1.root.left=new BinaryTree.Node<>(50);
		tree1.root.right=new BinaryTree.Node<>(3000);
		tree1.root.right.left=new BinaryTree.Node<>(1500);
		tree1.root.right.right=new BinaryTree.Node<>(4000);
		return tree1;
	}

	public BinaryTree<Integer> buildUnbalancedBSTOfInts()
	{
		BinaryTree<Integer> tree1=new BinaryTree<>();
		tree1.root=new BinaryTree.Node<>(100);
		tree1.root.right=new BinaryTree.Node<>(200);
		tree1.root.right.right=new BinaryTree.Node<>(300);
		tree1.root.right.right.right=new BinaryTree.Node<>(400);
		tree1.root.right.right.right.right=new BinaryTree.Node<>(500);
		tree1.root.right.right.right.right.right=new BinaryTree.Node<>(600);
		return tree1;
	}

	public void main(String[] args)
	{

		BinaryTree<Integer> t=BinaryTree.buildBSTOfInts();
		for (Integer item:t)
		{
			System.out.println(item);
		}
	}
}

	public static BinaryTree<Integer> buildBSTOfInts() {
		// TODO Auto-generated method stub
		return null;
	}
}
