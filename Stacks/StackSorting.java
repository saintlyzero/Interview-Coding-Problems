/*
*
*  for Explanation refer: https://www.youtube.com/watch?v=nll-b4GeiX4
*
*
*
*/


import java.util.Stack;
class StackSorting
{
	public static void main(String args[])
	{
		Stack<Integer> result;
		Stack<Integer> myStack = new Stack<Integer>();
		myStack.push(14);
		myStack.push(21);
		myStack.push(3);
		
		result = sort(myStack);
		
		System.out.println("Sorted stack:");
		while(!result.isEmpty())
			System.out.println(result.pop());
	}
	static Stack<Integer> sort(Stack<Integer> stack)
	{
		if(stack == null || stack.isEmpty())
			return stack;
		
		Stack<Integer> newStack = new Stack<Integer>();
		newStack.push(stack.pop());
		
		while(!stack.isEmpty())
		{
			int temp = (int)stack.pop();
			while(!newStack.isEmpty() && temp > newStack.peek())
				stack.push(newStack.pop());
			
			newStack.push(temp);
		}
		return newStack;	
	}
}