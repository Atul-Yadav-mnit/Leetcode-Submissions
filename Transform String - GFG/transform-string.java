// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String arr[] = br.readLine().split(" ");
                    String A = arr[0];
                    String B = arr[1];
                    Solution obj = new Solution();
                    System.out.println(obj.transform (A, B));
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int transform (String A, String B)
    {
        // code here
        int i = A.length()-1;
        int j = B.length()-1;
        if(i!=j)
        {
            return -1;
        }
        int count[] = new int[256];
        while(i>=0)
        {
            if(A.charAt(i) == B.charAt(j))
            {
                i--;
                j--;
            }
            else
            {
                count[A.charAt(i)]++;
                i--;
            }
        }
        i = j;
        while(i>=0)
        {
            if(count[B.charAt(i)]<1)
            {
                return -1;
            }
            count[B.charAt(i)]--;
            i--;
        }
        return j+1;
    }
}