// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            long ans = ob.countStrings(S); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long countStrings(String S) 
    { 
        // code here
        int arr[] = new int[26];
        long count = 0;
        boolean is = false;
        for(int i=0;i<S.length();i++)
        {
            arr[S.charAt(i)-'a']++;
            if(arr[S.charAt(i)-'a'] >= 2)
            {
                is = true;
            }
        }
        for(int i=0;i<S.length();i++)
        {
            count += (S.length()-arr[S.charAt(i)-'a']);
        }
        count /= 2;
        if(is == true)
        {
            count++;
        }
        return count;
    }
}