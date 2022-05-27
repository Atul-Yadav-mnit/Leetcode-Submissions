class Solution {
    public int numberOfSteps(int num) {
        int ans = 0;
        while(num>0)
        {
            if(num%2 == 0)
            {
                ans++;
            }
            else
            {
                ans+=2;
            }
            num = num/2;
        }
        if(ans==0)
        {
            return 0;
        }
        return ans-1;
    }
}