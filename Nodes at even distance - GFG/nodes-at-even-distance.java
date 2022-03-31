// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            for(int i = 0; i <= n; i++) {
            	graph.add(new ArrayList<>());
            }
            
            int temp = n;
            while(temp-- > 1){
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            Solution ob = new Solution();
            System.out.println(ob.countOfNodes(graph, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
   int countOfNodes(ArrayList<ArrayList<Integer>> graph, int n) 
   {
       // Write your code here
       int vis[] = new int[n+1];
       ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
       arr.addLast(1);
       vis[1] = 1;
       int e = 1, o = 0;
       while(arr.size()>0)
       {
           int x = arr.removeFirst();
           for(int i=0;i<graph.get(x).size();i++)
           {
               int y = graph.get(x).get(i);
               if(vis[y] == 0)
               {
                   if(vis[x] ==1)
                   {
                       vis[y] = 2;
                       o++;
                   }
                   else
                   {
                       vis[y] = 1;
                       e++;
                   }
                   arr.addLast(y);
               }
               
           }
       }
      // System.out.println(e+" "+o);
       return (e*(e-1))/2 + (o*(o-1))/2;
   }
}

