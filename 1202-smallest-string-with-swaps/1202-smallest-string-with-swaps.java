class Solution {
    
    HashMap<Integer,ArrayList<Integer>> h;
    int par[];
    
    int find(int x)
    {
       // System.out.println(x+" "+par[x]);
        if(par[x]<=-1)
        {
            return x;
        }
        return find(par[x]);
    }
    
    void union(int x, int y)
    {
        int a = find(x);
        int b = find(y);
        if(a!=b)
        {
            if(par[a]<=par[b])
            {
                int c = Math.abs(par[b]);
                par[b] = a;
                par[a]-=c;
                
            }
            else
            {
                int c = Math.abs(par[a]);
                par[a] = b;
                par[b]-=c;
            }
        }
    }
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        par = new int[s.length()];
        Arrays.fill(par,-1);
        h = new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<pairs.size();i++)
        {
            int x = pairs.get(i).get(0);
            int y = pairs.get(i).get(1);
           
            union(x,y);

           
        }
        
        
           
        
        
        for(int i=0;i<s.length();i++)
        {
            int x = find(i);
           // System.out.println(x);
            if(h.containsKey(x))
            {
                h.get(x).add(i);
            }
            else
            {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                h.put(x,temp);
            }
        }
        
       // System.out.println(h);
        char c[] = new char[s.length()];
        
        h.forEach((k,v) -> {
            ArrayList<Character> arr = new ArrayList<Character>();
            for(int i=0;i<v.size();i++)
            {
                int x = v.get(i);
                arr.add(s.charAt(x));
            }
           // System.out.println(arr);
            Collections.sort(arr);
            for(int i=0;i<v.size();i++)
            {
                int x = v.get(i);
                c[x] = arr.get(i);
            }
        });
        
        return String.valueOf(c);
        
    }
}