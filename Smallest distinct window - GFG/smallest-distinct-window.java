// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String str) {
        // Your code goes here
        //str = str.toLowerCase();
        int c[] = new int[256];
        int c2[] = new int[256];
        int count = 0;
        for(int i=0;i<str.length();i++)
        {
            if(c[str.charAt(i)] == 0)
            {
                count++;
            }
            c[str.charAt(i)]++;
            c2[str.charAt(i)] = c[str.charAt(i)];
        }
        int i = 0;
        int j = 0;
        int ans = str.length();
        while(j<str.length())
        {
            if(count == 0)
            {
                ans = Math.min(ans,j-i);
               // System.out.println(str.substring(i,j));
                c[str.charAt(i)]++;
                if(c[str.charAt(i)] == c2[str.charAt(i)])
                {
                    count++;
                }
                i++;
            }
            else
            {
                if(c[str.charAt(j)] == c2[str.charAt(j)])
                {
                    count--;
                }
               // System.out.println(str.substring(i,j+1)+" "+count);
                c[str.charAt(j)]--;
                j++;
            }
        }
        while(count == 0)
        {
            ans = Math.min(ans,j-i);
            c[str.charAt(i)]++;
            if(c[str.charAt(i)] == c2[str.charAt(i)])
            {
                count++;
            }
            i++;
        }
        return ans;
    }
}