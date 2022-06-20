// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.posIntSol(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long t[][];
    long fun(int count , int sum)
    {
        if(sum == 0)
        {
            return 0;
        }
        if(count == 1)
        {
            return 1;
        }
        long ans = 0;
        for(int i=1;i<=sum-count+1;i++)
        {
            ans = ans+fun(count-1,sum-i);
        }
        return ans;
    }
    long posIntSol(String s)
    {
        //code here.
        int count = 1;
        int num = 0;
        int i = 0;
        while(i<s.length())
        {
            char x = s.charAt(i);
            if(x == '=')
            {
                i++;
                while(i<s.length())
                {
                    char y = s.charAt(i);
                    num = num *10 + (y-'0');
                    i++;
                }
            }
            else if(x == '+')
            {
                count++;
            }
            i++;
        }
        return fun(count,num);
    }
}