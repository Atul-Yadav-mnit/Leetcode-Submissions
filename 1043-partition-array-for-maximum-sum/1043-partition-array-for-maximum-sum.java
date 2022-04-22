class Solution {
    int t[];
    public int fun(int arr[],int x, int k)
    {
        if(x == arr.length)
        {
            return 0;
        }
        if(t[x]!=-1)
        {
            return t[x];
        }
        int ans = arr[x]+fun(arr,x+1,k);
        int max = arr[x];
        for(int i=1;i<k && x+i<arr.length;i++)
        {
            max = Math.max(max,arr[x+i]);
            ans = Math.max(max*(i+1) + fun(arr,x+i+1,k) , ans);
        }
        return t[x] = ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        t = new int[arr.length];
        Arrays.fill(t,-1);
        return fun(arr,0,k);
    }
}