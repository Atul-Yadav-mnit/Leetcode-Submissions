// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
        	int N = Integer.parseInt(br.readLine()); 
        	int[] Arr = new int[N];
        	String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
        	for(int i=0; i<N; i++)
        	{
        		Arr[i] = Integer.parseInt(strs[i]); 
        	}
        	

            Solution ob = new Solution();
			int[] ans = ob.farNumber(N,Arr);
  
            for(int i=0; i<ans.length; i++)
                out.print(ans[i] + " ");
            out.println();

            t--;
        }
        out.flush();
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int[] farNumber(int N, int Arr[])
	{    
	    int min[] = new int[N];
	    min[N-1] = Arr[N-1];
	    for(int i=N-2;i>=0;i--)
	    {
	        min[i] = Math.min(min[i+1],Arr[i]);
	    }
	    int ans[] = new int[N];
	    Arrays.fill(ans,-1);
	    for(int i=0;i<N-1;i++)
	    {
	        int l = i+1;
            int h = N-1;
            while(l<=h)
            {
                int m = l+(h-l)/2;
                if(min[m] < Arr[i])
                {
                    ans[i] = m;
                    l = m+1;
                }
                else
                {
                    h = m-1;
                }
            }
	    }
	    return ans;
	}
} 