// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            int numbers[]= new int[N];
            for(int i = 0; i < N; i++)
                numbers[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.countPairs(N, X, numbers); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int fun(int n)
    {
        int c = 0;
        while(n>0)
        {
            c++;
            n = n/10;
        }
        return c;
    }
    long countPairs(int N, int X, int nums[]) 
    { 
        // code here
        int n = fun(X);
        long ans = 0;
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(h.containsKey(nums[i]) == false)
            {
                h.put(nums[i],1);
            }
            else
            {
                
                int xx  = h.get(nums[i]);
                h.put(nums[i],xx+1);
            }
        }
        int k = 1;
        for(int i=0;i<n;i++)
        {
            k = k*10;
            int p1 = X/k;
            int p2 = X%k;
            int x1 = fun(p1);
            int x2 = fun(p2);
            ///System.out.println(p1+" "+p2);
            if(x1+x2==n && p1!=p2 && h.containsKey(p1) && h.containsKey(p2))
            {
                ans+= (h.get(p1)*h.get(p2));
            }
            if(x1+x2==n  && p1==p2 &&  h.containsKey(p1))
            {
                ans+= (h.get(p1)*(h.get(p1)-1));
            }
        }
        return ans;
    }
} 