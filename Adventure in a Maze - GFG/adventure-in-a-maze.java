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
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int[] ans = obj.FindWays(matrix);
            for(int i = 0; i < ans.length; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int a = 0;
    public int mm = 1000000007;
    public int t[][],t1[][];
    public int fun1(int m[][], int x, int y, int sum)
    {
        if(x == m.length-1 && y == m[0].length-1)
        {
            a = Math.max(a,sum+m[x][y]);
            return 1;
        }
        if(x==m.length || y==m[0].length)
        {
            return 0;
        }
        if(t1[x][y] != -1)
        {
            return t1[x][y];
        }
        int z = m[x][y];
        if(z == 1)
        {
            return t1[x][y] = fun1(m,x,y+1,sum+1)%mm;
        }
        else if(z == 2)
        {
            return t1[x][y] = fun1(m,x+1,y,sum+2)%mm;
        }
        else
        {
            int c = fun1(m,x,y+1,sum+3)%mm;
            int b = fun1(m,x+1,y,sum+3)%mm;
            return t1[x][y] = (c+b)%mm;
        }
        
    }
    
    public int fun(int m[][], int x, int y)
    {
        if(x == m.length-1 && y == m[0].length-1)
        {
            return m[x][y];
        }
        if(x==m.length || y==m[0].length)
        {
            return -999999999;
        }
        if(t[x][y] != -1)
        {
            return t[x][y];
        }
        int z = m[x][y];
        if(z == 1)
        {
            return t[x][y] = fun(m,x,y+1)+1;
        }
        else if(z == 2)
        {
            return t[x][y] = fun(m,x+1,y)+2;
        }
        else
        {
            int c = fun(m,x,y+1);
            int b = fun(m,x+1,y);
            return Math.max(c,b)+3;
        }
        
    }
    
    public int[] FindWays(int[][] matrix)
    {
        // Code here
        t = new int[matrix.length][matrix[0].length];
        t1 = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
            Arrays.fill(t[i],-1);
            Arrays.fill(t1[i],-1);
        }
        int arr[] = new int[2];
        arr[0] = fun1(matrix,0,0,0);
        arr[1] = Math.max(0,fun(matrix,0,0));
        return arr;
    }
}