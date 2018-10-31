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
class BalancedBST
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
		
		System.out.println("Balanced? : "+isBalanced(root)); // Expected op : true		
	}
	static int checkHeight(BSTNode root)
	{
		if(root == null)
			return -1;
		
		int leftHeight = checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1)
			return Integer.MIN_VALUE;
		else
			return Math.max(leftHeight,rightHeight)+1;
	}
	static Boolean isBalanced(BSTNode root)
	{
		return checkHeight(root) != Integer.MIN_VALUE;
	}
}