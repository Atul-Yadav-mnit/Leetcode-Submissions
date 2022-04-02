class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        int choice = 0;
        int s1 =0, s2=0;
        while(i<=j)
        {
            if((s.charAt(i) != s.charAt(j)) && choice==0)
            {
                int p = i;
                int q = j;
                p++;
                while(p<=q)
                {
                    
                    if(s.charAt(p)!=s.charAt(q))
                    {
                        s1 = -1;
                    }
                    p++;
                    q--;
                } 
                j--;
                while(i<=j)
                {
                    
                    if(s.charAt(i)!=s.charAt(j))
                    {
                        s2 = -1;
                    }
                    i++;
                    j--;
                } 
                if(s1 == -1 && s2 == -1)
                {
                    return false;
                }
                else
                {
                    return true;
                }
                
            }
            i++;
            j--;
        }
        
        
        return true;
    }
}