class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int i=0;
        int j=0;
        int c = 0;
        int ans = 0;
        HashSet<String> h = new HashSet<String>();
        while(j<nums.length)
        {
            if(nums[j]%p==0)
            {
                c++;
            }
            if(c == k+1)
            {
                while(i<j)
                {
                   // ans += (j-i+1);
                    StringBuilder s = new StringBuilder();
                    for(int pp=i;pp<j;pp++)
                    {
                        s.append(nums[pp]);
                        s.append("_");
                        h.add(s.toString());
                      //  System.out.println(pp+" "+s.toString());
                    }
                   // System.out.println(h);
                    i++;
                    if(nums[i-1]%p == 0)
                    {
                        c--;
                        break;
                    }
                }
            }
            j++;
        }
        while(i<j)
        {
           // ans += (j-i+1);
            StringBuilder s = new StringBuilder();
            for(int pp=i;pp<j;pp++)
            {
                s.append(nums[pp]);
                s.append("_");
                h.add(s.toString());
               // System.out.println(pp+" "+s.toString());
            }
           // System.out.println(h);
            i++;
        }
        return h.size();
    }
}