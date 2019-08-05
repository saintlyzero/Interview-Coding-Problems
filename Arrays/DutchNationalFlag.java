
class DutchnationalFlag {

	public static void main (String[] args) {
	   
	   int arr[] = {1,2,3,2,3,1,2};
	   
	   for(int z=0;z<arr.length;z++) 
	    System.out.print(arr[z]+" ");
	  
	   System.out.println("\n\nSorted");

	   int low = 0;
	   int mid = 0;
	   int high = arr.length - 1;
	   
	   while( mid<=high){
	    
	    if(arr[mid]>2){
	        int temp = arr[mid];
	        arr[mid] = arr[high];
	        arr[high] = temp;
	        high--;
	    }
	    else if(arr[mid]<2){
	        int temp = arr[mid];
	        arr[mid++] = arr[low];
	        arr[low++] = temp;
	    }
	    else{
	        mid++;
	    }
	   }
	    for(int z=0;z<arr.length;z++) 
	    System.out.print(arr[z]+" ");
	}
}
