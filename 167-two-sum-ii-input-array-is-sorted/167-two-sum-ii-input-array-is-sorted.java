class Solution {
    public int[] twoSum(int[] num, int t) {
        int i = 0;
        int j = num.length-1;
        int ans[] = new int[2];
        while(i<j)
        {
            if(num[i]+num[j] == t)
            {
                ans[0] = i+1;
                ans[1] = j+1;
                break;
            }
            else if(num[i]+num[j] < t)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return ans;
    }
}