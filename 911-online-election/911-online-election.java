class TopVotedCandidate {

    HashMap<Integer,Integer> h ;
    ArrayList<Integer> arr;
    
    public TopVotedCandidate(int[] person, int[] time) {
        int a[] = new int[person.length];
        h = new HashMap<Integer,Integer>();
        arr = new ArrayList<Integer>();
        int max = 0;
        for(int i=0;i<time.length;i++)
        {
            int p = person[i];
            a[p]++;
            if(a[p]>=max)
            {
                max = a[p];
                h.put(time[i],p);
                arr.add(time[i]);
            }
        }
       // System.out.println(h);
    }
    
    public int q(int t) {
        int l =0 ;
        int r = arr.size()-1;
        int ans = 0;
        while(l<=r)
        {
            int m = l+(r-l)/2;
            if(arr.get(m)<=t)
            {
                ans = arr.get(m);
                l = m+1;
            }
            else
            {
                r = m-1;
            }
        }
        // System.out.println(ans);
        return h.get(ans);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */