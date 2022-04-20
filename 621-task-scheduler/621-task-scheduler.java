class Solution {
    public int leastInterval(char[] tasks, int n) {
        int arr[] = new int[26];
        for(int i=0;i<tasks.length;i++)
        {
            int x = tasks[i]-'A';
            arr[x]++;
        }
        Arrays.sort(arr);
        int ans = tasks.length;
        for(int i=0;i<n;i++)
        {
            int x  = arr.length-1-i;
            if(x>=26 || x<0)
            {
                break;
            }
            ans = Math.max(ans,(arr[x]-1)*(n+1)+1+i);
        }
        return ans;
    }
}