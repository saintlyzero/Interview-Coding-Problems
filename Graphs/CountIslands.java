/**
 * CountIslands
 * 
 * link: https://leetcode.com/problems/number-of-islands/
 */
public class CountIslands {

    public static void main(String[] args) {
        int matrix[][] = new int[][]{{ 1, 1, 0, 0, 0 },
                                     { 0, 1, 0, 0, 1 },
                                     { 1, 0, 0, 1, 1 },
                                     { 0, 0, 0, 0, 0 },
                                     { 1, 0, 1, 0, 1 }};
                                     
        int noOfIslands = findIsland(matrix);
        System.out.println("No of Islands: "+noOfIslands); // 5
    }

    public static int findIsland(int[][] matrix){

        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] isVisited = new boolean[row][col];
        int islands = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == 1 && !isVisited[i][j]){
                    exploreIsland(matrix, i, j, isVisited);
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void exploreIsland(int[][] matrix, int row, int col, boolean[][] isVisited){
        int neighbourRow[] = { -1, -1, -1,  0, 0,  1, 1, 1};
        int neighbourCol[] = { -1,  0,  1, -1, 1, -1, 0, 1};

        isVisited[row][col] = true;

        for (int i = 0; i < neighbourRow.length; i++) {
            if(isSafe(matrix, neighbourRow[i] + row, neighbourCol[i] + col, isVisited)){
                exploreIsland(matrix, neighbourRow[i] + row, neighbourCol[i] + col, isVisited);
            }
        }
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