class Solution {
    public int lastStoneWeight(int[] s) {
        PriorityQueue<Integer> p = new PriorityQueue<Integer>((p1,p2) -> p2-p1);
        for(int i=0;i<s.length;i++)
        {
            p.add(s[i]);
        }
        while(p.size()>1)
        {
            int a = p.poll();
            int b = p.poll();
            if(a == b)
            {
                
            }
            else
            {
                p.add(Math.abs(a-b));
            }
        }
        if(p.size() == 0)
        {
            return 0;
        }
        return p.peek();
    }
}