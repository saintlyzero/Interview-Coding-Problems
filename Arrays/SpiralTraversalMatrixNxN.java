class SpiralTraversalMatrixNxN {

    public static List<Integer> spiralOrder(int[][] matrix) {
        
        int len = matrix.length;
        List<Integer> spiralOrdering = new ArrayList<>();
        
        for(int offset = 0; offset < Math.ceil(0.5 * len); offset++){
            
            //Center Element of Odd length Matrix
            if(offset == len-offset-1)
                spiralOrdering.add(matrix[offset][offset]);
            
            for(int topRow = offset; topRow < len - 1 - offset; topRow++){
                spiralOrdering.add(matrix[offset][topRow]);
            }
            
            for(int rightCol = offset; rightCol < len - 1 - offset; rightCol++){
                spiralOrdering.add(matrix[rightCol][len - offset - 1]);
            }
            
            for(int bottomRow = len - offset - 1; bottomRow >= offset + 1; bottomRow--){
                spiralOrdering.add(matrix[len - offset - 1][bottomRow]);
            }
            
            for(int leftCol = len - offset -1; leftCol >= offset + 1; leftCol--){
                spiralOrdering.add(matrix[leftCol][offset]);
            }
        }
        
        return spiralOrdering;   
    }
}
