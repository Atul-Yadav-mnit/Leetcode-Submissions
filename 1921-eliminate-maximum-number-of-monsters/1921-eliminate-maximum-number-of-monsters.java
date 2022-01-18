class Solution {
    
    class Node{
        int d;
        int v;
        Node(int d, int v)
        {
            this.d = d;
            this.v = v;
        }
    }
    
    public int eliminateMaximum(int[] dist, int[] speed) {
       
        PriorityQueue<Node> p = new PriorityQueue<Node>((d1,d2) -> {
            return (int)(( (long)d1.d * (long)d2.v ) - (long)((long)d2.d * (long)d1.v));
        });
        
        for(int i=0;i<dist.length;i++)
        {
            p.add(new Node(dist[i],speed[i]));
        }
        int count = 0;
        while(p.size()>0)
        {
            Node x = p.poll();
            int y = x.d/(x.v);
            if(x.d%(x.v) != 0)
            {
                y++;
            }
            if(y>count)
            {
                count++;
            }
            else
            {
                return count;
            }
        }
        return count;
        
    }
}