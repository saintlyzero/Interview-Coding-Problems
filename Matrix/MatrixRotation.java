class MatrixRotation
{
	
public static void rotate(int[][] matrix, int n) {
    for (int layer = 0; layer < n / 2; ++layer) {
        int first = layer;
        int last = n - 1 - layer;
        for(int i = first; i < last; ++i) {
            int offset = i - first;
            int top = matrix[first][i]; // save top

            // left -> top
            matrix[first][i] = matrix[last-offset][first];          

            // bottom -> left
            matrix[last-offset][first] = matrix[last][last - offset]; 

            // right -> bottom
            matrix[last][last - offset] = matrix[i][last]; 

            // top -> right
            matrix[i][last] = top; // right <- saved top
        }
		
    }
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			System.out.print(matrix[i][j]+" ");
		}
		System.out.print("\n");
	}
}

public static void main(String args[])
{
	 int mat[][] = 
        { 
            {11, 12, 13, 14}, 
            {15, 16, 17, 18}, 
            {19, 20, 21, 22}, 
            {23, 24, 25, 26} 
        }; 
	int n = 4;
	
	System.out.println("Original Matrix:\n");
	
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			System.out.print(mat[i][j]+" ");
		}
		System.out.print("\n");
	}
		
	System.out.println("Matrix after Rotation:\n");
	rotate(mat,n);
}
}