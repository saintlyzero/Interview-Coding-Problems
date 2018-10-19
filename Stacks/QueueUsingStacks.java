import java.util.Stack;
/*
    enQueue(q,  x)
    Push x to stack1
    time complexity O(1)

    deQueue(q)
    1) If both stacks are empty then error.
    2) If stack2 is empty
         While stack1 is not empty, push everything from stack1 to stack2.
    3) Pop the element from stack2 and return it.
    time complexity O(n)

*
*/
class QueueUsingStacks {

	static class Queue { 
		Stack<Integer> stack1; 
		Stack<Integer> stack2; 
	} 
	static void push(Stack<Integer> top_ref, int new_data)
	{
		top_ref.push(new_data); 
	} 

	static int pop(Stack<Integer> top_ref) 
	{
		if (top_ref.isEmpty())
	        return -1;

		return top_ref.pop(); 
	}

	static void enQueue(Queue q, int x) 
	{ 
		push(q.stack1, x); 
	} 

	static int deQueue(Queue q) 
	{ 
		int x; 

		/* If both stacks are empty then error */
		if (q.stack1.isEmpty() && q.stack2.isEmpty())
		    return -1;

		/* Move elements from stack1 to stack 2 only if 
		stack2 is empty */
		if (q.stack2.isEmpty()) { 
			while (!q.stack1.isEmpty()) { 
				x = pop(q.stack1); 
				push(q.stack2, x); 
			} 
		} 
		x = pop(q.stack2); 
		return x; 
	} 

	public static void main(String args[]) 
	{
		Queue q = new Queue(); 
		q.stack1 = new Stack<>(); 
		q.stack2 = new Stack<>(); 
		enQueue(q, 10);
		enQueue(q, 15);
		enQueue(q, 80);

		System.out.println(deQueue(q));
		System.out.println(deQueue(q));
		System.out.println(deQueue(q));
	} 
} 

