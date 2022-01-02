class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        HashSet<Integer> h1 = new HashSet<Integer>();
        int c30 = 0;
        for(int i=0;i<=60;i++)
        {
            h.put(i,0);
        }
        for(int i=0;i<time.length;i++)
        {
            int x = time[i]%60;
            if(x<30 && x>0)
            {
                h1.add(x);
            }
            else if(x == 30)
            {
                c30++;
            }
           h.put(x,h.get(x)+1);
        }
        int ans = (c30 * (c30-1))/2;
        ans += (h.get(0)*(h.get(0)-1))/2;
        for (Integer i : h1) 
            ans += h.get(i)*h.get(60-i);
        return ans;
    }
}