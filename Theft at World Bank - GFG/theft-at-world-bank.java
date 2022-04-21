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
            String s1 = br.readLine().trim();
            String []S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            long C = Long.parseLong(S1[1]);
            String s2 = br.readLine().trim();
            String []S2 = s2.split(" ");
            long [] w = new long[n];
            long [] p = new long[n];
            for(int i = 0; i < n; i++){
                w[i] = Long.parseLong(S2[2*i]);
                p[i] = Long.parseLong(S2[(2*i)+1]);
            }
            Solution ob = new Solution();
            double ans = ob.maximumProfit(n, C, w, p);
            String a1 = String.format("%.3f",ans);
            System.out.println(a1);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    class Pair{
        long v,w;
        Pair(long v,long w)
        {
            this.v = v;
            this.w = w;
        }
    }
    public double maximumProfit(int N, long C, long w[], long p[])
    {
        // Code here
        ArrayList<Pair> arr = new ArrayList<Pair>();
        for(int i=0;i<w.length;i++)
        {
            long x = (long)Math.sqrt(w[i]);
            if(x*x != w[i])
            {
                arr.add(new Pair(p[i],w[i]));
            }
        }
        Collections.sort(arr,(p1,p2) -> {
            double x  =  ((double)p1.v)/(p1.w);
            double y  =  ((double)p2.v)/(p2.w);
            if(x>=y)
            {
                return -1;
            }
            else
            {
                return 1;
            }
        });
        double ans = 0.0;
        int i = 0;
        while(C>0 && i<arr.size())
        {
            if(C>arr.get(i).w)
            {
                C-=arr.get(i).w;
                ans+=arr.get(i).v;
                i++;
            }
            else
            {
                double x = ((double)C/arr.get(i).w);
                ans+=(arr.get(i).v)*x;  
                break;  
            }
        }
        return ans;
    }
}