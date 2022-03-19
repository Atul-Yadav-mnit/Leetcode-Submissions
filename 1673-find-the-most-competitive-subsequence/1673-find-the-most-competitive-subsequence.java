class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int x = nums[i];
            if(s.isEmpty())
            {
                s.push(nums[i]);
            }
            else
            {
                while(!s.isEmpty())
                {
                    if(s.size()+(nums.length-i-1) < k)
                    {
                        break;
                    }
                    else if(s.peek()>x)
                    {
                        s.pop();
                    }
                    else
                    {
                        break;
                    }
                }
                if(s.size()<k)
                {
                    s.push(x);
                }
            }
        }
        int arr[] = new int[s.size()];
        for(int i=s.size()-1;i>=0;i--)
        {
            arr[i] = s.pop();
        }
        return arr;
    }
}