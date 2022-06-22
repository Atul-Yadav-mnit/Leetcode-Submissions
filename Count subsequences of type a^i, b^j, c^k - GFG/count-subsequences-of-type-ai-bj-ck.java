// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.next());
		
		while(t>0)
		{
		    String s = sc.next();
		    
		    Solution T = new Solution();
		    System.out.println(T.fun(s));
		    
		    t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int m = 1000000007;
    int t[][];
    public int fun2(String s, int x, int y)
    {
        if(x == s.length())
        {
            if(y == 3)
            {
                return 1;
            }
            return 0;
        }
        if(y>3)
        {
            return 0;
        }
        if(t[x][y] != -1)
        {
            return t[x][y];
        }
        int z = s.charAt(x)-'a'+1;
        if(z<y)
        {
            return t[x][y] = fun2(s,x+1,y)%m;
        }
        else if(z == y)
        {
            return t[x][y] = (2*(fun2(s,x+1,y)%m))%m;
        }
        else if(z == y+1)
        {
            return t[x][y] = (fun2(s,x+1,y)%m+fun2(s,x+1,y+1)%m)%m;
        }
        else
        {
            return t[x][y] = fun2(s,x+1,y)%m;
        }
    }
    public int fun(String s)
    {
        // Write your code here
        t = new int[s.length()][4];
        for(int i=0;i<s.length();i++)
        {
            Arrays.fill(t[i],-1);
        }
        return fun2(s,0,0);
    }
}