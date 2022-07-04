// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.minVal(a, b));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int minVal(int a, int b) {
        // code here
        int count = 0;
        while(b>0)
        {
            if(b%2==1)
            {
                count++;
            }
            b = b/2;
        }
        int arr[] = new int[32];
        int brr[] = new int[32];
        int max = 0;
        for(int i=0;i<32&&a>0;i++)
        {
            arr[i] = a%2;
            if(arr[i]==1)
            {
                max = i;
            }
            a = a/2;
        }
        while(count>0 && max>=0)
        {
            if(arr[max] == 1)
            {
                brr[max] = 1;
                count--;
            }
            max--;
        }
        int i = 0;
        while(count>0 && i<32)
        {
            if(brr[i] == 0)
            {
                brr[i] = 1;
                count--;
            }
            i++;
        }
        int ans = 0;
        for(i=0;i<32;i++)
        {
            ans = ans + (int)Math.pow(2,i)*brr[i];
        }
        return ans;
    }
}