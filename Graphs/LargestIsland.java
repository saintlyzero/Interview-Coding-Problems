/**
 * 
 * Time Complexity : O(Row * Col)
 * link: https://www.geeksforgeeks.org/find-length-largest-region-boolean-matrix/
 * 
 */
public class LargestIsland {

    public static void main(String[] args) {
        int matrix[][] = new int[][]{{ 1, 1, 1, 0, 0 },
                                     { 0, 1, 0, 0, 1 },
                                     { 1, 0, 0, 1, 1 },
                                     { 0, 0, 0, 1, 1 },
                                     { 1, 0, 1, 0, 1 }};
                                     
        int largest = findLargestIsland(matrix);
        System.out.println("Largest Island size: "+largest); // 7
    }

    public static int findLargestIsland(int[][] matrix){

        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] isVisited = new boolean[row][col];
        int maxIslandSize = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == 1 && !isVisited[i][j]){
                    int size = exploreIsland(matrix, i, j, isVisited);
                    maxIslandSize = Math.max(maxIslandSize, size);
                }
            }
        }
        return maxIslandSize;
    }

    public static int exploreIsland(int[][] matrix, int row, int col, boolean[][] isVisited){
        // Performs DFS
        int neighbourRow[] = { -1, -1, -1,  0, 0,  1, 1, 1};
        int neighbourCol[] = { -1,  0,  1, -1, 1, -1, 0, 1};

        isVisited[row][col] = true;
        int size = 1; 

        for (int i = 0; i < neighbourRow.length; i++) {
            if(isSafe(matrix, neighbourRow[i] + row, neighbourCol[i] + col, isVisited)){
                size += exploreIsland(matrix, neighbourRow[i] + row, neighbourCol[i] + col, isVisited);
            }
        }
        return size;
    }

    public static boolean isSafe(int[][] matrix, int currRow, int currCol, boolean[][]isVisited){
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;

        return (currRow >= 0 ) && (currRow < maxRow) 
        && (currCol >= 0) && (currCol < maxCol)
        && (matrix[currRow][currCol] == 1)
        && (!isVisited[currRow][currCol]);
    }
}