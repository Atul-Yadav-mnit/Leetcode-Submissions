// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.arrangeString(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String arrangeString(String s)
        {
            //code here.
            int arr[] = new int[26];
            StringBuilder ans = new StringBuilder();
            int sum=0;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)-'A' >= 0 && s.charAt(i)-'A' <= 25)
                {
                    arr[s.charAt(i)-'A']++;
                }
                else
                {
                    sum+=(int)(s.charAt(i)-'0');
                }
            }
            for(int i=0;i<26;i++)
            {
                char c = (char)((int)'A'+i);
                for(int j=0;j<arr[i];j++)
                {
                    ans.append(c);
                }
            }
            
            if(sum!=0)
            ans.append(sum);
            return ans.toString();
        }
}
