class SortedMatrix{

    /*
    In each iteration, we remove a row or a column, 
    which means we inspect at most m + n - 1 elements, 
    yielding an 0(m + n) time complexity.
    */
    
    public static void main(String[] args) {
        int matrix[][] = {{-1, 2, 4, 4, 6},
                          {1, 5, 5, 9, 21},
                          {3, 6, 6, 9, 22},
                          {3, 6, 8, 10,24},
                          {6, 8, 9, 12,25},
                          {8, 10,12,13,40}};
        int target = 5;

        // Display matrix
        System.out.println("Matrix:\n");
        for (int[] is : matrix) {
            for (int element : is) {
                System.out.print(element+"  ");
            }
            System.out.println("\n");
        }
        System.out.println(target+" is preset: "+isPresent(matrix,target));

    }

    public static boolean isPresent(int[][] matrix, int target) {
        
        if(matrix.length < 1){
            return false;
        }
        
        int row = 0;
        int col = matrix[0].length - 1; // Number of Columns
        
		// Start from first row last column
        while(row < matrix.length && col >= 0){
            
			// Current element
            int element = matrix[row][col];
            
			// If found :)
            if(element == target){
                return true;
            }
            
			// Since the current element is the last element of the row,
			// there cant be any number greater than it in that row because it as sorted
            if(target > element){
			    // eliminate Row
                row++;
            }
			
			// If target < current element
			// Since the current element is the first element of the column,
			// there cant be any number smaller than it in that column because it as sorted
            else{
		    	// eliminate Column
                col--;
            }
        }
		// Not Found :(
        return false;
    }
    
}