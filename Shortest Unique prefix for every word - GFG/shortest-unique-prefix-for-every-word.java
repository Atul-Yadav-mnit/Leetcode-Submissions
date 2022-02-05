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
            
            String arr[] = read.readLine().split(" ");

            Solution ob = new Solution();
            String[] res = ob.findPrefixes(arr,N);
            
            for(int i=0; i<res.length; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static String[] findPrefixes(String[] arr, int N) {
        // code here
        HashMap<Integer,String> h1 = new HashMap<Integer,String>();
        HashMap<String,String> h2 = new HashMap<String,String>();
        for(int i=0;i<arr.length;i++)
        {
            h1.put(i,arr[i]);
        }
        Arrays.sort(arr);
        int prev = 0;
        int next = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(i==0)
            {
                prev = 0;
            }
            else
            {
                int a = 0;
                int b = 0;
                String A = arr[i];
                String B = arr[i-1];
                while(a<A.length() && b<B.length())
                {
                    if(A.charAt(a) != B.charAt(b))
                    {
                        break;
                    }
                    a++;
                    b++;
                }
                prev = a;
            }
            if(i==arr.length-1)
            {
                next = 0;
            }
            else
            {
                int a = 0;
                int b = 0;
                String A = arr[i];
                String B = arr[i+1];
                while(a<A.length() && b<B.length())
                {
                    if(A.charAt(a) != B.charAt(b))
                    {
                        break;
                    }
                    a++;
                    b++;
                }
                next = a;
            }
            int ans = Math.max(prev,next);
            h2.put(arr[i],arr[i].substring(0,ans+1));
        }

        for(int i=0;i<arr.length;i++)
        {
            arr[i] = h2.get(h1.get(i));
        }
        return arr;
    }
};