class Solution {
    public int minSwaps(String s) {
        int rem1 = 0; // rem [
        int rem2 = 0; // rem ]
        int count = 0;
        int open = 0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) =='[')
            {
                open++;  
            }
            else
            {
                if(open > 0)
                {
                    open --;
                }
                else
                {
                    count++;
                    open++;
                }
            }
        }
        return count;
    }
}