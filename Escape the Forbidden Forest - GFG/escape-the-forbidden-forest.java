// { Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String str1 = sc.next();
            String str2 = sc.next();
            Sol obj = new Sol();
            System.out.println(obj.build_bridges(str1,str2));
        }
    }
}// } Driver Code Ends


class Sol
{
    public static int t[][];
    static int fun(String str1 , String str2, int x, int y)
    {
        if(x>=str1.length()||y>=str2.length())
        {
            return 0;
        }
        if(t[x][y]!=-1)
        {
            return t[x][y];
        }
        if(str1.charAt(x) == str2.charAt(y))
        {
            return t[x][y] = 1+fun(str1,str2,x+1,y+1);
        }
        else
        {
            return t[x][y] = Math.max(fun(str1,str2,x+1,y),fun(str1,str2,x,y+1));
        }
    }
    public static int build_bridges(String str1 , String str2)
    {
       // code here 
       t = new int[str1.length()][str2.length()];
       for(int i=0;i<str1.length();i++)
       {
           Arrays.fill(t[i],-1);
       }
       return fun(str1,str2,0,0);
    }
}