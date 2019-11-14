import java.util.ArrayList;

/**
 * KthLargestBST
 */

class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;

    BSTNode(int d) {
        data = d;
        left = null;
        right = null;
    }
    int getData() {
        return data;
    }
}
public class KthLargestBST {

    public static void main(String[] args) {

        BSTNode root = generateBST();
        int k = 3;
        ArrayList<Integer> kLargest = kLargestElements(root, k);
        for (Integer data : kLargest) {
            System.out.print(data + " ");
        }

        /**
         * Expected Op:  40 45 29
         * 
         */
    }

    static ArrayList<Integer> kLargestElements( BSTNode root, int k){
        ArrayList<Integer> kLargestNodes = new ArrayList<Integer>();
        kLargestNodesUtil(root, k, kLargestNodes);
        return kLargestNodes;
    }

    static void kLargestNodesUtil( BSTNode root, int k, ArrayList<Integer> kLargestNodes){
        if(root != null && kLargestNodes.size() < k){
            kLargestNodesUtil( root.right, k, kLargestNodes);
            if (kLargestNodes.size() < k ) {
                kLargestNodes.add(root.data);
                kLargestNodesUtil(root.left, k, kLargestNodes);
            }
        }
    }
    static BSTNode generateBST() {
        
        /**
         *                  11
         *          2                 29
         *      1       7        15        40
         *                              35
         * 
         */
        BSTNode root = new BSTNode(11);
        root.right = new BSTNode(29);
        root.left = new BSTNode(2);
        root.left.left = new BSTNode(1);
        root.left.right = new BSTNode(7);
        root.right.left = new BSTNode(15);
        root.right.right = new BSTNode(40);
        root.right.right.left = new BSTNode(35);
        return root;
    }
}