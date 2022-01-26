// { Driver Code Starts
//Initial Template for Java

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
                    int n = sc.nextInt();
                    ArrayList<Integer> arr = new ArrayList<Integer>();
                    ArrayList<Integer> res = new ArrayList<Integer>();
                    for(int i=0; i<n; i++)
                        {
                            int x = sc.nextInt();
                            arr.add(x);
                        }
                    int k = sc.nextInt();
                    
                    Solution obj = new Solution();
                    res = obj.TopK(arr,k);
                    
                    for(int i=0; i<res.size();i++)
                        {
                            System.out.print(res.get(i) + " ");
                        }
                    System.out.println();    
                    
                        
                }
        }
}// } Driver Code Ends


class Solution
{
    class Node
    {
        int x;
        int id;
        Node(int x, int id)
        {
            this.x = x;
            this.id = id;
        }
    }
    
    ArrayList<Integer>TopK(ArrayList<Integer> array, int k)
    {
        // code here
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        PriorityQueue<Node> pq = new PriorityQueue<Node>((p1,p2) ->{
            if(p1.x == p2.x)
            {
                return p2.id-p1.id;
            }
            else
            {
                return p2.x-p1.x;
            }
            });
            
        for(int i=0;i<array.size();i++)
        {
            int x = array.get(i);
            if(h.containsKey(x))
            {
                int y = h.get(x);
                h.put(x,y+1);
               // pq.add(new Node( y+1,x));
            }
            else
            {
                h.put(x,1);
                
            }
        }
        h.forEach((kk,v) -> {
            pq.add( new Node(v,kk) );
            });
        
         for(int i=0;i<k;i++)
        {
            ans.add(pq.poll().id);
        }
        return ans;
    }
}
