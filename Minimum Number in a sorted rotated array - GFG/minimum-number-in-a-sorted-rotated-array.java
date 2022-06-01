// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Array
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(st[i]);
              
            System.out.println(new Solution().minNumber(arr,0,n-1));
        }
    }
    
}// } Driver Code Ends




class Solution
{
    //Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high)
    {
        // Your code here
        int l = 0;
        int h = arr.length-1;
        int min = arr[l];
        while(l<=h)
        {
            int m = l+(h-l)/2;
            int x = arr[m];
            if(x>=arr[0])
            {
                min = Math.min(min,arr[0]);
                l = m+1;
            }
            else
            {
                min = Math.min(min,x);
                h = m-1;
            }
        }
        return min;
    }
}