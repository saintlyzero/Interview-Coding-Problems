
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
class HeightOfBinaryTree
{
	public static void main(String args[])
	{	
		/*
				
				      10
 				    /	 \
			       	   5       20
		 	         /  \ 	  /   \
				2     8  15   30	
				
		*/
		
		BSTNode root = new BSTNode(10);
		root.right = new BSTNode(20);
		root.left = new BSTNode(5);
		root.left.left = new BSTNode(2);
		root.left.right = new BSTNode(8);
		root.right.left = new BSTNode(15);
		root.right.right = new BSTNode(30);
		
		System.out.println("Height: "+getHeight(root));
		
		
	}
	static int getHeight(BSTNode root)
	{
		if(root == null)
			return -1;
		
		return Math.max(getHeight(root.left),getHeight(root.right))+1;
	}
		
}
