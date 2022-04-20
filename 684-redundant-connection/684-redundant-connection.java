class Solution {
    int par[];
    public int find(int x)
    {
        if(par[x]<0)
        {
            return x;
        }
        return find(par[x]);
    }
    public boolean union(int x, int y)
    {
        int a = find(x);
        int b = find(y);
      //  System.out.println(a+" "+b+" "+x+" "+y);
        if(a == b)
        {
            return false;
        }
        int ra = -1*par[a];
        int rb = -1*par[b];
        
        if(ra>rb)
        {
            par[b] = a;
            par[a] -= rb;
        }
        else
        {
            par[a] = b;
            par[b] -= ra;
        }
        
        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        par = new int[n];
        Arrays.fill(par,-1);
        for(int i=0;i<edges.length;i++)
        {
            if( !union(edges[i][0]-1,edges[i][1]-1) )
            {
                return edges[i];
            }
            
        }
        return edges[0];
    }
}