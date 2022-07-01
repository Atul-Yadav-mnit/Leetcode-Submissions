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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.FindNthTerm(n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long M = 1000000007;
    public long[][] fun(long m[][], int n)
    {
        long ans[][] = new long[2][2];
        if(n == 1)
        {
            ans[0][0] = m[0][0];
            ans[0][1] = m[0][1];
            ans[1][0] = m[1][0];
            ans[1][1] = m[1][1];
        }
        else
        {
            long tans[][] = new long[2][2];
            long t[][] = fun(m,n/2);
            for(int i=0;i<2;i++)
            {
                for(int j=0;j<2;j++)
                {
                    tans[i][j] = 0;
                    for(int k=0;k<2;k++)
                    {
                        tans[i][j] = (tans[i][j]%M + (  (t[i][k]%M*t[k][j]%M) %M ) )%M;
                    }
                }
            }
            if(n%2==1)
            {
                for(int i=0;i<2;i++)
                {
                    for(int j=0;j<2;j++)
                    {
                        ans[i][j] = 0;
                        for(int k=0;k<2;k++)
                        {
                            ans[i][j] = (ans[i][j]%M + (tans[i][k]%M*m[k][j]%M)%M )%M;
                        }
                    }
                }
            }
            else
            {
                for(int i=0;i<2;i++)
                {
                    for(int j=0;j<2;j++)
                    {
                        ans[i][j] = tans[i][j];
                    }
                }
            }
        }
        return ans;
    }
    public int FindNthTerm(int n)
    {
        // code here
        if(n == 0 || n==1)
        {
            return 1;
        }
       long m[][] = {{1,1},{1,2}};
       long t[][] = fun(m,n/2);
       long ans = 0;
       if(n%2==0)
       {
           ans = t[0][0] + t[0][1];
       }
       else
       {
           ans = t[1][0] + t[1][1];
       }
       return (int)(ans%M);
    }
}