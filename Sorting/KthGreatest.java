import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * KthGreatest
 * 
 * Average time complexity T(n) satisfies T(n) = 0(n) + T(n/2) => T(n)
 * Worst-case time complexity is 0(n2) which occurs when the randomly selected pivot 
 * is the smallest or largest element in the current subarray.
 * The probability of the worst-case reduces exponentially with the length
 * of the input array, and the worst-case is a nonissue in practice. 
 * For this reason, the randomize selection algorithm is sometimes said to have 
 * almost certain 0(n) time complexity.
 * 
 * Space Complexity = 0(1)
 */
public class KthGreatest {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(90);
        arr.add(70);
        arr.add(30);
        arr.add(10);
        arr.add(20);
        arr.add(1);

        for (Integer el : arr) {
            System.out.print(el+" ");
        }
        System.out.println("");
        int kth = findKthLargest(arr, 2);
        System.out.println("kth Largest: "+kth);

    }

    static int findKthLargest(ArrayList arr, int k){
        int start = 0;
        int end = arr.size() - 1; 
        Random r = new Random();
        while (start <= end) {
            int pivodIdx = r.nextInt(end - start + 1) + start;
            int newPivotIndex = reorderList(arr, pivodIdx, start, end);

            if(newPivotIndex == k - 1){
                return (int)arr.get(newPivotIndex);
            }
            else if(newPivotIndex > k - 1){
                end = newPivotIndex - 1;
            }
            else{
                start = newPivotIndex + 1;
            }
        }
        return -1;
    }

    static int reorderList(ArrayList arr, int pivotIndex, int start, int end){
        
        int pivotValue = (int)arr.get(pivotIndex);
        Collections.swap(arr, pivotIndex, start);      

        int curr = start+1;
        while((curr <= end)){
            int tmp = (int)arr.get(curr);
            if( tmp < pivotValue){
                Collections.swap(arr, curr, end);
                end--;
            }
            else if(tmp >= pivotValue){
                Collections.swap(arr, start, curr);
                start++;
                curr++;
            }          
        }
        return start;
    }
}