// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

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
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix,r,c);
            System.out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int [] endPoints(int [][]arr, int m, int n){
        //code here
        int ans[] = new int[2];
        int x = 0;
        int y = 0;
        int dir = 1;// 1 = right 2 = left 3 = up 4 down
        while(true)
        {
            if(arr[x][y] == 0)
            {
                if(dir == 1)
                {
                    y++;
                    if(y>=n)
                    {
                        ans[0] = x;
                        ans[1] = y-1;
                        break;
                    }
                }
                else if(dir == 2)
                {
                    y--;
                    if(y<0)
                    {
                        ans[0] = x;
                        ans[1] = y+1;
                        break;
                    }
                }
                else if(dir == 3)
                {
                    x--;
                    if(x<0)
                    {
                        ans[0] = x+1;
                        ans[1] = y;
                        break;
                    }
                }
                else if(dir == 4)
                {
                    x++;
                    if(x>=m)
                    {
                        ans[0] = x-1;
                        ans[1] = y;
                        break;
                    }
                }
            }
            else
            {
                arr[x][y] = 0;
                if(dir == 1)
                {
                    dir = 4;
                }
                else if(dir == 2)
                {
                    dir = 3;
                }
                else if(dir == 3)
                {
                    dir = 1;
                }
                else if(dir == 4)
                {
                    dir = 2;
                }
            }
            //System.out.println(x+" "+y+" "+dir);
        }
        return ans;
        
    }
}