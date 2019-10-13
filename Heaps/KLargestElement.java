import java.util.PriorityQueue;

/**
 * KLargestElement
 */

public class KLargestElement {

    public static void main(String[] args) {
        int arr[] = {2,4,5,1};
        int k = 3;
        int res = findKthLargestElement(arr, k);
        System.err.println("Kth largest element = "+res);
    }
    public static int findKthLargestElement(int[] arr, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for (int i : arr) {
            minHeap.add(i);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        return minHeap.poll();
    }
}