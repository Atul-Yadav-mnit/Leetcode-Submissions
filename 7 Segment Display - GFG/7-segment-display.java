// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.sevenSegments(S,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static String t[][];
    static int fun(int x)
    {
        int ans = 0;
        if(x == 0)
        {
            ans = 6;
        }
        else if(x == 1)
        {
            ans = 2;
        }
        else if(x == 2)
        {
            ans = 5;
        }
        else if(x == 3)
        {
            ans = 5;
        }
        else if(x == 4)
        {
            ans = 4;
        }
        else if(x == 5)
        {
            ans = 5;
        }
        else if(x == 6)
        {
            ans = 6;
        }
        else if(x == 7)
        {
           ans = 3;
        }
        else if(x == 8)
        {
            ans = 7;
        }
        else if(x == 9)
        {
           ans = 5;
        }
        return ans;
    }
    
    // static String fun2( int cur, int x)
    // {
    //   // System.out.println(cur+" "+x);
     
    //     if(x == 0)
    //     {
    //         if(cur == 0)
    //         {
    //             return "----";
    //         }
    //         else
    //         {
    //             return "";
    //         }
    //     }
    //     if(cur < 2)
    //     {
    //         return "";
    //     }
    //     if(t[x][cur]!="--")
    //     {
            
            
    //         return t[x][cur];
    //     }
    //     for(int i=0;i<=9;i++)
    //     {
    //         int c = fun(i);
    //         if(cur<c)
    //         {
    //             continue;
    //         }
    //       //  System.out.println( (cur-c)+ " "+(x-1));
    //         String s = fun2(cur-c,x-1);
    //              System.out.println(x+" "+cur+" "+t[x][cur]);
    //         if(s.length() == x-1)
    //         {
    //             t[x][cur] = (String.valueOf(i)+x);
                
    //           // System.out.println(x+" "+cur+" "+t[x][cur]);
    //             return t[x][cur];
    //         }
    //     }
       
    //     t[x][cur] = "";
       
    //   // System.out.println(x+" "+cur+" "+t[x][cur]);
    //     return t[x][cur];
    // }
    static String sevenSegments(String S, int N) {
        // code here
        int cur = 0;
        for(int i=0;i<N;i++)
        {
            int x = S.charAt(i)-'0';
            cur += fun(x);
        }
        // t = new String[N+1][cur+1];
        // for(int i=0;i<N+1;i++)
        // {
        //     Arrays.fill(t[i],"--");
        // }
        // System.out.println(t[5][22]+" "+"hi");
        // String ans = fun2(cur,N);
        StringBuilder ans = new StringBuilder();
         // System.out.println(cur+" "+(N*8));
        if(cur > (N*6))
        {
            int rem = cur-N*6;
            for(int i=0;i<N-rem;i++)
            {
                ans.append('0');
            }
            for(int i=0;i<rem;i++)
            {
                ans.append('8');
            }
            return ans.toString();
        }
      
        int n = N;
        for(int i=0;i<n;i++)
        {
            if(cur-6 >= (n-1-i)*2)
            {
                ans.append('0');
                cur = cur-6;
            }
            else
            {
                int rem = cur - (n-i)*2;
                if(rem == 0)
                {
                    for(int j=0;j<(n-i);j++)
                    {
                        ans.append('1');
                    }
                    break;
                }
                else if(rem == 1)
                {
                    for(int j=0;j<(n-i-1);j++)
                    {
                        ans.append('1');
                    }
                    ans.append('7');
                    break;
                }
                else if(rem == 2)
                {
                    for(int j=0;j<(n-i-1);j++)
                    {
                        ans.append('1');
                    }
                    ans.append('4');
                    break;
                }
                else if(rem == 3)
                {
                    for(int j=0;j<(n-i-1);j++)
                    {
                        ans.append('1');
                    }
                    ans.append('2');
                    break;
                }
            }
        }
     
        return ans.toString();
    }
};