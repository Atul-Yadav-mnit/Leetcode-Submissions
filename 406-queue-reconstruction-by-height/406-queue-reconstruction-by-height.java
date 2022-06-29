class Solution {
    
    class Pair{
        int n,k;
        Pair(int n, int k)
        {
            this.n = n;
            this.k = k;
        }
    }
    
    public int[][] reconstructQueue(int[][] p) {
        Arrays.sort(p,(p1,p2) -> {
            if(p1[1] == p2[1])
            {
                return p1[0]-p2[0];
            }
            return p1[1]-p2[1];
        });
        int i=0;
        ArrayList<Pair> arr = new ArrayList<Pair>();
        arr.add(new Pair(p[i][0],p[i][1]));
        i++;
        while(i<p.length)
        {
            if(p[i][1] == p[i-1][1])
            {
                arr.add(new Pair(p[i][0],p[i][1]));
            }
            else
            {
                break;
            }
            i++;
        }
        if(i != p.length)
        {
            int cur = p[i][1];
            int j = 0;
            int count = 0;
            while(i<p.length)
            {
                if(p[i][1] == cur)
                {
                    if(arr.get(j).n >= p[i][0])
                    {
                        count++;
                    }
                    j++;
                    if(p[i][1] == count)
                    {
                        arr.add(j,new Pair(p[i][0],p[i][1]));
                        i++;
                        count = 0;
                        for(int k=0;i<p.length && k<j;k++)
                        {
                            if(arr.get(k).n >= p[i][0])
                            {
                                count++;
                            }
                        }
                    }
                }
                else
                {
                    cur = p[i][1];
                    j = 0;
                    count = 0;
                }
            }
        }
        for(i=0;i<arr.size();i++)
        {
            p[i][0] = arr.get(i).n;
            p[i][1] = arr.get(i).k;
        }
        return p;
    }
    
}