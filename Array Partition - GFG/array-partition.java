// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int test = Integer.parseInt(br.readLine());
    	while(test-- > 0) {
    		String [] str = br.readLine().trim().split(" ");
    		int N = Integer.parseInt(str[0]);
    		int K = Integer.parseInt(str[1]);
    		int M = Integer.parseInt(str[2]);
    		int [] A = new int[N];
    		str = br.readLine().trim().split(" ");
    		for(int i = 0; i < N; i++)
    			A[i] = Integer.parseInt(str[i]);
    		Solution obj = new Solution();
    		boolean ans = obj.partitionArray(N, K, M, A);
    		if(ans){
                System.out.println("YES");
            }
            else{
            	System.out.println("NO");
            }
    	}
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    int k,m,a[];
    boolean b[],t[];
    
    boolean fun(int x)
    {
        if(x == a.length)
        {
            return true;
        }
        if(t[x])
        {
            return b[x];
        }
        boolean ans = false;
        for(int i =x+k-1;i<a.length;i++)
        {
            if(a[i]-a[x] <= m)
            {
                ans = ans || fun(i+1);
            }
            else
            {
                break;
            }
        }
        t[x] = true;
        return b[x] = ans;
    }
    
	boolean partitionArray(int N, int K, int M, int [] A){
        // code here
        b = new boolean[N];
        t = new boolean[N];
        Arrays.sort(A);
        k = K;
        m = M;
        a = A;
        return fun(0);
    }
}