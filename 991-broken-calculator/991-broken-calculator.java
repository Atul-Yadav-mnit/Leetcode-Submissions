class Solution {
    public int brokenCalc(int startValue, int target) {
        if(startValue == target)
        {
            return 0;
        }
        else if(startValue > target)
        {
            return startValue-target;
        }
        else
        {
            int cur = startValue;
            int count = 0;
            while(cur<target)
            {
                cur = cur*2;
                count++;
            }
            int diff = cur-target;
            int pow = (int)Math.pow(2,count);
            while(diff>0)
            {
                if(diff>=pow)
                {
                    diff-=pow;
                    count++;
                }
                else
                {
                    pow = pow/2;
                }
            }
            return count;
        }
    }
}