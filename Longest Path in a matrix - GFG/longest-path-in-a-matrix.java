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
            String[] S1 = br.readLine().trim().split(" ");
            int n  = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    matrix[i][j] = Integer.parseInt(S2[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.longestIncreasingPath(matrix);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int t[][][];
    public int fun(int m[][], int x, int y, int z)
    {
        int px = x;
        int py = y;
        
        if(z == 0)
        {
            px-=1;
        }
        else if(z==1)
        {
            px+=1;
        }
        else if(z==2)
        {
            py-=1;
        }
        else if(z==3)
        {
            py+=1;
        }
        
        
      //  System.out.println(x+" "+y+" "+px+" "+py);
        if(x<0||x>=m.length||y<0||y>=m[0].length||m[x][y]<=m[px][py])
        {
            return 0;
        }
        
        if(t[x][y][z]!=-1)
        {
            return t[x][y][z];
        }
        
        int ans = 1+fun(m,x+1,y,0);
        ans = Math.max(ans,1+fun(m,x-1,y,1));
        ans = Math.max(ans,1+fun(m,x,y+1,2));
        ans = Math.max(ans,1+fun(m,x,y-1,3));
        return t[x][y][z] = ans;
        
    }
    public int longestIncreasingPath(int[][] m)
    {
        // Code here 
        int ans = 0;
        t = new int[m.length][m[0].length][4];
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m[0].length;j++)
            {
                Arrays.fill(t[i][j],-1);
            }
        }
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m[0].length;j++)
            {
                int x = i;
                int y = j;
                ans = Math.max(ans,1+fun(m,x+1,y,0));
                ans = Math.max(ans,1+fun(m,x-1,y,1));
                ans = Math.max(ans,1+fun(m,x,y+1,2));
                ans = Math.max(ans,1+fun(m,x,y-1,3));
            }
        }
        return ans;
    }
}