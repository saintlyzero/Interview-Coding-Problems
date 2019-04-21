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
class GreaterBST
{
	static int sum=0;
	public static void main(String args[])
	{
				
		BSTNode root = new BSTNode(11);
		root.right = new BSTNode(29);
		root.left = new BSTNode(2);
		root.left.left = new BSTNode(1);
		root.left.right = new BSTNode(7);
		root.right.left = new BSTNode(15);
		root.right.right = new BSTNode(40);
		root.right.right.left = new BSTNode(35);
		
		System.out.println("Initial\n");
		inOrderTraversal(root);
		transformTree(root);
		System.out.println("After\n");
		inOrderTraversal(root);	
	}
	static void inOrderTraversal(BSTNode root)
	{
		if(root==null)
			return;
		
		inOrderTraversal(root.left);
		System.out.println(root.data+" ");
		inOrderTraversal(root.right);
	}
	
	static void transformTree(BSTNode root)
	{
		if(root == null)
			return;
		
		transformTree(root.right);
		sum = sum+root.data;
		root.data = sum-root.data;
		transformTree(root.left);
	}
}
