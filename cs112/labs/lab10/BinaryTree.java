package deleteMe;

public class BinaryTree<T> {
	private static class Node<T> {
		T value;
		Node<T> left;
		Node<T> right;
		
		public Node (T value) {
			this.value = value;
		}
	}
	
	Node root = null;
	
	public int countFullNodes()
	{
		return _countFullNodes(root);
	}
	
	private int _countFullNodes(Node<T> n)
	{
		if (n==null)
			return 0;
		if (n.left!=null && n.right!=null)
			return 1+_countFullNodes(n.left)+_countFullNodes(n.right);
		else if (n.left!=null)
			return _countFullNodes(n.left);
		else if (n.right!=null)
			return _countFullNodes(n.right);
		else
			return 0;
	}
	
public static void main(String[] args)
{
	BinaryTree<Integer> t=new BinaryTree<>();
	t.root=new BinaryTree.Node<>(1);
	t.root.left=new BinaryTree.Node<>(2);
	t.root.right=new BinaryTree.Node<>(3);
	
	t.root.left.left=new BinaryTree.Node<>(4);
	t.root.left.left.left=new BinaryTree.Node<>(3);
	t.root.left.left.right=new BinaryTree.Node<>(6);
	
	System.out.println(t.countFullNodes()); //must print back 2
	
}
}