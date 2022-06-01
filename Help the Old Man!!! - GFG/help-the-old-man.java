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
            int N = Integer.parseInt(a[0]);
            int n = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.shiftPile(N, n);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Integer> ans;
    static int n, count;
    static void fun(int x, int b1, int b2, int b3)
    {
        if(x == 0 || count > n)
        {
            return;
        }
        fun(x-1,b1,b3,b2);
        if(count == n)
        {
            ans.add(b1);
            ans.add(b3);
        }
        count++;
        fun(x-1,b2,b1,b3);
    }
    static List<Integer> shiftPile(int N, int n){
        // code here
        ans = new ArrayList<Integer>();
        count = 1;
        Solution.n = n;
        fun(N,1,2,3);
        return ans;
    }
}

