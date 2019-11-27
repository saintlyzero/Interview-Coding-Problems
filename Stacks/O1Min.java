import java.util.*;
/*
 * O1Min
 * 
 * Time Complexity:  O(1)
 * Space Complexity: O(1)
 * 
 * Refer: https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 * 
 */
public class O1Min {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        
        System.out.println("Push: "+stack.push(3));
        System.out.println("Min: "+stack.getMin());
        System.out.println("Push: "+stack.push(-10));
        System.out.println("Min: "+stack.getMin());
        System.out.println("Push: "+stack.push(-50));
        System.out.println("Min: "+stack.getMin());
        System.out.println("pop: "+stack.pop());
        System.out.println("Min: "+stack.getMin());
        System.out.println("pop: "+stack.pop());
        System.out.println("Min: "+stack.getMin());
        System.out.println("pop: "+stack.pop());
        System.out.println("pop: "+stack.pop());
        System.out.println("Min: "+stack.getMin());
    }
}

class MinStack{

    Stack<Integer> minStack;
    int min;

    MinStack(){
        minStack = new Stack<Integer>();
    }

    int push(int data){
        if(minStack.isEmpty()){
            min = data;
            minStack.push(data);
        }
        else{
            if( data < min){
                /* 
                 * Modify the pushed number such that, 
                 * the previous MIN can be obtained from it 
                 * after pop()
                 *
                 * Inserted element = (2 * data) - MIN
                 * Update MIN = data
                 * 
                 * Why exactly (2 * data) - MIN ?
                 * 
                 *  value > 2:
                 *      - Works, but might result in overflow 
                 *  
                 *  value < 2:
                 *      - Does not work for all values
                 *        fails especially for negative values
                 */
                int calculatedData = ( 2*data) - min;
                minStack.push(calculatedData);
                min = data;
            }
            else{
                minStack.push(data);
            }
        }
        return data;
    }
    int pop(){
        if(minStack.isEmpty())
            return -1;
        int top = minStack.pop();
        if(top < min){
            /*
             *  Restore previous MIN
             * 
             * MIN => CURRENT_MIN
             * (2 * CURRENT_MIN) - PREVIOUS_MIN = TOP
             * (2 * CURRENT_MIN) - TOP = PREVIOUS_MIN
             * 
             * Now, the retrived element is the value of PREVIOUS_MIN
             * Return PREVIOUS_MIN
             * 
             * MIN = PREVIOUS_MIN
             * 
             */

            int previousMin;
            previousMin =  (2 *min) - top;
            top = min;
            min = previousMin;
        }
        return top;
    }
    int getMin(){
        if(minStack.isEmpty())
            return -1;
        return min;
    }
}