// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
        int i = 0;
        int j = n-1;
        while(i<j)
        {
            if(M[j][i] == 0)
            {
                // j not knows i
                if(M[i][j] == 0)
                {
                    i++;
                    j--;
                }
                else
                {
                    i++;
                }
                
            }
            else
            {
                // j knows i
                j--;
            }
        }
        if(i == j)
        {
            for(int k=0;k<n;k++)
            {
                if(k!=i && ( M[i][k] != 0 || M[k][i] != 1) )
                {
                    return -1;
                }
            }
            return i;
        }
        return -1;
    }
}