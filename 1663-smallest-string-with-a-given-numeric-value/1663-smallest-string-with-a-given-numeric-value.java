class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<n;i++)
        {
            if(k == (n-i)*26)
            {
                ans.append('z');
                k = k-26;
            }
            else
            {
                int x = k/26;
                if(k%26 != 0)
                {
                    x++;
                }
                if(x == (n-i))
                {
                    int y = k-(26*(n-i-1));
                    ans.append((char)(y-1+'a'));
                    k = k-y;
                }
                else
                {
                    ans.append('a');
                    k = k-1;
                }
            }
            
        }
        return ans.toString();
    }
}