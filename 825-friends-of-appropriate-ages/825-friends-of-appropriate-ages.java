class Solution {
    //  x+14 >= 2*y
    public int numFriendRequests(int[] age) {
        int c = 0;
        Arrays.sort(age);
        for(int i=0;i<age.length;i++)
        {
            int hig = age[i];
            int low = (age[i]+14)/2+1;
            if(age[i] < 100)
            {
                hig = Math.min(100,hig);
            }
           // System.out.println(low+" "+hig);
            int li = age.length, hi = -1;
            int l = 0;
            int h = age.length-1;
            while(l<=h)
            {
                int m = l+(h-l)/2;
                
                if(age[m] >= low)
                {
                  
                    li = m;
                    h = m-1;
                }
                else
                {
                    l = m+1;
                }
            }
            l = 0;
            h = age.length-1;
            while(l<=h)
            {
                int m = l+(h-l)/2;
                if(age[m] <= hig)
                {
                    hi = m;
                    l = m+1;
                }
                else
                {
                    h = m-1;
                }
            }
            
            int x = 0;
            if(i>=li && i<=hi)
            {
                x--;
            }
            x+=Math.max(0,hi-li+1);
         //  System.out.println(li+" "+hi+" "+x);
            c+=x;
        }
        return c;
    }
}