class Inversions
{
	/*
		Time Complexity: O(nlogn)
	*/
	
	static int mergeSort(int arr[], int left, int right)
	{
		int inversions = 0;
		
		if(left < right)
		{
			int mid = (left+right)/2;
			
			inversions = mergeSort(arr,left,mid);
			inversions += mergeSort(arr,mid+1,right);
			
			inversions += mergeAndCountInversions(arr,left,mid,right);
		}
		return inversions;
	}
	static int mergeAndCountInversions(int arr[],int left, int mid, int right)
	{
		int leftArrayLength = mid-left+1;
		int rightArrayLength = right-mid;
		int inversions = 0;
		
		int[] leftArray = new int[leftArrayLength];
		int[] rightArray = new int[rightArrayLength];
		
		for(int i=0;i<leftArrayLength;i++)
			leftArray[i]=arr[left+i];
		for(int i=0;i<rightArrayLength;i++)
			rightArray[i]=arr[mid+i+1];
		
		int i=0,j=0;
		
		int k = left;
		
		while(i<leftArrayLength && j<rightArrayLength)
		{
			if(leftArray[i]<=rightArray[j])
			{
				arr[k]=leftArray[i];
				i++;
			}
			else
			{
				arr[k]=rightArray[j];
				j++;
				inversions += leftArrayLength - i;
			}
			k++;
		}
		
		while(i<leftArrayLength)
		{
			arr[k]=leftArray[i];
			i++;
			k++;
		}
		while(j<rightArrayLength)
		{
			arr[k]=rightArray[j];
			j++;
			k++;
		}

		return inversions;
	}
	
	
	
	public static void main(String args[])
	{
		int arr[] = {1,2,31,7,5};
		int inv=0;
		System.out.print("Data:");
		for(int i=0;i<arr.length;i++)
			System.out.print(" "+arr[i]);
		
		inv = mergeSort(arr,0,arr.length-1);
		
		System.out.print("\nInversions: "+inv);
		
	}
}
