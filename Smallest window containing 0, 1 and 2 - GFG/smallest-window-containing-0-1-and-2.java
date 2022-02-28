// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String s) {
        // Code here
        int i = 0;
        int j = 0;
        int c[] = new int[3];
        int ans = s.length()+1;
        while(j<s.length())
        {
            c[s.charAt(j)-'0']++;
            while(c[0] >0 && c[1]>0 && c[2] > 0)
            {
                ans = Math.min(ans,j-i+1);
                c[s.charAt(i)-'0']--;
                i++;
            }
            j++;
        }
        while(c[0] >0 && c[1]>0 && c[2] > 0)
        {
            ans = Math.min(ans,j-i+1);
            c[s.charAt(i)-'0']--;
            i++;
        }
        if(ans == s.length()+1)
        {
            return -1;
        }
        return ans;
    }
};
