class Solution {
    class Node{
        int x;
        int y;
        Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        int arr[] = new int[nums.size()];
        int a = -100000;
        int b = 100000;
        PriorityQueue<Node> pmin = new PriorityQueue<Node>((p1,p2) -> {
            return nums.get(p1.x).get(p1.y) - nums.get(p2.x).get(p2.y);
        });
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++)
        {
            pmin.add(new Node(i,0));
            max = Math.max(max,nums.get(i).get(0));
        }
        while(true)
        {
            Node mi = pmin.poll();
            
            int c = nums.get(mi.x).get(mi.y);
            int d = max;
           // System.out.println(c+" "+d);
            if(d-c<b-a)
            {
                a = c;
                b = d;
            }
            if(mi.y == nums.get(mi.x).size()-1)
            {
                break;
            }
         //   System.out.println(mi.y+" "+(nums.get(mi.x).size()-1)+" "+mi.x );
            mi.y++;
            pmin.add(mi);
            max = Math.max(max,nums.get(mi.x).get(mi.y));
          //  System.out.println(pmin);
          //  System.out.println(pmax);
        }
       
        int ans[] = new int[2];
        ans[0] = a;
        ans[1] = b;
        return ans;
    }
}