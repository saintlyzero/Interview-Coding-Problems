class BSTNode
{
	// Data structure for Binary Tree
	int data;
	BSTNode left;
	BSTNode right;
	
	BSTNode(int d)
	{
		data = d;
		left = null;
		right = null;
	}
	int getData()
	{
		return data;
	}
}
class DeleteNodeBST
{
	public static void main(String args[])
	{
		
		
		/*
		
					
					10
 				      /	   \
			       	     5      20
			           /   \    / \
			          2     8  15  30		
		
		
		*/
		
		BSTNode root = new BSTNode(10);
		root.right = new BSTNode(20);
		root.left = new BSTNode(5);
		root.left.left = new BSTNode(2);
		root.left.right = new BSTNode(8);
		root.right.left = new BSTNode(15);
		root.right.right = new BSTNode(30);
		
		root = DeleteNode(root,2);
		
		
		
	}
	static BSTNode DeleteNode(BSTNode root, int value)
	{
		if(root == null)
			return null;
		if(root.getData() > value)
			root.left = DeleteNode(root.left, value);
		else if(root.getData() < value)
			root.right = DeleteNode(root.right, value);
		else // Found the node
		{
			// Node to be deleted has both children
			if(root.left != null && root.right!= null)
			{
				BSTNode temp = root;
				// Find minimum element from Right sub-tree
				// Or Finding maximum element from left sub-tree would also do
				BSTNode minNode = getMin(temp.right);
				root.data = minNode.getData();
				DeleteNode(root.right,minNode.getData());
			}
			// Node to be deleted has only left child
			else if(root.left != null)
			{
				root = root.left;	
			}
			// Node to be deleted has only right child
			else if(root.right != null)
			{
				root = root.right;	
			}
			// If it is a leaf node
			else
				root = null;
			
		}
		return root;
		
	}
		static BSTNode getMin(BSTNode root)
	{
		if(root == null)
			return null;
		
		while(root.left!=null)
			root = root.left;
		
		return root;
	}
	
		
}
