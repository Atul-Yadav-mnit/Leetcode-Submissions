// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input_line[0]);
            int P1 = Integer.parseInt(input_line[1]);
            int P2 = Integer.parseInt(input_line[2]);
            int N = Integer.parseInt(input_line[3]);
            
            Solution ob = new Solution();
            System.out.println(ob.swapBits(X, P1, P2, N));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    int swapBits(int x, int p1, int p2, int n)
    {
        int arr[] = new int[26];
        int temp[] = new int[26];
        int i = 0;
        while(x>0)
        {
            arr[i++] = x%2;
            temp[i-1] = arr[i-1];
            x = x/2;
        }
        i = p1;
        int j = p2;
        while(i<p1+n && i<p2 && j<p2+n)
        {
            arr[i] = temp[j];
            arr[j] = temp[i];
            i++;
            j++;
        }
        int p = 1;
        int ans = 0;
        for(i=0;i<26;i++)
        {
            ans += arr[i]*p;
            p = p*2;
        }
        return ans;
    }
}