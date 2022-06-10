// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int T = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            int[] B = new int[N];
            
            for(int i=0; i<N; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxCoins(A,B,T,N));
        }
    }
}// } Driver Code Ends


class Solution {
    static class Pair{
        int p,g;
        Pair(int p, int g){
            this.p = p;
            this.g = g;
        }
    }
    static int maxCoins(int[] A, int[] B, int T, int N) {
        // code here
        ArrayList<Pair> arr = new ArrayList<Pair>();
        for(int i=0;i<N;i++)
        {
            arr.add(new Pair(A[i],B[i]));
        }
        Collections.sort(arr,(p1,p2) -> p2.g-p1.g);
        int ans  = 0;
        for(int i=0;i<N;i++)
        {
            Pair x = arr.get(i);
            if(x.p <= T)
            {
                ans += x.g*x.p;
                T-=x.p;
            }
            else
            {
                ans += T*x.g;
                break;
            }
        }
        return ans;
    }
}