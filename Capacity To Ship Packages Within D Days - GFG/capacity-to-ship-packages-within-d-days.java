// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static boolean poss(int arr[], int n, int m,int x)
    {
        int d=0;
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            if(sum+arr[i]>m)
            {
                sum = arr[i];
                d++;
            }
            else
            {
                sum+=arr[i];
            }
        }
        if(sum>0)
        {
            d++;
        }
        return d<=x;
    }
    static int leastWeightCapacity(int[] arr, int N, int x) {
        // code here
        int l = 0;
        int h = 0;
        for(int i=0;i<N;i++)
        {
            l = Math.max(l,arr[i]);
            h+=arr[i];
        }
        int ans = h;
        while(l<=h)
        {
            int m = l+(h-l)/2;
            if(poss(arr,N,m,x))
            {
                ans = m;
                h = m-1;
            }
            else
            {
                l = m+1;
            }
        }
        return ans;
    }
};