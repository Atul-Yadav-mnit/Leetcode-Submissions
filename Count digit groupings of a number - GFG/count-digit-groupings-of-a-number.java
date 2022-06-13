// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.TotalCount(str);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int t[][];
    public int fun(String str,int prev, int x, int previ)
    {
        if(x == str.length())
        {
            return 1;
        }
        if(t[x][previ]!=-1)
        {
            return t[x][previ];
        }
        int ans = 0;
        int sum = 0;
        for(int i=x;i<str.length();i++)
        {
            sum += str.charAt(i)-'0';
            if(sum>=prev)
            {
                ans += fun(str,sum,i+1,x);
            }
        }
        return t[x][previ] = ans;
    }
    public int TotalCount(String str)
    {
        // Code here
        int n = str.length();
        t = new int[n][n];
        for(int i=0;i<n;i++)
        Arrays.fill(t[i],-1);
        int sum = 0;
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            sum += str.charAt(i)-'0';
            ans += fun(str,sum,i+1,0);
        }
        return ans;
    }
}