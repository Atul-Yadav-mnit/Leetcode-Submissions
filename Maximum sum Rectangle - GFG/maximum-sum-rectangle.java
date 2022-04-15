// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumSumRectangle(N, M, a));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {
        // code here
        for(int i=0;i<R;i++)
        {
            for(int j=1;j<C;j++)
            {
                M[i][j] += M[i][j-1];
            }
        }
        
        int prev = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<C;i++)
        {
            for(int j=i;j<C;j++)
            {
                prev = -9999999;
                int tm = Integer.MIN_VALUE;
                for(int k=0;k<R;k++)
                {
                    int sum;
                    if(i == 0)
                    {
                        sum = M[k][j];
                    }
                    else
                    {
                        sum = M[k][j] - M[k][i-1];
                    }
                    sum = Math.max(sum,prev+sum);
                    prev = sum;
                    tm = Math.max(sum,tm);
                }
                max = Math.max(tm,max);
            }
        }
        return max;
    }
};