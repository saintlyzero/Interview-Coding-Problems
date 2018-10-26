class  MaximumSumSubarray
{
	/*
	* 	Using Kadane's Algorithm
	* 	Explanation: https://www.youtube.com/watch?v=86CQq3pKSUw
	*
	*	Time  : O(n)
 	*	Space : O(1)
	*/
	
	public static void main(String args[])
	{
		int arr[] = {-2,3,2,-1};
		int maxSum = findMaxSumOfSubarray(arr);
		
		System.out.println("Max Sum: "+maxSum);
	}
	static int findMaxSumOfSubarray(int arr[])
	{
		int max = Integer.MIN_VALUE;
		int count = 0;
		
		for(int i = 0; i< arr.length; i++)
		{
			count += arr[i];
			if(count > max)
				max = count;
			
			if(count < 0)
				count = 0;
		}
		return max;
	}
}