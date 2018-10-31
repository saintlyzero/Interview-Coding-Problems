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
class MinimalTree
{
	public static void main(String args[])
	{		
		
		/*

				      4

 				    /	 \

			       	   2       6

		 	         /  \ 	  /   \

				1     3  5     7
		
		*/
		
		BSTNode root;
		int sortedArray[] = {1,2,3,4,5,6,7};
		root = createMinimalBST(sortedArray);
		System.out.println("Root: "+root.getData()); // Expected op: 4
			
	}
	static BSTNode createMinimalBST(int[] arr)
	{
		return createMinimalBST(arr, 0, arr.length-1);
	}
	static BSTNode createMinimalBST(int[] arr, int start, int end)
	{
		if(start > end)
			return null;
		int mid = (start + end)/2;
		
		BSTNode node = new BSTNode(arr[mid]);
		node.left = createMinimalBST(arr,start,mid-1);
		node.right = createMinimalBST(arr,mid+1,end);
		return node;
	}		
}
