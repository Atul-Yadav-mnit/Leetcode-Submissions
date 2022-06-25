class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean done = false;
        int i = 1;
        while(i<nums.length)
        {
            if(nums[i] < nums[i-1])
            {
                if(done)
                {
                    return false;
                }
                done = true;
                boolean ans1 = true;
                boolean ans2 = true;
                
                // nums[i-1] = nums[i-2]; 
                int j = i;
                if(i-2 >= 0 )
                {
                    j = i;
                    int temp = nums[j-1];
                    nums[j-1] = nums[j-2];
                    for(;j<nums.length;j++)
                    {
                        if(nums[j] < nums[j-1])
                        {
                            ans1 = false;
                            break;
                        }
                    }
                    nums[i-1] = temp; 
                }
                else
                {
                    j = i;
                    int temp = nums[j-1];
                    nums[j-1] = -1000000;
                    for(;j<nums.length;j++)
                    {
                        if(nums[j] < nums[j-1])
                        {
                            ans1 = false;
                            break;
                        }
                    }
                    nums[i-1] = temp; 
                   
                }
                
//                 [4,2,3]
// [3,4,2,3]
               
                // nums[i] = nums[i-1];
             //   System.out.println(nums[0]);
                
                j = i;
                int temp = nums[j];
                    nums[j] = nums[j-1];
               
                    for(;j<nums.length;j++)
                    {
                 //        System.out.println(j+" "+nums[j]+" "+nums[j-1]);
                        if(nums[j] < nums[j-1])
                        {
                            ans2 = false;
                            break;
                        }
                    }
                   
               //  System.out.println(ans2);
                return ans1 || ans2;
            }
            i++;
        }
        return true;
    }
}