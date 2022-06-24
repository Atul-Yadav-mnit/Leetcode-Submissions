// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int level = Integer.parseInt(a[0]);
            int pos = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            if(ob.profession(level, pos) == 'd')
                System.out.println("Doctor");
            else
                System.out.println("Engineer");
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int fun(int l, int p)
    {
        if(p == 1)
        {
            return 0;
        }
        if(p%2 == 0)
        {
        // int y = fun(l-1,p/2);
       //  System.out.println(y);
            return 1-fun(l-1,p/2);
        }
        else
        {
            return fun(l-1,(p+1)/2);
        }
    }
    static char profession(int level, int pos){
        // code here
        int x = fun(level,pos);
            //System.out.println(x);
        if(x == 0)
        {
            return 'e';
        }
        return 'd';
    }
}