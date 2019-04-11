import java.util.*;

public class Tree<T> {
	
	private class Node {
		T value;
		LinkedList<Node> children = new LinkedList<Node>();
		Node (T value) {
			this.value = value;
		}
		void addChild (Node child) {
			children.add(child);
		}
		
	}
	
	Node root = null;
	
	public String printWithAQueue() {
		String ret = "";
		if (root != null) {
			Queue<Node> queueOfNodes = new LinkedList<Node>();
			Queue<Integer> queueOfDepths = new LinkedList<Integer>();
			queueOfNodes.add(root);
			queueOfDepths.add(0);
			while (!queueOfNodes.isEmpty()) {
				Node n = queueOfNodes.remove();
				int depth = queueOfDepths.remove();
				for (int i = 0; i<depth; i++) {
					ret+="  ";
				}
				ret += n.value+"\n";
				for (Node child : n.children) {
					queueOfNodes.add(child);
					queueOfDepths.add(depth+1);
				}
			}
		}
		return ret;
	}
	
	
	public String printWithAStack() {
		String ret = "";
		if (root != null) {
			Stack<Node> stackOfNodes = new Stack<Node>();
			Stack<Integer> stackOfDepths = new Stack<Integer>();
			stackOfNodes.push(root);
			stackOfDepths.push(0);
			while (!stackOfNodes.isEmpty()) {
				Node n = stackOfNodes.pop();
				int depth = stackOfDepths.pop();
				for (int i = 0; i<depth; i++) {
					ret+="  ";
				}
				ret += n.value+"\n";
				for (Node child : n.children) {
					stackOfNodes.push(child);
					stackOfDepths.push(depth+1);
				}
			}
		}
		return ret;
	}
	
	public String printPreOrder () {
		return printPreOrder (root, 0);
	}
	
	private String printPreOrder(Node n, int depth) {
		String ret = "";
		for (int i = 0; i<depth; i++) {
				ret+="  ";
		}
		ret+=n.value + "\n";
		for (Node child : n.children) {
			ret += printPreOrder(child, depth+1);
		}
		return ret;
	}

	public String printPostOrder () {
		return printPostOrder (root, 0);
	}
	
	private String printPostOrder(Node n, int depth) {
		String ret = "";
		for (Node child : n.children) {
			ret += printPostOrder(child, depth+1);
		}
		for (int i = 0; i<depth; i++) {
			ret+="  ";
		}
		return ret+n.value + "\n";
	}

	
	public static void main(String[] args) {
		Tree<String> t = new Tree<String>();
		t.root = t.new Node("root");
		Tree<String>.Node c1 = t.new Node ("child1");
		t.root.addChild(c1);
		Tree<String>.Node c11 = t.new Node ("child1.1");
		c1.addChild (c11);
		Tree<String>.Node c12 = t.new Node ("child1.2");
		c1.addChild (c12);
		
		Tree<String>.Node c2 = t.new Node ("child2");
		t.root.addChild(c2);
		Tree<String>.Node c21 = t.new Node ("child2.1");
		c2.addChild (c21);
		Tree<String>.Node c22 = t.new Node ("child2.2");
		c2.addChild (c22);
		Tree<String>.Node c23 = t.new Node ("child2.3");
		c2.addChild (c23);

		Tree<String>.Node c231 = t.new Node ("child2.3.1");
		c23.addChild (c231);

		System.out.println(t.printPreOrder());
		System.out.println("------------------");
		System.out.println(t.printPostOrder());
		System.out.println("------------------");
		System.out.println(t.printWithAStack());
		System.out.println("------------------");
		System.out.println(t.printWithAQueue());
	}

}
