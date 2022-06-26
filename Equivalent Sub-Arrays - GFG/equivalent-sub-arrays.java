// { Driver Code Starts
//Initial Template for Java


//Initial Template for Java


import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


 
class Solution
{ 
    // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n) 
    { 
        int count[] = new int[10001];
        int c = 0;
        for(int i=0;i<arr.length;i++)
        {
            count[arr[i]] ++;
            if(count[arr[i]] == 1)
            {
                c++;
            }
        }
        for(int i=0;i<=10000;i++)
        {
            count[i] = 0;
        }
        int i = 0;
        int j = 0;
        int ans = 0;
        
        while(j<arr.length)
        {
           
            if(c == 0)
            {
                ans+=(arr.length-j+1);
                count[arr[i]]--;
                if(count[arr[i]] == 0)
                {
                    c++;
                }
                i++;
            }
            else
            {
                count[arr[j]]++;
                if(count[arr[j]] == 1)
                {
                    c--;
                }
                j++;
            }
        }
        while(c == 0)
        {
            ans+=(arr.length-j+1);
            count[arr[i]]--;
            if(count[arr[i]] == 0)
            {
                c++;
            }
            i++;
        }
        return ans;
    }
}


// { Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		    }
		    Solution ob=new Solution();
		    int ans=ob.countDistinctSubarray(a,n);
		    System.out.println(ans);
		    
		}
	}
}
  // } Driver Code Ends