package labs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
public class Tree<T> implements Iterable<T> {
		static class Node<T>
		{
			T data;
			LinkedList<Node<T>> children;
			public Node(T d)
			{
				data=d;
				children=new LinkedList<>();
			}

		}
		Node<T> root;

		@Override
		public Iterator<T> iterator() {
			// TODO Auto-generated method stub
			return new TreeIterator();
		}

		private class TreeIterator implements Iterator<T>
		{
			Stack<Node<T>> s;
			public TreeIterator()
			{
				s=new Stack<>();
				if (root!=null)
					s.push(root);

			}
			@Override
			public boolean hasNext() {
				return false;
				// TO DO:  Complete this method
			}

			@Override
			public T next() {
				return null;
				// TO DO: Complete this method


		}

		
}
    public static void main(String []args)
		{
			Tree<Integer> t=new Tree<>();
			t.root=new Tree.Node<Integer>(1);
			t.root.children.add(new Tree.Node<Integer>(11));
			t.root.children.add(new Tree.Node<Integer>(12));
			t.root.children.add(new Tree.Node<Integer>(13));
			t.root.children.add(new Tree.Node<Integer>(14));
			t.root.children.get(0).children.add(new Tree.Node<Integer>(21));
			t.root.children.get(0).children.add(new Tree.Node<Integer>(22));
			t.root.children.get(0).children.add(new Tree.Node<Integer>(23));
			t.root.children.get(0).children.add(new Tree.Node<Integer>(24));
			t.root.children.get(0).children.add(new Tree.Node<Integer>(25));

			for (Integer i:t)
			{
				System.out.println(i);
			}

		}
}
