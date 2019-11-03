/**
 * RepetingElement
 * 
 * Eg:
 * Input  : a[] = {1, 3, 2, 3, 4}
 * Output : 3
 * 
 * The idea is based on the fact that x ^ x = 0 
 * 
 * 1) Compute XOR of elements from 1 to n-1.
 * 2) Compute XOR of array elements.
 * 3) XOR of above two would be our result.
 * 
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * 
 */
public class RepetingElement {

    public static void main(String[] args) {
        int nums[] = {1,3,2,3,4};
        int repeatinNum = findRepeatingNumber(nums);

        for (int i : nums) {
            System.out.print(i+" ");
        }
        System.out.println("");
        System.out.println("repeating num: "+repeatinNum);
    }

    static int findRepeatingNumber(int[] nums){
        
        int xorNums = nums[0];
        int xorIdeal = 1;
        
        for (int i = 1; i < nums.length; i++) {
            xorNums = xorNums ^ nums[i];
        }

        for (int i = 2; i < nums.length; i++) {
            xorIdeal = xorIdeal ^ i;
        }
        return xorIdeal ^ xorNums;
    }
}