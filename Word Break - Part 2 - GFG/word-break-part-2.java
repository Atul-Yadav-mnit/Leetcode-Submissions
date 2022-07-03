// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.stream.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String arr[] = in.readLine().trim().split("\\s+");
            List<String> dict = new ArrayList<String>();
            for(int i = 0;i < n;i++)
                dict.add(arr[i]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.wordBreak(n, dict, s);
            if(ans.size() == 0)
                System.out.println("Empty");
            else{
                List<String> sol = ans.stream().sorted().collect(Collectors.toList());
                for(int i = 0;i < sol.size();i++)
                    System.out.print("("+sol.get(i)+")");
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static HashSet<String> h;
    static HashMap<Integer,List<String>> tt;
    static String s;
    static List<String> fun(int x)
    {
        if(x == s.length())
        {
            List<String> temp = new ArrayList<String>();
            temp.add("");
            return temp;
        }
        if(tt.containsKey(x))
        {
            return tt.get(x);
        }
        List<String> temp = new ArrayList<String>();
        StringBuilder t = new StringBuilder();
        for(int i=x;i<s.length();i++)
        {
            t.append(s.charAt(i));
            String t2 = t.toString();
            if(h.contains(t2))
            {
                List<String> temp2 = fun(i+1);
                for(int j=0;j<temp2.size();j++)
                {
                    if(temp2.get(j) == "")
                    {
                        temp.add(t2);
                    }
                    else
                    {
                        temp.add(t2+" "+temp2.get(j));
                    }
                }
            }
        }
        tt.put(x,temp);
        return temp;
    }
    static List<String> wordBreak(int n, List<String> dict, String s)
    {
        // code here
        tt = new HashMap<Integer,List<String>>();
        Solution.s = s;
        h = new HashSet<String>();
        for(int i=0;i<dict.size();i++)
        {
            h.add(dict.get(i));
        }
        return fun(0);
    }
}