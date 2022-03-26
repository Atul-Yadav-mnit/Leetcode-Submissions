class Solution {
    public int t[][],c[];
    public int fun(int days[], int end, int x)
    {
        if(x == days.length)
        {
            return 0;
        }
        if(t[end][x] !=-1)
        {
            return t[end][x];
        }
        if(days[x] <= end)
        {
            return t[end][x] =fun(days,end,x+1);
        }
        else
        {
            int a = c[0]+fun(days,days[x],x+1);
            int b = c[1]+fun(days,days[x]+6,x+1);
            int d = c[2]+fun(days,days[x]+29,x+1);
            return t[end][x] = Math.min(a,Math.min(b,d));
        }
    }
    public int mincostTickets(int[] days, int[] costs) {
        t = new int[400][days.length];
        c = costs;
        for(int i=0;i<400;i++)
        {
            Arrays.fill(t[i],-1);
        }
        return fun(days,0,0);
    }
}