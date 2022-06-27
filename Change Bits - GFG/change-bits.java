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

            Solution ob = new Solution();
            int[] ans = ob.changeBits(N);
            System.out.println(ans[0]+ " "+ ans[1]);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] changeBits(int N) {
        // code here
        int x = (int)(Math.log(N)/Math.log(2));
        int ans = (int)Math.pow(2,x+1);
        int a[] = new int[2];
        a[0] = ans-N-1;
        a[1] = ans-1;
        return a;
    }
};