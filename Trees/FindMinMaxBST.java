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
class FindMinMaxBST
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
		
		System.out.println("Min: "+getMin(root));
		System.out.println("Max: "+getMax(root));
	}
	static int getMin(BSTNode root)
	{
		if(root == null)
			return -1;
		
		while(root.left!=null)
			root = root.left;
		
		return root.getData();
	}
		static int getMinUsingRecurssion(BSTNode root)
	{
		if(root == null)
			return -1;
		
		else if(root.left == null)
			return root.getData();
		
		return getMinUsingRecurssion(root.left);
		
	}
	static int getMax(BSTNode root)
	{
		if(root == null)
			return -1;
		
		while(root.right!=null)
			root = root.right;
		
		return root.getData();
	}
		static int getMaxUsingRecurssion(BSTNode root)
	{
		if(root == null)
			return -1;
		
		else if(root.right == null)
			return root.getData();
		
		return getMaxUsingRecurssion(root.right);
		
	}
}
