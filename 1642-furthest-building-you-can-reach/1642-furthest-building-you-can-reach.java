class Solution {
    public boolean fun(int h[], int m, int b, int l)
    {
        int t[] = new int[m+1];
        if(l>=m+1)
        {
            return true;
        }
        for(int i=0;i<=m;i++)
        {
            t[i] = h[i];
            
        }
        Arrays.sort(t);
       
      //  System.out.println(" ");
        int sum = 0;
        for(int i=0;i<=m-l;i++)
        {
       //     System.out.println(t[i]);
            sum+=t[i];
        }
       // System.out.println(b+" "+l+" "+m+" "+sum);
        return sum<=b;
    }
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        for(int i=0;i<heights.length-1;i++)
        {
            heights[i]=heights[i+1]-heights[i];
            heights[i] = Math.max(0,heights[i]);
        }
        int l = 0;
        int h = heights.length-2;
        int ans = 0;
        while(l<=h)
        {
            int m = l+(h-l)/2;
            if(fun(heights,m,bricks,ladders))
            {
                ans = m+1;
                l = m+1;
            }
            else
            {
                h = m-1;
            }
        }
        return ans;
    }
}