// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int r = Integer.parseInt(inputLine[0]);
            int c = Integer.parseInt(inputLine[1]);
            boolean[][] mat = new boolean[r][c];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    mat[i][j] = (Integer.parseInt(inputLine[i * c + j]) == 1);
                }
            }

            int ans = new Solution().maxArea(mat, r, c);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    int maxArea(boolean[][] m, int r, int c) {
        // code here
        int ans = 0;
        int mat[][] = new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                
                if(m[i][j])
                {
                    mat[i][j] =1;
                }
                
            }
        }
        for(int i=0;i<r;i++)
        {
            int temp[] = new int[c];
            for(int j=0;j<c;j++)
            {
                if(i>0 && mat[i][j] == 1)
                {
                    mat[i][j] = mat[i-1][j]+1;
                }
                temp[j] = mat[i][j];
            }
            Arrays.sort(temp);
            for(int k=0;k<c;k++)
            {
            
                ans = Math.max(ans, (c-k)*temp[k] );
            }
        }
        return ans;
    }
}