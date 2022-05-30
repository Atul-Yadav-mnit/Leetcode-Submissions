// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
        	String input_line[] = read.readLine().trim().split("\\s+");
        	int x = Integer.parseInt(input_line[0]);
        	int y = Integer.parseInt(input_line[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestPath(x,y));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution { 
    
    int ans = 0,x,y;
    
    
    
    void fun(int x, int y)
    {
        if(x == y)
        {
            ans = x;
        }
        else if(x>y)
        {
             fun(x/2,y);
        }
        else
        {
            fun(x,y/2);
        }
    }
    int fun2(int n, int req)
    {
        if(n == req)
        {
            return 0;
        }
        return 1+fun2(n/2,req);
    }
    
    
    int shortestPath( int x, int y){ 
        // code here
        this.x = x;
        this.y = y;
        fun(x,y);
        return fun2(x,ans)+fun2(y,ans);
    }
    
}