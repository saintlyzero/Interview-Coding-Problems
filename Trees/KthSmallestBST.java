import java.util.ArrayList;

/**
 * KthSmallestBST
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

public class KthSmallestBST {

    public static void main(String[] args) {
        
        BSTNode root = generateBST();
        int k = 5;
        int kSmallest = kSmallestElements(root, k);
        System.out.println(kSmallest);
    }

    static int kSmallestElements(BSTNode root, int k){

        int count = 0;
        ArrayList<Integer> kSmallest = new ArrayList<Integer>();
        kSmallest.add(0);
        kSmallestElementsUtil(root, k, count, kSmallest);
        return kSmallest.get(0);
    } 

    static int kSmallestElementsUtil(BSTNode root, int k, int cnt, ArrayList<Integer> kSmallest){
        if(root != null && cnt < k){
            cnt += kSmallestElementsUtil(root.left, k, 0, kSmallest);
            if(cnt < k){
                cnt++;
                System.out.println("adding element: "+root.data);
                kSmallest.remove(0);
                kSmallest.add(root.data);
                cnt += kSmallestElementsUtil(root.right, k, 0, kSmallest);
                System.out.println("cnt: "+cnt);
                return cnt;
            }
        }
        return 0;
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