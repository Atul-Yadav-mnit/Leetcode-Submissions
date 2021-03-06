// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int n, int arr[]){
        // code here
        int i = 0;
        List<Integer> ans = new ArrayList<Integer>();
        for(i=arr.length-1;i>=1;i--)
        {
            if(arr[i] > arr[i-1])
            {
                int x = arr[i-1];
                for(int j=n-1;j>=i;j--)
                {
                    if(arr[j] > x)
                    {
                        arr[i-1] = arr[j];
                        arr[j] = x;
                        break;
                    }
                }
                
                for(int j=0;j<i;j++)
                {
                    
                    ans.add(arr[j]);
                }
                for(int j=n-1;j>=i;j--)
                {
                    ans.add(arr[j]);
                }
                return ans;
            }
        }
          
        
        for(int j=n-1;j>=0;j--)
        {
            ans.add(arr[j]);
        }
      
        
        return ans;
    }
}