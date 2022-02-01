class Solution {
    public int hIndex(int[] c) {
        int l = 0;
        int h = c.length;
        int ans = 0;
        while(l<=h)
        {
            int m = l+(h-l)/2;
            int hh = c.length-m;
          /// System.out.println(m);
            if( ( m-1<0 || c[m-1]<=hh )  && ( m==c.length || c[m]>=hh )   )
            {
              //  System.out.println(m+" "+hh+" "+ans);
                ans = hh;
                l = m+1;
            }
            if(m-1<0 && m==c.length )
            {
                break;
            }
            if(m-1>=0 && c[m-1]>=hh)
            {
                h = m-1;
            }
            else if(m != c.length)
            {
                l= m+1;
            }
        }
        return ans;
    }
}