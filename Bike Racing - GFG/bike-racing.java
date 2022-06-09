// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            long M = Long.parseLong(a[1]);
            long L = Long.parseLong(a[2]);
            long H[] = new long[N];
            long A[] = new long[N];
            for(int i = 0; i < N; i++){
                String a1[] = in.readLine().trim().split("\\s+");
                H[i] = Long.parseLong(a1[0]);
                A[i] = Long.parseLong(a1[1]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.buzzTime(N, M, L, H, A));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean fun(long th,long H[], long A[], long M,long L)
    {
        long ans = 0;
        for(int i=0;i<H.length;i++)
        {
            long s = H[i] + A[i]*th;
            if(s>=L)
            {
                ans+=s;
            }
        }
       // System.out.println(ans+" "+th);
        return ans>=M;
    }
    static long buzzTime(int N, long M, long L, long H[], long A[]){
        // code here
        long min = 0;
        long max = Long.MAX_VALUE;
        for(int i=0;i<H.length;i++)
        {
            long cur = (Math.max(M,L)-H[i])/A[i];
            max = Math.min(max,cur+1);
        }
        long ans = max;
        while(min<=max)
        {
            long th = (min+max)/2;
            if(fun(th,H,A,M,L))
            {
                ans = th;
                max = th-1;
            }
            else
            {
                min = th+1;
            }
        }
        return ans;
    }
}
