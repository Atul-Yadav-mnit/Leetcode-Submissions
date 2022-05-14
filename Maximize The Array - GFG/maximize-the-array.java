// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr1 = new int[n], arr2 = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            ArrayList<Integer> ans = new Solution().maximizeArray(arr1, arr2, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<Integer> maximizeArray(int[] arr1, int[] arr2, int n) {
        // code here
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        ArrayList<Integer> a2 = new ArrayList<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        PriorityQueue<Integer> p = new PriorityQueue<Integer>((p1,p2)->{
            if(arr1[p1]==arr1[p2])
            {
                return p1-p2;
            }
            return arr1[p2]-arr1[p1];
            });
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((p1,p2)->{
            if(arr2[p1]==arr2[p2])
            {
                return p1-p2;
            }
            return arr2[p2]-arr2[p1];
            });
            
        for(int i=0;i<n;i++)
        {
            a1.add(-1);
            a2.add(-1);
            p.add(i);
            q.add(i);
        }
        
        HashSet<Integer> h = new HashSet<Integer>();
        int i = 0;
        for(i=0;i<n;i++)
        {
            if(p.isEmpty() || q.isEmpty())
            {
                break;
            }
            int x = p.peek();
            int y = q.peek();
           // System.out.println(arr2[y]+" "+arr1[x]);
            if(arr1[x] > arr2[y])
            {
                if(h.contains(arr1[x]))
                {
                    p.remove();
                    i--;
                    continue;
                }
                p.remove();
                a1.set(x,arr1[x]);
                h.add(arr1[x]);
            }
            else
            {
                if(h.contains(arr2[y]))
                {
                    q.remove();
                    i--;
                    continue;
                }
                q.remove();
                a2.set(y,arr2[y]);
                h.add(arr2[y]);
            }
            
        }
       // System.out.println(a1+" "+a2);
        
        
        for(;i<n && !p.isEmpty();i++)
        {
            int x = p.peek();
            
            if(h.contains(arr1[x]))
            {
                p.remove();
                i--;
                continue;
            }
            p.remove();
            a1.set(x,arr1[x]);
            h.add(arr1[x]);
            
        }
        
       for(;i<n && !q.isEmpty();i++)
        {
            int x = q.peek();
            
            if(h.contains(arr2[x]))
            {
                q.remove();
                i--;
                continue;
            }
            q.remove();
            a2.set(x,arr2[x]);
            h.add(arr2[x]);
            
        }
        
       
        for(i=0;i<n;i++)
        {
            if(a2.get(i)!=-1)
            {
                ans.add(a2.get(i));
            }
        }
        for(i=0;i<n;i++)
        {
            if(a1.get(i)!=-1)
            {
                ans.add(a1.get(i));
            }
        }
        
        
        return ans;
    }
}