// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int keys[]= new int[n];
            for(int i = 0; i < n; i++)
                keys[i] = Integer.parseInt(input_line[i]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int freq[]= new int[n];
            for(int i = 0; i < n; i++)
                freq[i] = Integer.parseInt(input_line1[i]);
            Solution ob = new Solution();
            System.out.println(ob.optimalSearchTree(keys, freq, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Pair
{
    int x,y;
    Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

class Solution
{
    
    static int freq[];
    static int t[][];
    static int fun(ArrayList<Pair> arr, int l ,int r)
    {
        if(l>r)
        {
            return 0;
        }
        if(t[l][r]!=-1)
        {
            return t[l][r];
        }
        int min = Integer.MAX_VALUE;
        for(int i=l;i<=r;i++)
        {
            int cur = arr.get(i).y+fun(arr,l,i-1)+fun(arr,i+1,r);
            if(l-1>=0 && i-1>=0)
            {
                cur+=(freq[i-1]-freq[l-1]);
            }
            else if(i-1>=0)
            {
                cur+=(freq[i-1]);
            }
            cur+=(freq[r]-freq[i]);
            min = Math.min(min,cur);
        }
        return t[l][r] = min;
    }
    
    static int optimalSearchTree(int keys[], int f[], int n)
    {
        // code here
        t = new int[f.length][f.length];
        for(int i=0;i<f.length;i++)
        {
            Arrays.fill(t[i],-1);
        }
        int l = 0;
        freq = f;
        int r = keys.length-1;
        ArrayList<Pair> arr = new ArrayList<Pair>();
        for(int i=0;i<keys.length;i++)
        {
            arr.add(new Pair(keys[i],freq[i]));
        }
        for(int i=1;i<freq.length;i++)
        {
            freq[i] += freq[i-1];
        }
        Collections.sort(arr,(a1,a2)->a1.x-a2.x);
        int min = Integer.MAX_VALUE;
        for(int i=l;i<=r;i++)
        {
                        int cur = arr.get(i).y+fun(arr,l,i-1)+fun(arr,i+1,r);
            if(l-1>=0 && i-1>=0)
            {
                cur+=(freq[i-1]-freq[l-1]);
            }
            else if(i-1>=0)
            {
                cur+=(freq[i-1]);
            }
            cur+=(freq[r]-freq[i]);
            min = Math.min(min,cur);
           // System.out.println(arr.get(i).y+" "+(2*fun(arr,l,i-1) )+" "+( 2*fun(arr,i+1,r) ));
            min = Math.min(min,cur);
        }
        return min;
    }
}
