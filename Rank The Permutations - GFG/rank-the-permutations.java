// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution obj = new Solution();
            long ans = obj.findRank(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

//User function Template for Java
class Solution
{
    public long findRank(String S)
    {
        // Code here
        long arr[] = new long[26];
        for(int i=0;i<S.length();i++)
        {
            int x = S.charAt(i)-'a';
            arr[x]++;
        }
        long cur = 1;
        for(int i=1;i<S.length();i++)
        {
            cur = cur*i;
        }
        long count = 0;
        for(int i=0;i<S.length();i++)
        {
            int k = 0;
            for(int j=0;j<26;j++)
            {
                char c = (char)(j+'a');
                //System.out.println(c);
                if(arr[j]>0 && c<S.charAt(i))
                {
                    k+=arr[j];
                }
            }
            //System.out.println(k);
            count += (k)*cur;
            if(i<S.length()-1)
            cur = cur/(S.length()-i-1);
            arr[S.charAt(i)-'a']--;
        }
        return count+1;
    }
}