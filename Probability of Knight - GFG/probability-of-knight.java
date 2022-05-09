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
            String s = br.readLine().trim();
            String []S = s.split(" ");
            int N = Integer.parseInt(S[0]);
            int start_x = Integer.parseInt(S[1]);
            int start_y = Integer.parseInt(S[2]);
            int step = Integer.parseInt(S[3]);
            Solution ob = new Solution();
            double ans = ob.findProb(N, start_x, start_y, step);
            System.out.println(String.format("%.6f", ans));           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int N,sx,sy;
    public double t[][][];
    public double fun(int x, int y, int k)
    {
       // System.out.println(x+" "+y);
        if(x < 0 || x>=N || y<0 || y>=N)
        {
            return 0.0;
        }
        if(k == 0)
        {
            return 1.0;
        }
        if(t[x][y][k]!=-1.0)
        {
            return t[x][y][k];
        }
        double ans = 0.0;
        ans += fun(x+2,y+1,k-1);
        ans += fun(x+2,y-1,k-1);
        ans += fun(x-2,y+1,k-1);
        ans += fun(x-2,y-1,k-1);
        ans += fun(x+1,y+2,k-1);
        ans += fun(x+1,y-2,k-1);
        ans += fun(x-1,y+2,k-1);
        ans += fun(x-1,y-2,k-1);
        return t[x][y][k] = ans/8.0;
    }
    public double findProb(int N, int start_x, int start_y, int step)
    {
        // Code here
        t = new double[N][N][step+1];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                Arrays.fill(t[i][j],-1.0);
            }
        }
        this.N = N;
        sx = start_x;
        sy = start_y;
        return fun(sx,sy,step);
    }
}