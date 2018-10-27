class BSTNode
{
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
class ValidateBST
{
	public static void main(String args[])
	{
		
		
		/*
		
					
					10
 				  /	   \
				5		20
			  /   \		/ \
			2	   8  15  30		
		
		
		*/
		
		BSTNode root = new BSTNode(10);
		root.right = new BSTNode(20);
		root.left = new BSTNode(5);
		root.left.left = new BSTNode(2);
		root.left.right = new BSTNode(8);
		root.right.left = new BSTNode(15);
		root.right.right = new BSTNode(30);
		
		System.out.println("Binary Search Tree: "+isBST(root));
		
		
	}
	static boolean isBST(BSTNode root)
	{
		
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	static boolean isBST(BSTNode root, int min, int max)
	{
		if(root == null)
			return true;
		if(root.getData() > min && root.getData() < max
			&& isBST(root.left, min, root.getData())
			&& isBST(root.right, root.getData(), max))
			return true;
		else
			return false;
	}
		
}