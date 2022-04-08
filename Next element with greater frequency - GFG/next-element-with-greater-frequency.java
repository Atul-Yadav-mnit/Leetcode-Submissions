// { Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // int arr[] = new int[10000];
        
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]=new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i] = sc.nextInt();
            }
            
            solver x = new solver();
            int res[]=x.print_next_greater_freq(arr,n);
            StringBuffer sb=new StringBuffer("");
            for(int i : res){
                sb.append(i+" ");
            }
            System.out.println(sb);
        }
    }
}
// } Driver Code Ends


class solver
{
    static int[] print_next_greater_freq(int arr[], int n)
    {
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            if(h.containsKey(arr[i]))
            {
                h.put(arr[i],h.get(arr[i])+1);
            }
            else
            {
                h.put(arr[i],1);
            }
        }
        int freq[] = new int[arr.length];
        for(int i=0;i<n;i++)
        {
            freq[i] = h.get(arr[i]);
        }
        Stack<Integer> s = new Stack<Integer>();
        int ans[] = new int[n];
        Arrays.fill(ans,-1);
        for(int i=n-1;i>=0;i--)
        {
            while(!s.isEmpty() && freq[s.peek()]<=freq[i])
            {
                s.pop();
            }
            if(!s.isEmpty())
            {
                ans[i] = arr[s.peek()];
            }
            s.push(i);
        }
        return ans;
    }
}

