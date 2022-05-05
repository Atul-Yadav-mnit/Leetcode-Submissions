// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String str[] = read.readLine().split(" ");
            String S= str[0];
            int a = Integer.parseInt(str[1]);
            int b = Integer.parseInt(str[2]);
            Solution ob = new Solution();
            System.out.println(ob.stringPartition(S,a,b));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution{
    static String stringPartition(String S, int a, int b){
        // code here
        int no1 = 0;
        int no2 = 1;
        int count = 1;
        for(int i=0;i<S.length();i++)
        {
            int x = S.charAt(i)-'0';
            no2 = no2*10 + x;
            count = count*10;
        }
        for(int i=0;i<S.length()-1;i++)
        {
            int x = S.charAt(i)-'0';
            no1 = no1*10 + x;
            count = count/10;
            no2 = no2%count;
            if(no1%a == 0 && no2%b == 0)
            {
                return S.substring(0,i+1)+" "+S.substring(i+1);
            }
        }
        return "-1";
    }
}