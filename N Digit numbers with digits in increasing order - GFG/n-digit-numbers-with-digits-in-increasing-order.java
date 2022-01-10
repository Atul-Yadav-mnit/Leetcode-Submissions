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
            int N = sc.nextInt();
			
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.increasingNumbers(N);
            for(int num : ans){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> ans;
    static void fun(int cur, int n)
    {
        if(n == 0)
        {
            ans.add(cur);
            return;
        }
        int x = cur%10;
        for(int i=x+1;i<=10-n;i++)
        {
            fun(cur*10+i,n-1);
        }
    }
    static ArrayList<Integer> increasingNumbers(int N){
        // code here
        ans = new ArrayList<Integer>();
        if(N==1)
        {
            ans.add(0);
        }
        fun(0,N);
        return ans;
    }
}