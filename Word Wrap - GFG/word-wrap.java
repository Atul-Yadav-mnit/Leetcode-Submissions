// { Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int t[];
    public int fun(int nums[],int x, int k)
    {
        if(x == nums.length)
        {
            return 0;
        }
        if(t[x]!=-1)
        {
            return t[x];
        }
        int i = x;
        int r = k;
        int ans = Integer.MAX_VALUE;
        while(r>=nums[i])
        {
            r -= nums[i];
            //  k - (r)
            ans = Math.min(ans, ((r)*(r))+ fun(nums,i+1,k));
            r = r-1;
            i++;
            if(i == nums.length)
            {
                ans = 0;
                break;
            }
        }
        return t[x] = ans;
    }
    
    public int solveWordWrap (int[] nums, int k)
    {
        // Code here 
        t = new int[nums.length];
        Arrays.fill(t,-1);
        return fun(nums,0,k);
    }
    
    
}