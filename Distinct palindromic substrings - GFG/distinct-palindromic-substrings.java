// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String str = read.readLine().trim(); 
            Solution obj = new Solution();
            int ans = obj.palindromeSubStrs(str);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    boolean b[][],t[][];
    boolean fun(int x, int y, String str)
    {
        if(x>=y)
        {
            return true;
        }
        if(b[x][y])
        {
            return t[x][y];
        }
        if(str.charAt(x) == str.charAt(y))
        {
            b[x][y] = true;
            return t[x][y] = fun(x+1,y-1,str);
        }
        return t[x][y] = false;
    }
    
    int palindromeSubStrs(String str) { 
        // code here 
        int n = str.length();
        b = new boolean[n][n];
        t = new boolean[n][n];
        HashSet<String> h = new HashSet<String>();
        int count = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(fun(i,j,str))
                {
                    h.add(str.substring(i,j+1));
                }
            }
        }
        return h.size();
    }
} 