// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());

            int arr[][] = new int[(int)(N)][2];

            for (int j = 0; j < 2; j++) {
                String inputLine2[] = br.readLine().trim().split(" ");
                for (int i = 0; i < N; i++) {
                    arr[i][j] = Integer.parseInt(inputLine2[i]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBalloons(N, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int gcd(int a, int b)
    {
        if(b == 0)
        {
            return a;
        }
        return gcd(b,a%b);
    }
    public int mostBalloons(int N, int arr[][]) {
        
        int fans = 1;
        
        
        for(int i=0;i<arr.length;i++)
        {
            HashMap<String,Integer> h = new HashMap<String,Integer>();
            int count = 0;
            int ans = 0;
            for(int j=i+1;j<arr.length;j++)
            {
                  int dx = arr[i][0]-arr[j][0];
                int dy = arr[i][1]-arr[j][1];
                if(dx == 0 && dy == 0)
                {
                    count++;
                    continue;
                }
              
                char isneg = '+';
                if( (dx>=0 && dy>=0) || (dx<0 && dy<0) )
                {
                    isneg = '-';
                }
                dx = Math.abs(dx);
                dy = Math.abs(dy);
                if(dx == 0 || dy==0)
                {
                    if(dx == 0)
                    {
                        dx = 0;
                        int ddy = 2000000002;
                        isneg = '+';
                        String key = String.valueOf(isneg)+" "+String.valueOf(ddy)+"/"+String.valueOf(dx);
                       // System.out.println(key);
                        if(h.containsKey(key)==true)
                        {
                            h.put(key,h.get(key)+1);
                           // System.out.println(h.get(key));
                            ans = Math.max(ans,h.get(key));
                        }
                        else
                        {
                            h.put(key,2);
                            ans = Math.max(ans,2);
                           // System.out.println(2);
                        }
                    }
                    if(dy==0)
                    {
                        dx = 2000000002;
                        dy = 0;
                        isneg = '+';
                         String key = String.valueOf(isneg)+" "+String.valueOf(dy)+"/"+String.valueOf(dx);
                        //System.out.println(key);
                        if(h.containsKey(key)==true)
                        {
                            h.put(key,h.get(key)+1);
                          //  System.out.println(h.get(key));
                            ans = Math.max(ans,h.get(key));
                        }
                        else
                        {
                            h.put(key,2);
                            ans = Math.max(ans,2);
                          //  System.out.println(2);
                        }
                    }
                    
                }
                else
                {
                    int g = gcd(dx,dy);
                    dx = dx/g;
                    dy = dy/g;
                    String key = String.valueOf(isneg)+" "+String.valueOf(dy)+"/"+String.valueOf(dx);
                    // System.out.println(key);
                    if(h.containsKey(key)==true)
                    {
                        h.put(key,h.get(key)+1);
                       // System.out.println(h.get(key));
                        ans = Math.max(ans,h.get(key));
                    }
                    else
                    {
                        h.put(key,2);
                        ans = Math.max(ans,2);
                       // System.out.println(2);
                    }
                }
                
               
            }
            fans = Math.max(fans,count+ans);
        }
        return fans;

    }
}