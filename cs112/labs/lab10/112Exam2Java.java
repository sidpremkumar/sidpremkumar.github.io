// Question 1
public boolean incresingSequence() throws EmptyLinkedList{
  if head == null{
    throw new EmptyLinkedList
  }
  Node curr = head;
  int curr_val = -9999999;
  while (curr != null){
    if curr.data > curr_val{
      return false;
    }
    curr_val = curr.data;
    curr = curr.next;
  }
  return true;
}

// Question 3 - a
public int getHeight(){
  if (root.right == null && root.left == null) {
    return 1;
  }
  if (root.right != null && root.left == null) {
    return _getHeight(root.right) + 1;
  }
  if (root.right == null && root.left != null) {
    return _getHeight(root.left) + 1;
  }
  return _getHeight(root.right) + _getHeight(root.left) + 1;
}

public _getHeight(Node<T> r){
  if (r.right == null && r.left == null) {
    return 1;
  }
  if (r.right != null && r.left == null) {
    return _getHeight(root.right) + 1;
  }
  if (r.right == null && root.r != null) {
    return _getHeight(root.left) + 1;
  }
  return _getHeight(root.right) + _getHeight(root.left) + 1;
}
//alt: _getHeight()
public int _getHeight(Node<T> r){
    int height = 0;
    if(r==null){
        return height;
    }
    else{
        int leftChild = 1 + _getHeight(r.left);
        int rightChild =1 + _getHeight(r.right);
        height = Math.max(leftChild, rightChild);
        return   height;
    }
}
// Question 3 - b
public BinaryTree<T> clone (){
    BinaryTree<T> ret=new BinaryTree<>();
    ret.root = _clone(this.root);
    return ret;

}
private Node<T> _clone(Node<T> r){
    if (r==null)
        return null;
    Node ret = new Node(r.data);
    ret.right = _clone(r.right);
    ret.left = _clone(r.left);
    return ret;

}
// Question 3 - c
BinaryTree<Integer> tree = new BinaryTree<Integer>();
tree.add(10);
tree.add(10);
tree.add(10);
