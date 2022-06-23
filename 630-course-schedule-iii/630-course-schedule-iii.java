class Solution {
    public int scheduleCourse(int[][] c) {
        Arrays.sort(c,(o1,o2) -> o1[1]-o2[1]);
        PriorityQueue<Integer> p = new PriorityQueue<Integer>((o1,o2) -> o2-o1);
        int time = 0;
        for(int i=0;i<c.length;i++)
        {
            if(time+c[i][0] <= c[i][1])
            {
                p.add(c[i][0]);
                time = time+c[i][0];
            }
            else
            {
                if(p.size()>0 && p.peek() > c[i][0])
                {
                    time = time - p.poll();
                    p.add(c[i][0]);
                    time = time + c[i][0];
                }
            }
        }
        return p.size();
    }
}