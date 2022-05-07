class Solution {
    public boolean find132pattern(int[] nums) {
        int mini[] = new int[nums.length];
        mini[0] = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            mini[i] = Math.min(mini[i-1],nums[i]);
        }
        int maxj[] = new int[nums.length];
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            while(!s.isEmpty() && nums[s.peek()]<=nums[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                maxj[i] = -1;
            }
            else
            {
                maxj[i] = s.peek();
            }
            s.push(i);
        }
        
        for(int k=2;k<nums.length;k++)
        {
            int x = maxj[k];
            if(x>=1)
            {
                int a = mini[x-1];
                int b = nums[x];
                int c = nums[k];
           //     System.out.println(a+" "+b+" "+c);
                if(a<c && c<b)
                return true;
            }
        }
        return false;
    }
}