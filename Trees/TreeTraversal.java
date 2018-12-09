import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

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
class TreeTraversal
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
		
		System.out.println("BFS :");
		BFS(root);

		System.out.println("DFS :");
		DFS(root);
	}
	static void BFS(BSTNode root)
	{
		if(root==null)
			return;
		
		Queue<BSTNode> queue = new LinkedList<BSTNode>();
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			BSTNode temp = queue.poll();
			System.out.print(temp.getData()+" ");
			
			if(temp.left!=null)
				queue.add(temp.left);
			
			if(temp.right!=null)
				queue.add(temp.right);
			
		}
	}
	
	static void DFS(BSTNode root)
	{
		Stack<BSTNode> stack = new Stack<BSTNode>();
		
		stack.add(root);
		
		while(!stack.empty())
		{
			BSTNode temp = stack.pop();
			
			System.out.print(temp.getData()+" ");
			
			if(temp.right!=null)
				stack.push(temp.right);
			
			if(temp.left!=null)
				stack.push(temp.left);
		}
	}
	
}