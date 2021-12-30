class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0)
        {
            return -1;
        }
        long a = 1;
        int n=1;
        HashSet<Long> h = new HashSet<Long>();
        while(a>0)
        {
            a = a%k;
            if(a == 0)
            {
                return n;
            }
            a = a*10+1;
            if(h.contains(a) == true)
            {
                return -1;
            }
            h.add(a);
            n++;
        }
        return -1;
    }
}