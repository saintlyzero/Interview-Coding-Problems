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
	
		
		System.out.println("Max Sum (i): "+findMaxSumOfSubarray1(arr));
		System.out.println("Max Sum (ii): "+findMaxSumOfSubarray2(arr));
	}
	// Method 1
	static int findMaxSumOfSubarray1(int arr[])
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
	// Method 2
	static int findMaxSumOfSubarray2(int arr[])
	{
		int max_current= arr[0]; 
		int max_global = arr[0];
		
		for(int i=1;i<arr.length;i++)
		{
			max_current = arr[i] > (max_current+arr[i]) ? arr[i]:(max_current+arr[i]);
			if(max_current > max_global)
				max_global = max_current;
		}
		return max_global;
	}
	
}
