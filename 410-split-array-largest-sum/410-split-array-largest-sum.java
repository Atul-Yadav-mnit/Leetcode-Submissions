class Solution {
    public int t[][];
    public int fun(int arr[],int x, int done, int m)
    {
        if(t[x][done] != -1)
        {
            return t[x][done];
        }
        if(done == m-1)
        {
            int sum = 0;
            for(int i=x;i<arr.length;i++)
            {
                sum+=arr[i];
            }
            return t[x][done] = sum;
        }
        int sum = arr[x];
        int cur = x+1;
        int n = arr.length;
        int ans = Math.max(sum,fun(arr,cur,done+1,m));
        while(n-cur > m-done-1)
        {
            sum+=arr[cur];
            cur++;
            ans = Math.min( ans , Math.max(sum,fun(arr,cur,done+1,m))  );
        }
       // System.out.println(x+" "+(done)+" "+ans);
        return t[x][done] = ans;
    }
    
    public int splitArray(int[] nums, int m) {
        t = new int[nums.length][m+1];
        for(int i=0;i<nums.length;i++)
        {
            Arrays.fill(t[i],-1);
        }
        return fun(nums,0,0,m);
    }
}