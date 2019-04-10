package labs;

import java.util.LinkedList;

public class Tree<T extends Comparable<T> & OperatorOverload<T>> {

		private static class Node<T>
		{
			T data;
			LinkedList<Node<T>> children;
			
			public Node(T d)
			{
				data=d;
				children=new LinkedList<>();
			}
			
			public void addChild(Node<T> child)
			{
				children.add(child);
			}
			
		}
		private Node<T> root;
		
		
		public String getPreOrder()
		{
			return _getPreOrder(root,0);
		}
		
		private String _getPreOrder(Node<T> n,int depth)
		{
			String ret="";
			int i=0;
			while(i<depth)
			{
				ret=ret+" ";
				i++;
			}
			ret=ret+n.data.toString()+"\n";
			for (Tree.Node<T> child:n.children)
			{
				ret=ret+_getPreOrder(child,depth+1);
			}
			return ret;
		}
		
		
		
	
		
		
		public String getSum() throws EmptyTreeException
		{
			if (root==null)
				throw new EmptyTreeException();
			return _getSum(root).toString();
			
		}
		
		/*
		 * when _getSum is called from getSum
		 * you can be sure that n is never null! 
		 */
		private T _getSum(Node<T> n)
		{
			
			//TODO you are suppose to complete this. Change return null
			return null;
		}
		
		public static void main(String []args)
		{
			Tree<CustomIntegerForLab> t=new Tree<>();
			t.root=new Tree.Node<CustomIntegerForLab>(new CustomIntegerForLab(1));
			t.root.addChild(new Tree.Node<CustomIntegerForLab>(new CustomIntegerForLab(11)));
			t.root.addChild(new Tree.Node<CustomIntegerForLab>(new CustomIntegerForLab(12)));
			t.root.addChild(new Tree.Node<CustomIntegerForLab>(new CustomIntegerForLab(13)));
			t.root.addChild(new Tree.Node<CustomIntegerForLab>(new CustomIntegerForLab(14)));
			t.root.children.get(0).addChild((new Tree.Node<CustomIntegerForLab>(new CustomIntegerForLab(100))));
			t.root.children.get(0).addChild((new Tree.Node<CustomIntegerForLab>(new CustomIntegerForLab(200))));
			t.root.children.get(0).addChild((new Tree.Node<CustomIntegerForLab>(new CustomIntegerForLab(300))));
			System.out.println(t.getPreOrder());
			try{
				System.out.println(t.getSum());
			}
			catch(EmptyTreeException e)
			{
				System.err.println(e);
			}
		}
		
}
