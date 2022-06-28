// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            StringTokenizer stt = new StringTokenizer(br.readLine());
            long k1 = Long.parseLong(stt.nextToken());
            long k2 = Long.parseLong(stt.nextToken());
            
            Solution obj = new Solution();
            System.out.println( obj.sumBetweenTwoKth(a, n, k1, k2) );
            
        }
	}
}// } Driver Code Ends


//User function Template for Java


class Solution { 
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2)
    {
        if(K1==K2)
        {
            return 0L;
        }
        // Your code goes here
        TreeSet<Long> t = new TreeSet<Long>();
        for(int i=0;i<A.length;i++)
        {
            t.add(A[i]);
        }
        Iterator i = t.iterator();
        int x = 1;
        long sum = 0;
        boolean isa = false;
        while(i.hasNext())
        {
            if(x == K1)
            {
                i.next();
                isa=true;
            }
            else if(x==K2)
            {
                i.next();
                isa = false;
            }
            else if(isa)
            {
                long y = (long)i.next();
                sum+=y;
            }
            else
            i.next();
            x++;
        }
        return sum;
    }
    
}
