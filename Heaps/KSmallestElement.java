import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * KSmallestElement
 */

public class KSmallestElement {

    public static void main(String[] args) {
        int arr[] = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int res = findKthSmallestestElement(arr, k);
        System.err.println("Kth smallest element = "+res);
    }
    public static int findKthSmallestestElement(int[] arr, int k){
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

        for (int i : arr) {
            maxHeap.add(i);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.poll();
    }
}