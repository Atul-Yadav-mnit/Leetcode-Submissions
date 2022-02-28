// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java

class Solution{
    public static String moveRobots(String s1, String s2){
        //code here
        ArrayList<Character> arr = new ArrayList<Character>();
        ArrayList<Integer> pos = new ArrayList<Integer>();
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i) == 'A'||s1.charAt(i)=='B')
            {
                arr.add(s1.charAt(i));
                pos.add(i);
            }
        }
        int k = 0;
        for(int i=0;i<s2.length();i++)
        {
            
            if(s2.charAt(i) == 'A')
            {
                if(k>=arr.size())
                {
                    return "No";
                }
                char x = arr.get(k);
                int p = pos.get(k);
                k++;
                if(x!='A' || p<i)
                {
                    return "No";
                }
            }
            else if(s2.charAt(i) == 'B')
            {
                if(k>=arr.size())
                {
                    return "No";
                }
                char x = arr.get(k);
                int p = pos.get(k);
                k++;
                if(x!='B' || p>i)
                {
                    return "No";
                }
            }
        }
        return "Yes";
    }
}


// { Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s1=read.readLine();
            String s2=read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.moveRobots(s1, s2));
        }
    }
}  // } Driver Code Ends