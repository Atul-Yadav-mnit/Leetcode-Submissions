class Solution {
    public int[][] generateMatrix(int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int cur = 0;
        int num = 1;
        int nums[][] = new int[n][n];
        while(num<=n*n)
        {
            if(cur == 0)
            {
                if(j < n-k)
                {
                    nums[i][j++] = num++;
                }
                else
                {
                    i++;
                    j--;
                    cur = 1;
                }
            }
            else if(cur == 1)
            {
                if(i < n-k)
                {
                    nums[i++][j] = num++;
                }
                else
                {
                    cur = 2;
                    i--;
                    j--;
                }
            }
            else if(cur == 2)
            {
                if(j >= k)
                {
                    nums[i][j--] = num++;
                }
                else
                {
                    i--;
                    k++;
                    j++;
                    cur = 3;
                }
            }
            else
            {
                if(i >= k)
                {
                    nums[i--][j] = num++;
                }
                else
                {
                    j++;
                    i++;
                    cur = 0;
                }
            }
        }
        return nums;
    }
}