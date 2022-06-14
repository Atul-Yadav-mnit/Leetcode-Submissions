// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            System.out.println(new Solution().findNum(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int fun(int x)
    {
        int ans = 0;
        while(x%5 == 0)
        {
            x = x/5;
            ans++;
        }
        return ans;
    }
    int findNum(int n)
    {
        // Complete this function
        int ans = 0;
        for(int i=5;;i+=5)
        {
            if(ans >= n)
            {
                return i-5;
            }
            ans+=fun(i);
        }
    }
}