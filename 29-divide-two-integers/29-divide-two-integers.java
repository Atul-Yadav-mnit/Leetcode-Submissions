class Solution {
    public int divide(long dividend, long divisor) {
        boolean neg = false;
        if(dividend < 0)
        {
            neg = !neg;
        }
        if(divisor < 0)
        {
            neg = !neg;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if(dividend<divisor)
        {
            return 0;
        }
        long ans = 0;
        long cur = divisor;
        long curd = 1;
        while(dividend>=cur)
        {
            dividend-=cur;
            ans+=curd;
            curd*=2;
            cur=cur*2;
        }
        while(dividend>=divisor)
        {
            dividend-=divisor;
            ans+=1;
        }
      //  System.out.println(ans);
        if(!neg && ans>Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }
        
        if(neg)
        {
            return -1*(int)ans;
        }
        else
        {
            return (int)ans;
        }
        
    }
}