import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * KLargestElement
 */

public class KLargestElement {

    public static void main(String[] args) {
        int arr[] = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int res = findKthLargestElement(arr, k);
        System.err.println("Kth largest element = "+res);
    }
    public static int findKthLargestElement(int[] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2)
                    return -1;
                else if (o1 < o2)
                    return 1;
                else
                    return 0;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
        }

        for (int i = 0; i < k-1; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}