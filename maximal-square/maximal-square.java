class Solution {
    public int maximalSquare(char[][] m) {
        // t[i][j] = Math.min(t[i-1][j-1]+1,t[i-1][j]+1,t[i][j-1]+1)
        int matrix[][] = new int[m.length][m[0].length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                matrix[i][j] = m[i][j]-'0';
            }
        }
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][j] == 1)
                {
                    matrix[i][j] = Math.min(matrix[i][j-1]+1,matrix[i-1][j]+1);
                    matrix[i][j] = Math.min(matrix[i-1][j-1]+1,matrix[i][j]); 
                }
            }
        }
        int ans = 0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                ans = Math.max(matrix[i][j],ans);
            }
        }
        return ans*ans;
    }
}