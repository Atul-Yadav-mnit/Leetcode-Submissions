class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int count  = Math.abs(target[0])+Math.abs(target[1]);
        for(int i=0;i<ghosts.length;i++)
        {
            int tc = Math.abs(target[0]-ghosts[i][0])+Math.abs(target[1]-ghosts[i][1]);
         //   System.out.println(tc);
            if(tc<=count)
            {
                return false;
            }
        }
        return true;
    }
}