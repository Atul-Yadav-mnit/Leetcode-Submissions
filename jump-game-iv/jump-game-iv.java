class Solution {
    HashMap<Integer,ArrayList<Integer>> h;
    public int minJumps(int[] arr) {
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
        HashSet<Integer> h2 = new HashSet<Integer>();
        HashSet<Integer> h3 = new HashSet<Integer>();
        ArrayList<Integer> q = new ArrayList<Integer>();
        ArrayList<Integer> l = new ArrayList<Integer>();
        q.add(0);
        l.add(1);
        h2.add(0);
        int n = arr.length;
        while(q.size()>0)
        {
            int x = q.remove(0);
            int y = l.remove(0);
            //System.out.println(h);
            if(x == n-1)
            {
                y--;
                return y;
            }
            if(x+1 < n && !h2.contains(x+1))
            {
                h2.add(x+1);
                q.add(x+1);
                l.add(y+1);
            }
            if(x-1 >= 0 && !h2.contains(x-1))
            {
                h2.add(x-1);
                q.add(x-1);
                l.add(y+1);
            }
          //  System.out.println(temp);
            if(!h3.contains(arr[x]))
            {
                h3.add(arr[x]);
                ArrayList<Integer> temp = h.get(arr[x]);
                for(int i=0;i<temp.size();i++)
                {
                    int z = temp.get(i);
                    if(z >= 0 && z<n && !h2.contains(z))
                    {
                        h2.add(z);
                        q.add(z);
                        l.add(y+1);
                    }
                }
            }
            
            
        }
        return -1;
    }
}