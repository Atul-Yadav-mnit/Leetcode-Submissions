class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cur1 = -1;
        int cur2 = -1;
        int count1 = 0;
        int count2 = 0;
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if( (cur1 == nums[i] && count1 >0) || (cur2 == nums[i] && count2 >0) )
            {
                if(cur1 == nums[i])
                {
                    count1++;
                }
                else
                {
                    count2++;
                }
            }  
            else if(count1  <= 0)
            {
                cur1 = nums[i];
                count1 = 1;
            }
            else if(count2  <= 0)
            {
                cur2 = nums[i];
                count2 = 1;
            }
            else
            {
                count1--;
                count2--;
            }
           // System.out.println(cur1+" = "+count1+" and "+cur2+" = "+count2);
        }
      //  System.out.println(cur1+" "+cur2);
        int c1 = 0,c2=0;
        for(int i=0;i<nums.length;i++)
        {
            if(count1>0 && cur1 == nums[i])
            {
                c1++;
            } 
            if(count2>0 && cur2 == nums[i])
            {
                c2++;
            } 
        }
        int n = nums.length/3;
            if(c1>n)
            {
                ans.add(cur1);
            }
            if(c2>n)
            {
                ans.add(cur2);
            }
       
        return ans;
    }
}