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
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.primeDivision(N);
            System.out.println(ans.get(0) + " " + ans.get(1));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean prime[];
    static List<Integer> primeDivision(int N){
        // code here
        prime = new boolean[N+2];
        Arrays.fill(prime,true);
        prime[0] = false;
        prime[1] = false;
        for(int i=2;i*i<=N;i++)
        {
            if(prime[i])
            {
                for(int j=i*i;j<=N;j+=i)
                {
                    prime[j] = false;
                }
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=2;i<=N/2;i++)
        {
            int a = i;
            int b = N-i;
            if(prime[a]&&prime[b])
            {
                ans.add(a);
                ans.add(b);
                return ans;
            }
        }
        return ans;
    }
}