// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

 // } Driver Code Ends
//User function Template for Java

class Solution{
    static int t[][];
    static int fun(int arr[], int x, int cur)
    {
        if(x == arr.length)
        {
            if(cur == 0)
            {
                return 1;
            }
            return 0;
        }
        if(t[x][cur] != -1)
        {
            return t[x][cur];
        }
        return t[x][cur] = fun(arr,x+1,cur)+fun(arr,x+1,cur^arr[x]);
    }
    static int subsetXOR(int arr[], int N, int K) {
        // code here
        t = new int[N][100000];
        for(int i=0;i<N;i++)
        {
            Arrays.fill(t[i],-1);
        }
        return fun(arr,0,K);
    }
}

// { Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0)
        {
            int N = s.nextInt();
            int K = s.nextInt();
            int arr[] = new int[N];
            for(int i =0;i<N;i++)
            {
                arr[i] =s.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.subsetXOR(arr,N,K));
        }
    }
}  // } Driver Code Ends