// { Driver Code Starts
import java.util.*;
import java.math.*;

class Pair{
    
    int x,y;
    Pair(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}

class Gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int m = Integer.parseInt(sc.next());
            int n = Integer.parseInt(sc.next());
            char mat[][] = new char[m][n];
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
           
            Solution T = new Solution();
            int ans[][] = T.findDistance(mat, m, n);
            
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Pai
{
    int x,y;
    Pai(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

}
        
class Solution
{
    
    
    public static int[][] findDistance(char mat[][], int m,int n)
    {
        // Your code goes here
        ArrayList<Pai> arr = new  ArrayList<Pai>();
        ArrayList<Integer> pos = new  ArrayList<Integer>();
        int vis[][] = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++)
        {
            Arrays.fill(vis[i],-1);
            for(int j=0;j<mat[i].length;j++)
            {
                if(mat[i][j] == 'B')
                {
                    arr.add(new Pai(i,j));
                    pos.add(0);
                    vis[i][j] = 0;
                }
                
            }
        }
        while(arr.size()>0)
        {
            Pai p = arr.remove(0);
            int a = pos.remove(0);
            if(p.x+1<mat.length && mat[p.x+1][p.y] == 'O')
            {
                vis[p.x+1][p.y] = a+1;
                mat[p.x+1][p.y] = 'M';
                arr.add(new Pai(p.x+1,p.y));
                pos.add(a+1);
            }
            
            if(p.x-1>=0 && mat[p.x-1][p.y] == 'O')
            {
                vis[p.x-1][p.y] = a+1;
                mat[p.x-1][p.y] = 'M';
                arr.add(new Pai(p.x-1,p.y));
                pos.add(a+1);
            }
             if(p.y+1<mat[0].length && mat[p.x][p.y+1] == 'O')
            {
                vis[p.x][p.y+1] = a+1;
                mat[p.x][p.y+1] = 'M';
                arr.add(new Pai(p.x,p.y+1));
                pos.add(a+1);
            }
            
            if(p.y-1>=0 && mat[p.x][p.y-1] == 'O')
            {
                vis[p.x][p.y-1] = a+1;
                mat[p.x][p.y-1] = 'M';
                arr.add(new Pai(p.x,p.y-1));
                pos.add(a+1);
            }
        }
        
        return vis;
    }
}