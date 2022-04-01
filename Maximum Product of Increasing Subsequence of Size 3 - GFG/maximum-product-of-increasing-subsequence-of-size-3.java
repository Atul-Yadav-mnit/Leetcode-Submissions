// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int arr [] = new int[N];
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<N;i++){
	            arr[i] = Integer.parseInt(elements[i]);    
	        }
	        
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.maxProductSubsequence(arr, N);
        	if(ans.get(0) == -1)
        	    System.out.println("Not Present");
        	else{
        	    for(int i: ans)
        	        System.out.print(i + " ");
        	    System.out.println();
        	}
        	
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
    
    public static ArrayList<Integer> maxProductSubsequence (int arr[], int n) {
        //Complete the function
        int maxr[] = new int[n];
        maxr[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--)
        {
            maxr[i] = Math.max(maxr[i+1],arr[i]);
        }
        TreeSet<Integer> t = new TreeSet<Integer>();
        t.add(arr[0]);
        long maxp = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>(3);
        ans.add(0);
        ans.add(0);
        ans.add(0);
        int in = -1;
        int min = arr[0];
        for(int i=1;i<n-1;i++)
        {
            int x = arr[i];
            if(x>min && maxr[i+1]>x)
            {
                long a = (long)t.floor(x-1);
                long b = (long)x;
                long c = (long)maxr[i+1];
                if(maxp < a*b*c)
                {
                    in = 1;
                    maxp = a*b*c;
                    ans.set(0,(int)a);
                    ans.set(1,(int)b);
                    ans.set(2,(int)c);
                }
            }
            t.add(x);
        }
        if(in == -1)
        {
            ans = new ArrayList<Integer>(1);
            ans.add(-1);
        }
        return ans;
    }
    
    
}

