class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // query_glass--;
        double arr[][] = new double[query_row+1][];
        for(int i=0;i<=query_row;i++)
        {
            arr[i] = new double[i+1];
            Arrays.fill(arr[i],0.0);
        }
        arr[0][0] = (double)poured;
        for(int i=0;i<=query_row;i++)
        {
            if(i == query_row)
            {
                return Math.min(1.0,arr[i][query_glass]);
            }
            for(int j=0;j<i+1;j++)
            {
                double x = Math.max( 0 , (arr[i][j]-1.0)/2 );
                arr[i+1][j] += x;
                arr[i+1][j+1] += x;
            }
        }
        return -1.0;
    }
}