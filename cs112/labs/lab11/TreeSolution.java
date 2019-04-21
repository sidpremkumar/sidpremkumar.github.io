package own;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
public class Tree<T> implements Iterable<T> {
		private static class Node<T>
		{
			T data;
			LinkedList<Node<T>> children;
			public Node(T d)
			{
				data=d;
				children=new LinkedList<>();
			}
			
		}
		private Node<T> root;
		
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
				// TODO Auto-generated method stub
				return !s.isEmpty();
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				if (hasNext())
				{
					Node<T> item=s.pop();
					Iterator<Tree.Node<T>> ri=item.children.descendingIterator();
					/*
					 * pushing in the stack first right most child and then left most child. 
					 */
					while (ri.hasNext())
					{
						s.push(ri.next());
					}
					T ret=item.data;
					return ret;
				}
				else 
					return null;
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