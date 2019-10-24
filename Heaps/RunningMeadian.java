import java.util.*;
class MedianFinder {

    /*
    
    Problem link : https://leetcode.com/problems/find-median-from-data-stream

    */
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        
        if(minHeap.isEmpty()){
            minHeap.add(num);
        }
        else{
            if(num >= minHeap.peek()){
                minHeap.add(num);
            }
            else{
                maxHeap.add(num);
            }           
        }
        
        if(minHeap.size() > maxHeap.size() + 1){
            maxHeap.add(minHeap.remove());
        }
        else if(maxHeap.size() > minHeap.size()){
            minHeap.add(maxHeap.remove());
        }
    }
    
    public double findMedian() {
        return minHeap.size() == maxHeap.size() ? 
            0.5 * (minHeap.peek() + maxHeap.peek())
            : minHeap.peek();
    }
}


 /**
  * RunningMeadian
  */
 public class RunningMeadian {
 
     public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        obj.addNum(3);
        double median = obj.findMedian();
        System.out.println("Median : "+median);
     }
 }