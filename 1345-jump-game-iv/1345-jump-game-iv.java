class Solution {
    public int vis[];
    public HashMap<Integer,ArrayList<Integer>> h;
    public int minJumps(int[] arr) {
        vis = new int[arr.length];
        h = new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<arr.length;i++)
        {
            if(h.containsKey(arr[i]))
            {
                h.get(arr[i]).add(i);
            }
            else
            {
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                h.put(arr[i],a);
            }
        }
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        ArrayDeque<Integer> time = new ArrayDeque<Integer>();
        q.add(0);
        time.add(0);
        vis[0] = 1;
        HashSet<Integer> h2 = new HashSet<Integer>();
        while(q.size()>0)
        {
            int x = q.removeFirst();
            int y = time.removeFirst();
            if(x-1>=0 && vis[x-1]==0)
            {
                q.add(x-1);
                time.add(y+1);
            }
            if(x == arr.length-1)
            {
                return y;
            }
            if(vis[x+1]==0)
            {
                q.add(x+1);
                time.add(y+1);
            }
            if(!h2.contains(arr[x]))
            {
                h2.add(arr[x]);
                for(int i=0;i<h.get(arr[x]).size();i++)
                {
                     int z = h.get(arr[x]).get(i);
                     if(vis[z] == 0)
                     {
                         vis[z] = 1;
                         q.add(z);
                         time.add(y+1);
                     }
                }
            }

        }
        return -1;
    }
}