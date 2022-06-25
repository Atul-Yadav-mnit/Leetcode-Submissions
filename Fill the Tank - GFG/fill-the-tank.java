// { Driver Code Starts
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
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int S = Integer.parseInt(input_line[1]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int cap[] = new int[N+1];
            for(int i=0;i<N;i++){
                cap[i] = Integer.parseInt(input_line1[i]);
            }
            int Edges[][] = new int[N+1][2];
            for(int i=0;i<N-1;i++){
                String input_line2[] = read.readLine().trim().split("\\s+");
                Edges[i][0] = Integer.parseInt(input_line2[0]);
                Edges[i][1] = Integer.parseInt(input_line2[1]);
            }
            Solution ob = new Solution();
            long ans = ob.minimum_amount(Edges, N, S, cap);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


class Solution{
    ArrayList<ArrayList<Integer>> adj;
    boolean aa = false;
    long m = 1000000000000000000L;
    long fun(int cur, int par, int cap[])
    {
        long max = 0;
        long count = 0;
        for(int i=0;i<adj.get(cur).size();i++)
        {
            int j = adj.get(cur).get(i);
            if(j!=par)
            {
                long z = fun(j,cur,cap);
                if(z > m || z == -1)
                {
                    return -1;
                }
                max = Math.max(max,z);
                count++;
            }
        }
        long ans =  (long)cap[cur]+(max*count);
        if(ans > m )
        {
            return -1L;
        }
        return ans;
    }
    long minimum_amount(int [][]Edges, int N, int S, int []cap){
        // Code here
        adj =  new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<N;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<N-1;i++)
        {
            int x = Edges[i][0]-1;
            int y = Edges[i][1]-1;
       //     System.out.println(x+" "+y);
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        return fun(S-1,-1,cap);
    }
    
}
