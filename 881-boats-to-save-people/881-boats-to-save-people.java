class Solution {
    public int numRescueBoats(int[] p, int limit) {
        Arrays.sort(p);
        int i = 0;
        int j = p.length-1;
        int count = 0;
        while(i<=j)
        {
            if(i == j)
            {
                count++;
                i++;
                j--;
            }
            else
            {
                if(p[i]+p[j] <= limit)
                {
                    count++;
                    i++;
                    j--;
                }
                else
                {
                    count++;
                    j--;
                }
            }
        }
        return count;
    }
}