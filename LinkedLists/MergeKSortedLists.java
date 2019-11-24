import java.util.PriorityQueue;

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { 
        val = x; 
        next = null;
    }
}
 
/**
 * MergeKSortedLists
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode[] kLists = generateLists();
        // printKLists(kLists);
        mergeKLists(kLists);
    }
    public static void mergeKLists(ListNode[] kLists) {
        int n = kLists.length;
        int[] kPointers = new int[n];
        ListNode sortedKList; 
        boolean flag = true;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        while (flag) {
            for(int i = 0; i < n; i++){
                ListNode curr = kLists[i]; 
                if(curr != null){
                    minHeap.add(curr.val);
                }
            }
            
        }
        
    }
    public static ListNode[] generateLists(){
        
        ListNode list1 = new ListNode(10);
        list1.next = new ListNode(20);
        list1.next.next = new ListNode(30);

        ListNode list2 = new ListNode(11);
        list2.next = new ListNode(21);
        list2.next.next =new ListNode(31);

        ListNode list3 = new ListNode(12);
        list3.next = new ListNode(22);
        list3.next.next =new ListNode(32);

        ListNode[] kLists = {list1, list2, list3};
        return kLists;
    }

    public static void printKLists(ListNode[] lists){
        for (ListNode listNode : lists) {
            while (listNode != null) {
                System.out.print(listNode.val+" -> ");
                listNode = listNode.next;
            }
            System.out.println();
        }
    }
}