class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(nums[0]);
        left[0] = 1;
        int max =1;
        for(int i=1;i<nums.length;i++)
        {
            int l = 0;
            int h = temp.size()-1;
            while(l<=h)
            {
                int m = l+(h-l)/2;
                if(temp.get(m) == nums[i])
                {
                    break;
                }
                else if(temp.get(m) > nums[i])
                {
                    h = m;
                    if(l == h)
                    {
                        break;
                    }
                }
                else
                {
                    l = m+1;
                }
            }
            
            if(l == temp.size())
            {
                temp.add(nums[i]);
            }
            else if(temp.get(l) == nums[i])
            {
                
            }
            else
            {
                temp.remove(h);
                temp.add(h,nums[i]);
            }
            left[i] = temp.size();
            //System.out.println(left[i]);
        }
        
        temp = new ArrayList<Integer>();
        temp.add(nums[nums.length-1]);
        right[nums.length-1] = 1;
        for(int i=nums.length-1;i>=0;i--)
        {
            int l = 0;
            int h = temp.size()-1;
            while(l<=h)
            {
                int m = l+(h-l)/2;
                if(temp.get(m) == nums[i])
                {
                    break;
                }
                else if(temp.get(m) > nums[i])
                {
                    h = m;
                    if(l == h)
                    {
                        break;
                    }
                }
                else
                {
                    l = m+1;
                }
            }
            
            if(l == temp.size())
            {
                temp.add(nums[i]);
            }
            else if(temp.get(l) == nums[i])
            {
                
            }
            else
            {
                temp.remove(h);
                temp.add(h,nums[i]);
            }
            right[i] = temp.size();
            if(temp.get(temp.size()-1) == nums[i] && left[i]!=1 && right[i]!=1)
            max= Math.max(left[i]+right[i]-1,max);
          //  System.out.println(temp+" "+left[i]+" "+right[i]);
        }
        
        
        return nums.length-max;
    }
}