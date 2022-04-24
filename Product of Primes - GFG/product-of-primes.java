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
            long L = Long.parseLong(a[0]);
            long R = Long.parseLong(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.primeProduct(L, R));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean isPrime(long x)
    {
        long a = (long)Math.sqrt(x);
        //boolean x[] = new boolean[a];
        for(long i = 2;i<=a;i++)
        {
            if(x%i == 0)
            {
                return false;
            }
        }
        return true;
    }
    static long primeProduct(long L, long R){
        // code here
        long p = 1;
        long m = 1000000007;
        for(long i=L;i<=R;i++)
        {
            if(isPrime(i))
            {
                p = (p%m*i%m)%m;
            }
        }
        return p;
    }
}