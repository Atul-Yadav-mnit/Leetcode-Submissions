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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            int[][] blocked_cells = new int[k][2];
            for(int i = 0; i < k; i++){
                String[] s1 = br.readLine().trim().split(" ");
                for(int j = 0; j < 2; j++){
                    blocked_cells[i][j] = Integer.parseInt(s1[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.FindWays(n, m, blocked_cells);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int t[][];
    public int mm = 1000000007;
    public int fun(int m[][], int x, int y)
    {
        int r = m.length;
        int c = m[0].length;
        if(x == r-1 && y == c-1)
        {
            return 1;
        }
        if(x == r || y == c)
        {
            return 0;
        }
        if(m[x][y] == 1)
        {
            return 0;
        }
        if(t[x][y] != -1)
        {
            return t[x][y];
        }
        return t[x][y] = ( (fun(m,x+1,y)%mm) + (fun(m,x,y+1)%mm) )%mm;
    }
    
    public int FindWays(int x, int y, int[][] b)
    {
        // Code here
        t = new int[x][y];
        for(int i=0;i<x;i++)
        {
            Arrays.fill(t[i],-1);
        }
        int m[][] = new int[x][y];
        for(int i=0;i<b.length;i++)
        {
            m[b[i][0]-1][b[i][1]-1] = 1;
        }
        if(m[0][0] == 1 || m[x-1][y-1] == 1 )
        {
            return 0;
        }
        return fun(m,0,0);
    }
}