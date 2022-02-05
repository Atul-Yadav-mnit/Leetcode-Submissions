// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine());
    
	    while(t > 0){
	        int n = Integer.parseInt(br.readLine());
	        Solution T = new Solution();
	        
	        System.out.println(T.excelColumn(n));
	        
            t--;
	    }
	}
    
}// } Driver Code Ends


//User function Template for Java

class Solution {
    public String excelColumn(int N){
        
        //  Your code here
        Stack<Character> s = new Stack<Character>();
        while(N>0)
        {
            if(N%26==0)
            {
                s.push('Z');
                N=N/26;
                N--;
                continue;
            }
            char c = (char)((N%26)-1+'A');
            s.push(c);
            N = N/26;
        }
        StringBuilder ans = new StringBuilder();
        while(!s.isEmpty())
        {
            ans.append((char)s.pop());
        }
        return ans.toString();
    }
}