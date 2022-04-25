// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] X = new int[N];
            int[] Y = new int[N];
            
            for(int i=0; i<N; i++)
            {
                X[i] = Integer.parseInt(S1[i]);
                Y[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.numOfPairs(X,Y,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int count = 0;
    static int numOfPairs(int[] X, int[] Y, int N) {
        // code here
        count = 0;
        HashMap<String,Integer> h = new HashMap<String,Integer>();
        HashMap<Integer,Integer> row = new HashMap<Integer,Integer>();  
        HashMap<Integer,Integer> col = new HashMap<Integer,Integer>(); 
        for(int i=0;i<X.length;i++)
        {
            if(row.containsKey(X[i]))
            {
                row.put(X[i],row.get(X[i])+1);
            }
            else
            {
                row.put(X[i],1);
            }
            
            if(col.containsKey(Y[i]))
            {
                col.put(Y[i],col.get(Y[i])+1);
            }
            else
            {
                col.put(Y[i],1);
            }
            
            String a = String.valueOf(X[i])+"_"+String.valueOf(Y[i]);
            
            if(h.containsKey(a))
            {
                h.put(a,h.get(a)+1);
            }
            else
            {
                h.put(a,1);
            }
            
        }
        
        
        row.forEach((k,v) -> {
            count += (v*(v+1))/2;
            });
            
        col.forEach((k,v) -> {
            count += (v*(v+1))/2;
            });
            
        h.forEach((k,v) -> {
            count -= (v*(v+1));
            });
            
        return count;
    }
};