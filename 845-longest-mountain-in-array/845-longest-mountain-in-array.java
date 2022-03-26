class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int inc[] = new int[n];
        int dcr[] = new int[n];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i] > arr[i-1])
            {
                inc[i]=inc[i-1]+1;
            }
        }
        for(int i=arr.length-2;i>=0;i--)
        {
            if(arr[i] > arr[i+1])
            {
                dcr[i]=dcr[i+1]+1;
            }
        }
        int ans = 0;
        for(int i=1;i<arr.length-1;i++)
        {
           // System.out.println(inc[i]+" "+dcr[i]);
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1])
            {
                ans = Math.max(ans,inc[i]+dcr[i]+1);
            }
        }
        return ans;
    }
}