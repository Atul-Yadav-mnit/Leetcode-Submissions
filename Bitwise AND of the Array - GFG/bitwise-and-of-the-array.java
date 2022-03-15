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
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int ans = ob.count(N, A, X); 
            System.out.println(ans);
        }
    } 
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int count(int N, int A[], int X) 
    {   
        // code here
        
       
        int count = N;
        int pow = (int)Math.pow(2,30);
        int buf = 0;
        X++;
        while(pow>0)
        {
         
            int req = X/pow;
            X = X%pow;
            int cur = 0;
           // System.out.println("pow and req "+pow+" "+req);
            if(req == 0)
            {
                
                for(int i=0;i<N;i++)
                {
                    int y = A[i]/pow;
                    A[i] = A[i]%pow;
                    if(y ==1)
                    {
                        
                    }
                    else
                    {
                        cur++;
                    }
                }
               // System.out.println("ans is "+cur+" "+buf);
                count = Math.min(cur+buf,count);
            }
            else
            {
                for(int i=0;i<N;i++)
                {
                    int y = A[i]/pow;
                    A[i] = A[i]%pow;
                    if(y ==1)
                    {
                        
                    }
                    else
                    {
                        cur++;
                        buf++;
                        A[i] = pow-1;
                    }
                }
               // System.out.println(buf);
               // count = Math.min(cur,count+buf);
            }
            pow = pow/2;
           // System.out.println("count = "+count);
        }
        count = Math.min(buf,count);
        return count;
    }
} 