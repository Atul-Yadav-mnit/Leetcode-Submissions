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
            String input = read.readLine();
            
            Solution ob = new Solution();
            int result = ob.isRepeat(input);
            
            System.out.println(result);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int isRepeat(String s) {
        // code here
        int n = s.length();
        int p[] = new int[n];
        int i=0,j=1;
        while(j<n)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                p[j] = i+1;
                i++;
                j++;
            }
            else
            {
                if(i == 0)
                {
                    p[j] = 0;
                    j++;
                }
                else
                {
                    i = p[i-1];
                }
            }
        }
        int x = n-p[n-1];
        if(x > p[n-1])
        {
            return 0;
        }
        i = x;
        j = 0;
        while(i<s.length())
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return 0;
            }
            i++;
            j = (j+1)%x;
        }
        if(j == 0)
        {
            return 1;
        }
        return 0;
    }
}