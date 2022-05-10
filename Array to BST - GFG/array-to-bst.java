// { Driver Code Starts
//Initial Template for Java

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
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<Integer> fun(int nums[], int l , int h)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(l > h)
        {
            return ans;
        }
        else if(l == h)
        {
            ans.add(nums[l]);
            return ans;
        }
        else
        {
            int m = l+(h-l)/2;
            ans.add(nums[m]);
            ans.addAll(fun(nums,l,m-1));
            ans.addAll(fun(nums,m+1,h));
            return ans;
        }
    }
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
        ArrayList<Integer> ans = fun(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++)
        {
            nums[i] = ans.get(i);
        }
        return nums;
    }
}