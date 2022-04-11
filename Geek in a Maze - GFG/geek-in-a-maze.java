// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

 // } Driver Code Ends
//User function Template for Java
class Pair{
        int x,y,u,d;
        Pair(int x, int y,int u, int d)
        {
            this.x = x;
            this.y = y;
            this.u = u;
            this.d = d;
        }
    }
    
class Solution{

    
	public static int numberOfCells(int n, int m, int r, int c, int u, int d, char mat[][])
	{
		// code here
		if(mat[r][c]=='#')
		{
		    return 0;
		}
		ArrayList<Pair> arr = new ArrayList<Pair>();
		int vis[][] = new int[n][m];
		arr.add(new Pair(r,c,u,d));
		int count = 1;
		vis[r][c] = 1;
		while(arr.size()>0)
		{
		    Pair p = arr.remove(0);
		    int x = p.x;
		    int y = p.y;
		    u = p.u;
		    d = p.d;
		    // x+1 y
		  //  System.out.println(x+" "+y+" "+u+" "+d);
		  if(y-1>=0 && vis[x][y-1]==0 && mat[x][y-1] != '#')
		    {
		        count++;
		        vis[x][y-1] = 1; 
		        arr.add(new Pair(x,y-1,u,d));
		    }
		   if(y+1<mat[x].length && vis[x][y+1]==0 && mat[x][y+1] != '#' )
		    {
		        count++;
		        vis[x][y+1] = 1; 
		        arr.add(new Pair(x,y+1,u,d));
		    }
		    
		    if(x+1<mat.length && vis[x+1][y]==0 && mat[x+1][y] != '#' && d>0)
		    {
		        count++;
		        vis[x+1][y] = 1; 
		        arr.add(new Pair(x+1,y,u,d-1));
		    }
		    if(x-1>=0 && vis[x-1][y]==0 && mat[x-1][y] != '#' && u>0)
		    {
		        count++;
		        vis[x-1][y] = 1; 
		        arr.add(new Pair(x-1,y,u-1,d));
		    }
		   
		    
		}
		return count;
	}

}


// { Driver Code Starts.

public class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0)
		{
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int r = sc.nextInt();
		    int c = sc.nextInt();
		    int u = sc.nextInt();
		    int d = sc.nextInt();
		    
		    char mat[][] = new char[n][m];

            for(int i = 0; i < n; i++)
            {
                String s = sc.next();
                for(int j = 0; j < m; j++)
                {
                    mat[i][j] = s.charAt(j);
                }
            }
            
            Solution obj = new Solution();
            System.out.println(obj.numberOfCells(n, m, r, c, u, d, mat));
		    
		}
	}
}

  // } Driver Code Ends