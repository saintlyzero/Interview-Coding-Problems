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
        int target = 7;

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
        
        int row = 0;
        int column = matrix[0].length - 1;

        while(row < matrix.length && column >= 0){

            int element = matrix[row][column];

            if (element == target) {
                return true;
            }
            else if (target > element){
                // eliminate Row
                row++;
            } 
            else if (target < element){
                // eliminate Column
                column--;
            }
        }
        return false;
    }
    
}