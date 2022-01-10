// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            if(res.size()==0)
                System.out.print("-1 ");
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> search(String pat, String s)
    {
        // your code here
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int n = s.length();
        int prefix[] = new int[n];
        int i = 1;
        int j = 0;
        while(i<pat.length())
        {
            if(pat.charAt(i) == pat.charAt(j))
            {
                prefix[i] = j+1;
                i++;
                j++;
            }
            else
            {
                if(j == 0)
                {
                    prefix[i] = 0;
                    j = 0;
                    i++;
                }
                else
                {
                    j = prefix[j-1];
                }
            }
        }
        
        i = 0;
        j= 0;
        while(i<s.length())
        {
            if(s.charAt(i) == pat.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                if(j == 0)
                {
                    i++;
                }
                else
                {
                    j = prefix[j-1];
                }
            }
            if(j == pat.length())
            {
                arr.add(i-pat.length()+1);
                j = prefix[j-1];
            }
            
        }
        if(arr.size()==0)
        {
            arr.add(-1);
        }
        return arr;
    }
}