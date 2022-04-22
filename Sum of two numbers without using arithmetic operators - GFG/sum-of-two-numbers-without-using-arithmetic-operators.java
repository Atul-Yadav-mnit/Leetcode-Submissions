// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 
import java.math.BigInteger;

class GFG
{
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t>0)
		{
		    String S[] = br.readLine().split(" ");
            
            int a = Integer.parseInt(S[0]);
            int b = Integer.parseInt(S[1]);
			Solution obj = new Solution();
			System.out.println(obj.sum(a,b));
            t--;
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int sum(int a , int b)
    {
        //code here
        int arr[] = new int[31];
        int xx = 1;
        for(int i=0;i<31;i++)
        {
            arr[i] = xx;
            xx = xx<<1;
        }
        int carry = 0;
        int ans = 0;
        int t = 1;
        for(int i=0;i<31;i++)
        {
            int x = a&arr[i];
            int y = b&arr[i];
            if(carry == 0)
            {
                if(x == 0)
                {
                    if(y == 0)
                    {
                        carry = 0;
                    }
                    else
                    {
                        carry = 0;
                        ans = ans | t;
                    }
                }
                else
                {
                    if(y == 0)
                    {
                        carry = 0;
                        ans = ans | t;
                    }
                    else
                    {
                        carry = 1;
                    }
                }
            }
            else
            {
                if(x == 0)
                {
                    if(y == 0)
                    {
                        carry = 0;
                        ans = ans | t;
                    }
                    else
                    {
                        carry = 1;
                    }
                }
                else
                {
                    if(y == 0)
                    {
                        carry = 1;
                    }
                    else
                    {
                        carry = 1;
                        ans = ans | t;
                    }
                }
            }
            
            t = t<<1;
        }
        if(carry == 1)
        {
            ans = ans | t;
        }
        return ans;
        
    }
}