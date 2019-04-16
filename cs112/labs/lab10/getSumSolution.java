private T _getSum(Node<T> n)
		{
			 T ret = n.data;
			 // Could use a basecase fo n.children.size()==0 and just return n.data, but not needed. 
			 for(Node<T> child : n.children) {
				 ret = ret.plus(_getSum(child));
			 }
			 return ret;
		}