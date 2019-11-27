import java.util.Stack;
/*
*
*  Idea here is to maintain two stacks:
* i)  primaryStacks holds the actual elements
* ii) Top of secondaryStack holds the minimum element
*
*  specialPush( int data)
*  primaryStack : data is directly pushed
*  secondaryStack : if data <= top; then push
*
*  specialPop()
*  primaryStack : directly pop the element
*  secondaryStack : if top of primaryStack = top of secondaryStack, then only pop froms secondaryStack
*
* */
class SpecialStack
{
    public static void main(String args[])
    {
        Stack<Integer> primaryStack = new Stack<Integer>();
        Stack<Integer> secondaryStack= new Stack<Integer>();

        specialPush(primaryStack, secondaryStack, 10);
        specialPush(primaryStack, secondaryStack, 20);
        specialPush(primaryStack, secondaryStack, 100);
        specialPush(primaryStack, secondaryStack, 5);
        specialPush(primaryStack, secondaryStack, 50);
        System.out.println("Minimum element: "+getMin(primaryStack,secondaryStack));
        specialPop(primaryStack, secondaryStack);
        specialPop(primaryStack, secondaryStack);
        System.out.println("Minimum element: "+getMin(primaryStack,secondaryStack));

    }
    static void specialPush(Stack primaryStack, Stack secondaryStack, int data)
    {
        if(primaryStack.empty())
        {
            primaryStack.push(data);
            secondaryStack.push(data);
        }

        primaryStack.push(data);
        int currentMin = (int)secondaryStack.peek();

        if(currentMin >= data)
           secondaryStack.push(data);

    }
    static int specialPop(Stack primaryStack, Stack secondaryStack)
    {
        if(primaryStack.empty())
            return -1;

        int primaryTop = (int)primaryStack.pop();
        int secondaryTop = (int)secondaryStack.pop();

        if(primaryTop != secondaryTop)
            secondaryStack.push(secondaryTop);
        return primaryTop;
    }
    // Get the top of secondary stack
    static int getMin(Stack primaryStack, Stack secondaryStack)
    {
        if(primaryStack.empty())
            return -1;
        return (int)secondaryStack.peek();
    }
}
