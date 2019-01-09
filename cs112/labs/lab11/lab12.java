package labs;

public class lab12 {
	public static void main(String[] args)
	{
		System.out.println("Testing Binary Tree...");
		BinaryTree<Integer> t=BinaryTree.buildBSTOfInts();
		for (Integer item:t)
		{
			System.out.println(item);
		}

		System.out.println("Testing Tree...");
		Tree<Integer> t1=new Tree<>();
		t1.root=new Tree.Node<Integer>(1);
		t1.root.children.add(new Tree.Node<Integer>(11));
		t1.root.children.add(new Tree.Node<Integer>(12));
		t1.root.children.add(new Tree.Node<Integer>(13));
		t1.root.children.add(new Tree.Node<Integer>(14));
		t1.root.children.get(0).children.add(new Tree.Node<Integer>(21));
		t1.root.children.get(0).children.add(new Tree.Node<Integer>(22));
		t1.root.children.get(0).children.add(new Tree.Node<Integer>(23));
		t1.root.children.get(0).children.add(new Tree.Node<Integer>(24));
		t1.root.children.get(0).children.add(new Tree.Node<Integer>(25));

		for (Integer i:t1)
		{
			System.out.println(i);
		}

	}

}
