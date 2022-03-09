class Solution {
    public long gcd(long a,long b)
    {
        if(b == 0)
        {
            return a;
        }
        return gcd(b,a%b);
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int cur = 0;
        if(nums.length==1)
        {
             List<Integer> arr = new ArrayList<Integer>();
            arr.add(nums[0]);
            return arr;
        }
       
        Deque<Integer> ans = new ArrayDeque<Integer>();
        for(int i=0;i<2;i++)
        {
            ans.add(nums[i]);
        }
        int k = 2;
        int i = 1;
        while(i<ans.size())
        {
            if(i-1<0)
            {
                if(k >= nums.length)
                {
                    break;
                }
                ans.add(nums[k]);
                i++;
                k++;
                continue;
            }
            int x = ans.removeLast();
            int y = ans.removeLast();
            long z = gcd(x,y);
            if(z == 1)
            {
                if(k >= nums.length)
                {
                    ans.add(y);
                    ans.add(x);
                    break;
                }
                ans.add(y);
                ans.add(x);
                ans.add(nums[k]);
                i++;
                k++;
            }
            else 
            {
                long temp = (long)x*(long)y;
                temp = temp / z;
                ans.addLast((int)temp);
                i = i-1;
            }
           // System.out.println(ans+" "+i);
        }
        
        List<Integer> arr = new ArrayList<Integer>();
        while(ans.size()>0)
        {
            arr.add(ans.removeFirst());
        }
        return arr;
    }
}