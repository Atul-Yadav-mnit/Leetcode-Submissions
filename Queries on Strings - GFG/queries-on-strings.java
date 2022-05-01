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
            int q = Integer.parseInt(br.readLine().trim());
            int[][] Query = new int[q][2];
            for(int i = 0; i < q; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < 2; j++){
                    Query[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.SolveQueris(str, Query);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] SolveQueris(String s, int[][] q)
    {
        // Code here
        int arr[][] = new int[s.length()][26];
        arr[0][s.charAt(0)-'a']++;
        for(int i=1;i<s.length();i++)
        {
            for(int j=0;j<26;j++)
            {
                arr[i][j] = arr[i-1][j];
            }
            arr[i][s.charAt(i)-'a']++;
            
        }
        
        int ans[] = new int[q.length];
        for(int i=0;i<q.length;i++)
        {
            int count = 0;
            int l = q[i][0]-1;
            int r = q[i][1]-1;
            if(l == 0)
            {
             
                for(int j=0;j<26;j++)
                {
                    if(arr[r][j] > 0)
                    {
                        count++;
                     //   System.out.println(j);
                    }
                }
            }
            else
            {
                for(int j=0;j<26;j++)
                {
                    if(arr[r][j]-arr[l-1][j] > 0)
                    {
                        count++;
                    }
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}