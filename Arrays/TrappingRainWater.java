/**
 * TrappingRainWater
 * 
 * Problem Link: https://leetcode.com/problems/trapping-rain-water/
 * 
 * DP Approach
 * Time Complexity: O(N) => N + N
 * Space Complexity: O(N)
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int n =  height.length;
		
		// Stores Max height uptil leftMax[i]
        int[] leftMaxs = new int[n];
		
        int waterBlocks = 0;
		
        int leftMaxHeight = Integer.MIN_VALUE;
        
		// Build up max values beginning from left 
        for(int i=0; i<n; i++){
            if( height[i] > leftMaxHeight){
                leftMaxHeight = height[i];
            }
            leftMaxs[i] = leftMaxHeight;
        }
        
		
        int rightMax = Integer.MIN_VALUE;
		// Build up max values beginning from right 
        for(int i=n-1; i>= 0; i--){
            if(height[i] > rightMax){
                rightMax = height[i];
            }
			// water trapped = Min(rightMax, leftMax) - height of the bar
            waterBlocks += Math.min(rightMax, leftMaxs[i]) - height[i];
        }
        return waterBlocks;
    }
}