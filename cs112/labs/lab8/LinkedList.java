package labs;

/*
 *Author: Starter code prepared by Abbas.
 * Purpose: To introduce students to LinkedList, review of overloaded methods and
 * write a simple method to check if the LinkedList actually contains any loops/cycles in it.
 */
public class LinkedList<E> {
	private static class Node<E>
	{
		E data;
		Node<E> next;

		public Node(E d)
		{
			data=d;
			next=null;
		}
	}
	private Node<E> head;
	private Node<E> tail;

	/*
	 * data of type E, first gets put into a Node
	 * and then the Node gets added onto the Linked List
	 * Note: This method has been overloaded.
	 */
	public void add(E data)
	{
		Node<E> temp=new Node<>(data);
		/*
		 * the linked list is empty!
		 */
		if (head==null)
		{
			head=temp;
			tail=temp;
		}
		else
		{
			tail.next=temp;
			tail=temp;
		}
	}


	/*TODO
	 * The nodeData is already of type Node<E> and hence
	 * gets put onto the LinkedList immediately.
	 * Note: This method has been overloaded.
	 */
	public void add(Node<E> nodeData)
	{

	}


	/*
	 * This method checks if there is any loops in the linked list.
	 * If there is a loop, then the method must return back the start of
	 * the loop. If there is no loop, then the method must return back null.
	 */
	public Node<E> getStartOfLoopNode()
	{
		Node<E> fast=head;
		Node<E> slow=head;
		boolean isLoopy=false;



		while (fast!=null && fast.next!=null)
		{
			/*TODO
			 * the fast pointer moves at twice the speed of slow pointer.
			 * if slow and fast meet there exists a loop
			 */


		}


				/*TODO
				 * if there is a loop return the head else return slow
				 * reset the slow pointer back to head.
				 * Now make the slow pointer and fast pointer move at the same speed.
				 * Where they meet, is the point of intersection.
				 */

		return null;

	}


	public static void main(String []args)
	{
		LinkedList<String> ll1 = createLinkedListWithNoLoops();
		LinkedList<String> ll2 = createLinkedListWithLoops();

		/*
		 * when you call ll2.getStartOfLoopNode it must return back the node with CS350
		 * when you call ll1.getStartOfLoopNode it must return back the node null
		 */
		Node<String> startOfLoop=ll2.getStartOfLoopNode();
		if (startOfLoop==null)
			System.out.println("There is no loop");
		else
			System.out.println("The loop begins from "+startOfLoop.data.toString());
	}

	private static LinkedList<String> createLinkedListWithLoops() {
		/*
		 * adding some courses at BU. This now has a loop in it!
		 */

		LinkedList<String> ll2=new LinkedList<String>(); //this is linkedList 2
		/*
		 * adding some courses at BU. Note this linked list does contain loop!
		 */
		ll2.add("CS112");
		ll2.add("CS131");
		ll2.add("CS132");
		ll2.add("CS235");
		Node<String> loop=new Node<String>("CS350");
		ll2.add(loop);
		ll2.add("CS411");
		ll2.add("CS421");
		ll2.add("CS112");
		ll2.add("CS131");
		ll2.add(loop);
		return ll2;
	}

	private static LinkedList<String> createLinkedListWithNoLoops() {
		LinkedList<String> ll1=new LinkedList<String>(); //this is linkedList 1
		/*
		 * adding some courses at BU. Note this linked list does not contain any loops!
		 */
		ll1.add("CS112");
		ll1.add("CS131");
		ll1.add("CS132");
		ll1.add("CS350");
		ll1.add("CS112");
		return ll1;
	}
}
