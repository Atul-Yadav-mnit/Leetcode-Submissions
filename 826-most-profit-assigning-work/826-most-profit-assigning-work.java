class Solution {
     class Pair{
        int v,w;
        Pair(int v,int w)
        {
            this.v = v;
            this.w = w;
        }
    }
    public int maxProfitAssignment(int[] d, int[] p, int[] w) {
        ArrayList<Pair> arr = new ArrayList<Pair>();
        for(int i=0;i<d.length;i++)
        {
           arr.add(new Pair(p[i],d[i]));
        }
        Collections.sort(arr,(p1,p2) -> {return p1.w-p2.w;});
        int max[] = new int[d.length];
        max[0] = arr.get(0).v;
        for(int i=1;i<arr.size();i++)
        {
            max[i] = Math.max(arr.get(i).v,max[i-1]);
        }
        int count = 0;
        for(int i=0;i<w.length;i++)
        {
            int l = 0;
            int h = d.length-1;
            int ans = -1;
            while(l<=h)
            {
                int m = l+(h-l)/2;
                if(arr.get(m).w > w[i])
                {
                    h = m-1;
                }
                else
                {
                    ans = m;
                    l = m+1;
                }
            }
            if(ans!=-1)
            {
                count+=max[ans];
            }
        }
        return count;
    }
    
}