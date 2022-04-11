class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int count = grid.length*grid[0].length;
        k = k%count;
        int cur = count-k;
        cur = (cur+count)%count;
        for(int i=0;i<grid.length;i++)
        {
            ans.add(new ArrayList<Integer>(grid[i].length));
            for(int j=0;j<grid[i].length;j++)
            {
                int r = cur/grid[i].length;
                int c = cur%grid[i].length;
               // System.out.println(r+" "+c);
                ans.get(i).add(grid[r][c]);
                cur = (cur+1)%count;
            }
        }
        return ans;
    }
}