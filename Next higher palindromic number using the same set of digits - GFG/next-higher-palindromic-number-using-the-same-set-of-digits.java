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
            System.out.println(obj.nextPalin(s));
        }
            
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String nextPalin(String s) 
    { 
        if(s.length()<=2)
        {
            return "-1";
        }
        //complete the function here
        int n = s.length();
        char arr[] = new char[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = s.charAt(i);
        }
        int x = n/2-2;
        ArrayList<Character> brr = new ArrayList<Character>();
        brr.add(arr[x+1]);
        while(x>=0)
        {
            char cur = arr[x];
            char prev = arr[x+1];
            char y = ' ';
           // System.out.println(cur+" "+prev+" "+x);
            if(cur < prev)
            {
                // swap
                for(int j=0;j<brr.size();j++)
                {
                    y = brr.get(j);
                    if(y>cur)
                    {

                        brr.remove(j);
                        brr.add(cur);
                        break;
                    }
                }
                arr[x] = y;
                arr[n-1-x]=  y;
                break;
            }
            else
            {
                brr.add(cur);
            }
            x--;
        }
       if(x == -1)
       {
           return "-1";
       }
        Collections.sort(brr);
        int k = 0;
        for(int i=x+1;k<brr.size();i++)
        {
            arr[i] = brr.get(k);
            arr[n-1-i] = brr.get(k);
            k++;
        } 
       // System.out.println(brr);
        StringBuilder ans  =  new StringBuilder();
        for(int i=0;i<n;i++)
        {
            ans.append(arr[i]);
        }
        return ans.toString();
    }
}
