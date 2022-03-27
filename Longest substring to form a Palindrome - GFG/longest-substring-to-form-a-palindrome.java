// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
   
    static int longestSubstring(String S) {
        // code here
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        int t[] = new int[26];
        int max = 0;
        h.put(0,-1);
        int pow[] = new int[26];
        pow[0] = 1;
        for(int i=1;i<26;i++)
        {
            pow[i] = pow[i-1]*2;
        }
        
        int count = 0;
        for(int i=0;i<S.length();i++)
        {
            
            int x = S.charAt(i)-'a';
            if(t[x] == 0)
            {
                t[x] = 1;
                count += pow[x];
            }
            else
            {
                t[x] = 0;
                count -= pow[x];
            }
            if(h.containsKey(count))
            max = Math.max(max,  i-h.get(count) );
            for(int j=0;j<26;j++)
            {
                if(t[j]==1)
                {
                    count -= pow[j];
                    if(h.containsKey(count))
                    max = Math.max(max,  i-h.get(count) );
                    count += pow[j];
                }
                else
                {
                    count += pow[j];
                    if(h.containsKey(count))
                    max = Math.max(max,  i-h.get(count) );
                    count -= pow[j];
                }
            }
            if(!h.containsKey(count))
            h.put(count,i);
            
        }
        return max;
    }
};