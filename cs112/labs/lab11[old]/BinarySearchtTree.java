package labs;

//Java program to demonstrate insert operation in binary search tree
class BinarySearchTree {

	/* Class containing left and right child of current node and key value*/
	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	// Root of BST
	Node root;

	// Constructor
	BinarySearchTree() {
		root = null;
	}

	// This method mainly calls insertRec()
	void insert(int key) {
		root = insertRec(root, key);
	}

	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, int key) {

		/* TO DO:  If the tree is empty, return a new node */


		/* TO DO: Otherwise, recur down the tree */


		/*return the (unchanged) node pointer */
		return root;
	}


	// A utility function to search a given key in BST
	public static boolean search(Node root, int key)
	{
		// TO DO: Base Case 1: root is null


		//TO DO: Base Case 2: key is present at root


		//TO DO: Base Case 3: root has no left or right children


		// TO DO: key is greater than root - recurse here!


		// TO DO: key is less than root -recurse here!


		//Base case 4: None of the above conditions apply
		//(We are giving you this base case, think about why it is necessary.)
		return false;

	}

	// This method mainly calls InorderRec()
	void inorder()  {
		inorderRec(root);
	}

	// A utility function to do inorder traversal of BST
	void inorderRec(Node root) {
		//TO DO:  Write a method that prints out all of
		//the elements in the BST in order
	}

	// Driver Program to test above functions
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		/* Let us create following BST
           50
        /     \
       30      70
      /  \    /  \
    20   40  60   80 */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		//PLEASE FEEL FREE TO ADD MORE TEST CASES

		// print search results of BST
		System.out.println("Search Results:");
		//should print true
		System.out.println(search(tree.root, 30));
		//should print false
		System.out.println(search(tree.root, 25));

		System.out.println("");

		// print inorder traversal of the BST
		System.out.println("InOrder Traversal:");
		tree.inorder();
	}
}
