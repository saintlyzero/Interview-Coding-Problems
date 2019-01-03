class MergeSort
{
	/*
		Time Complexity  : O(nlogn)
		Space Complexity : O(n)
		
		Fun fact: Created by John von Neumann in 1945
			  Genre: Divide & Conquer
			  
	*/
	static void mergeSort(int arr[], int left, int right)
	{
		if(left < right)
		{
			int mid = (left+right)/2;
			
			mergeSort(arr,left,mid);
			mergeSort(arr,mid+1,right);
			
			merge(arr,left,mid,right);
		}
	}
	static void merge(int arr[],int left, int mid, int right)
	{
		int leftArrayLength = mid-left+1;
		int rightArrayLength = right-mid;
		
		int[] leftArray = new int[leftArrayLength];
		int[] rightArray = new int[rightArrayLength];
		
		for(int i=0;i<leftArrayLength;i++)
			leftArray[i]=arr[left+i];
		for(int i=0;i<rightArrayLength;i++)
			rightArray[i]=arr[mid+i+1];
		
		// initial index of sub-arrays
		int i=0,j=0;
		// initial index of Merged array
		int k = left;
		
		while(i<leftArrayLength && j<rightArrayLength)
		{
			if(leftArray[i]<rightArray[j])
			{
				arr[k]=leftArray[i];
				i++;
			}
			else
			{
				arr[k]=rightArray[j];
				j++;
			}
			k++;
		}
		// Copy previous contents
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

	}
	
	
	
	public static void main(String args[])
	{
		int arr[] = {12, 11, 13, 11, 6, 7, 2};
		
		System.out.print("Data:");
		for(int i=0;i<arr.length;i++)
			System.out.print(" "+arr[i]);
		
		mergeSort(arr,0,arr.length-1);
		
		System.out.print("\nSorted Data:");
		for(int i=0;i<arr.length;i++)
			System.out.print(" "+arr[i]);
	}
}
