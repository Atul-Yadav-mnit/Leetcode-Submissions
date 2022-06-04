class Solution {
    List<List<String>> q;
    List<List<String>> ans = new ArrayList<List<String>>();
    public boolean isvalid(int x, int y)
    {
        int n = q.size();
       // System.out.println(x+" "+y+" "+n);
        for(int i=0;i<n;i++)
        {
            if(i!=y && q.get(x).get(i).equals("Q"))
            {
                return false;
            }
            if(i!=x && q.get(i).get(y).equals("Q"))
            {
                return false;
            }
        }
        int a = x-1;
        int b = y-1;
        while(a>=0 && b>=0)
        {
            if(q.get(a).get(b).equals("Q"))
            {
                return false;
            }
            a--;
            b--;
        }
        
        a = x-1;
        b = y+1;
        while(a>=0 && b<n)
        {
            if(q.get(a).get(b).equals("Q"))
            {
                return false;
            }
            a--;
            b++;
        }
        
        a = x+1;
        b = y+1;
        while(a<n && b<n)
        {
            if(q.get(a).get(b).equals("Q"))
            {
                return false;
            }
            a++;
            b++;
        }
        
        a = x+1;
        b = y-1;
        while(a<n && b>=0)
        {
            if(q.get(a).get(b).equals("Q"))
            {
                return false;
            }
            a++;
            b--;
        }
        
        return true;
    }
    
    public void fun(int x)
    {
        int n = q.size();
        if(x == n)
        {
            List<String> t = new ArrayList<String>();
            for(int i=0;i<n;i++)
            {
                StringBuilder tt = new StringBuilder();
                for(int j=0;j<n;j++)
                {
                    tt.append(q.get(i).get(j));
                }
                t.add(tt.toString());
            }
            ans.add(t);
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(isvalid(x,i))
            {
                q.get(x).set(i,"Q");
                fun(x+1);
                q.get(x).set(i,".");
            }
        }
        return ;
    }
    
    public List<List<String>> solveNQueens(int n) {
        q = new ArrayList<List<String>>();
        for(int i=0;i<n;i++)
        {
            q.add(new ArrayList<String>());
            for(int j=0;j<n;j++)
            {
                q.get(i).add(".");
            }
        }
        fun(0);
        return ans;
    }
}