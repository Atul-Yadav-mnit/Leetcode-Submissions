class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix[0].length;
        int l = 0;
        int h = matrix.length*matrix[0].length-1;
        while(l<=h)
        {
            int m = l+(h-l)/2;
            int rn = m/len;
            int cn = m%len;
            int x = matrix[rn][cn];
            if(x == target)
            {
                return true;
            }
            else if(x<target)
            {
                l = m+1;
            }
            else
            {
                h = m-1;
            }
        }
        return false;
    }
}