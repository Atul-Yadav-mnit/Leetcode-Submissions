class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer,Long> h = new HashMap<Integer,Long>();
        for(int i=0;i<arr.length;i++)
        {
            h.put(arr[i],1L);
        }
        long ans[] = new long[arr.length];
        long a = 0;
        long m = 1000000007;
        Arrays.fill(ans,1);
        for(int i=0;i<arr.length;i++)
        {   
            for(int j=i-1;j>=0;j--)
            {
                int p = arr[i];
                int q = arr[j];
                int r = p/q;
                // if(r>p)
                // {
                //     break;
                // }
                if(p%q == 0 && h.containsKey(r))
                {
                    
                    long x = ( h.get(q)%m * h.get(r)%m )%m ;
                    // if(r * r == x)
                    // {
                    //     x = (x*2)%m;
                    // }
                  // System.out.println(p+" "+q+" "+r+" "+x);
                    ans[i] = (ans[i]%m + x%m)%m; 
                }
                
            }

           // System.out.println(ans[i]);
            ans[i] = ans[i]%m;
            h.put(arr[i],ans[i]);
           // System.out.println(h);
            a = (a%m+ans[i]%m)%m;
        }
        return (int)a;
    }
}