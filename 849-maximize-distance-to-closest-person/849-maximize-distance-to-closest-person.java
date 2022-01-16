class Solution {
    public int maxDistToClosest(int[] seats) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int prev = -1;
        int max = 0;
        for(int i=1;i<=seats.length;i++)
        {
            if(seats[i-1] == 1)
            {
                if(prev == -1)
                {
                    max = Math.max(max,i-1);
                    prev = i;
                }
                else
                {
                    max = Math.max(max,(i-prev)/2);
                    prev = i;
                }
            }
        }
        max = Math.max(seats.length-prev,max);
        return max;
    }
}