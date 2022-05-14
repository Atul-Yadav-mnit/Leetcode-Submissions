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
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] matrix = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.MaxGold(matrix);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int dp[][];
    public int fun(int m[][], int x, int y)
    {
        if(x == m.length)
        {
            return 0;
        }
        
        if(y < 0 || y == m[0].length || m[x][y] == -1)
        {
            return 0;
        }
        if(dp[x][y]!=-1)
        {
            return dp[x][y];
        }
        return dp[x][y] = m[x][y] + Math.max(fun(m,x+1,y),Math.max(fun(m,x+1,y-1),fun(m,x+1,y+1)));
    }
    public int MaxGold(int[][] m)
    {
        // Code here
        dp = new int[m.length][m[0].length];
        for(int i=0;i<m.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        int ans = 0;
        for(int i=0;i<m[0].length;i++)
        ans = Math.max(ans,fun(m,0,i));
        return ans;
    }
}