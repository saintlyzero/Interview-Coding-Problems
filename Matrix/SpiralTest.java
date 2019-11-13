
/**
 * SpiralTest
 */
public class SpiralTest {

    public static void main(String[] args) {
        
        int arr[][] = {
                        {1,2,3,4}
                        
                        
                    };
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }

        System.out.println("\nSpiral:\n");
        spiralTraverse(arr);
    }
    static void spiralTraverse(int[][] arr){
        int rows = arr.length;
        int columns = arr[0].length;

        int rowIdx = 0;
        int colIdx = 0;
        int halfRows = (int)Math.ceil(rows/2.0);
        int halfColumns = (int)Math.ceil(columns/2.0);
        
        // System.out.println("rows: "+halfRows+" cols: "+halfColumns);

        while (rowIdx < halfRows && colIdx < halfColumns) {
            // Top Row
            // System.out.println("Top Row\n");
            for (int column = colIdx; column < columns - colIdx - 1; column++) {
                System.out.print(arr[rowIdx][column]+" ");
            }

            // System.out.println("Last Column\n");
            // Last Column
            for (int row = rowIdx; row < rows - rowIdx - 1; row++) {
                System.out.print(arr[row][columns-colIdx-1]+" ");
            }

            // System.out.println("Bottom Row\n");
            // Bottom Row
            for (int column = columns - colIdx - 1; column > colIdx; column--) {
                System.out.print(arr[rows-rowIdx-1][column]+" ");
            }

            // System.out.println("First Column\n");
            // First Column
            for(int row = rows - rowIdx - 1; row > rowIdx; row--){
                System.out.print(arr[row][colIdx]+" ");
            }
            rowIdx++;
            colIdx++;
        }
    }
}