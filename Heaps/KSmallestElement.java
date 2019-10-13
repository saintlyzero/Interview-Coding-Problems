import java.util.PriorityQueue;

/**
 * KSmallestElement
 */

public class KSmallestElement {

    public static void main(String[] args) {
        int arr[] = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int res = findKthLargestElement(arr, k);
        System.err.println("Kth smallest element = "+res);
    }
    public static int findKthLargestElement(int[] arr, int k){
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }

        for (int i = 0; i < k-1; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}