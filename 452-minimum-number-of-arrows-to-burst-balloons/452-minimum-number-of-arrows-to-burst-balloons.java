class Solution {
    class Node
    {
        int s,e;
        Node(int x, int y)
        {
            s = x;
            e = y;
        }
    }
    public int findMinArrowShots(int[][] points) {
        ArrayList<Node> arr = new ArrayList<Node>();
        for(int i=0;i<points.length;i++)
        {
            arr.add(new Node(points[i][0],points[i][1]));
        }
        Collections.sort(arr,(c1,c2) -> c1.e-c2.e);
        int count = 1;
        int prev = arr.get(0).e;
        for(int i=1;i<points.length;i++)
        {
            int s = arr.get(i).s;
            int e = arr.get(i).e;
            if( !(s<=prev && prev<=e) )
            {
                prev = e;
                count++;
            }
        }
        return count;
    }
}