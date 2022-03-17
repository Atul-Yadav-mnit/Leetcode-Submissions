// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    ArrayList<Integer> A = new ArrayList<Integer>();
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		        A.add(arr[i]);
		        
		    }
		   
		   
		    
		    ArrayList <ArrayList<Integer>> res = new Solution().subsets(A);
		    for (int i = 0; i < res.size (); i++)
		    {
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		          System.out.print(res.get(i).get(j)+" ");
		        }
		        System.out.println();
		      
		    }
		    //System.out.println();
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static ArrayList<ArrayList<Integer>> adj;
    
    public static void fun(ArrayList<Integer> temp , int x, ArrayList<Integer> A)
    {
        ArrayList<Integer> temp2 = new ArrayList<Integer>(temp);
        ArrayList<Integer> temp3 = new ArrayList<Integer>(temp);
        if(x == A.size())
        {
            adj.add(temp2);
            return;
        }
        fun(temp3,x+1,A);
        temp2.add(A.get(x));
        fun(temp2,x+1,A);
        
    }
    
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        //code here
        adj = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        fun(temp,0,A);
        Collections.sort(adj,(a1,a2) -> {
            StringBuilder s1 = new StringBuilder();
            for(int i=0;i<a1.size();i++)
            {
                int x = a1.get(i)%10;
                int y = a1.get(i)/10;
                x = y*10+x;
                char c = (char)x;
                s1.append(c);
                s1.append("_");
            }
            StringBuilder s2 = new StringBuilder();
            for(int i=0;i<a2.size();i++)
            {
                int x = a2.get(i)%10;
                int y = a2.get(i)/10;
                x = y*10+x;
                char c = (char)x;
                s2.append(c);
                s2.append("_");
            }
            String a11 = String.valueOf(s1);
            String a12 = String.valueOf(s2);
            int ans = a11.compareTo(a12);
           // System.out.println(a11+" "+a12+" "+ans);
            return ans;
            });
        return adj;
    }
    
}