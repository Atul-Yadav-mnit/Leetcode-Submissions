class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        for(int l=0;l<26;l++)
        {
            char c = (char)(l+(int)'A');
            int i = 0;
            int j = 0;
            int left = k;
            while(j<s.length())
            {
                if(s.charAt(j) == c)
                {
                    j++;
                }
                else if(left>0)
                {
                    left--;
                    j++;
                }
                else
                {
                    max = Math.max(j-i,max);
                    while(i<=j)
                    {
                        if(s.charAt(i)!=c)
                        {
                            i++;
                            left++;
                            break;
                        }
                        i++;
                    }
                    if(left > 0)
                    {
                        left--;
                        j++;
                    }
                    else
                    {
                        i++;
                        j++;
                    }
                }
            }
            max = Math.max(max,j-i);
        }
        return max;
    }
}