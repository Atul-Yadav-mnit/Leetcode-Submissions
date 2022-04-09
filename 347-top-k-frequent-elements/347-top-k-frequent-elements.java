class Solution {
    class Pair{
        int x;
        int f;
        Pair(int x, int f)
        {
            this.x = x;
            this.f = f;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(h.containsKey(nums[i]))
            {
                h.put(nums[i],h.get(nums[i])+1);
            }
            else
            {
                h.put(nums[i],1);
            }
        }
        PriorityQueue<Pair> p = new PriorityQueue<Pair>((p1,p2) -> p2.f-p1.f);
        h.forEach((kv,v) -> {
           p.add(new Pair(kv,v)); 
        });
        int ans[] = new int[k];
        int i  =0 ;
        while(i<k)
        {
            ans[i] = p.poll().x;
            i++;
        }
        return ans;
    }
}