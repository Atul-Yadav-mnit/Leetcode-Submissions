class Solution {

    int arr[];
    public Solution(int[] w) {
        arr = w;
        for(int i=1;i<w.length;i++)
        {
            arr[i]+=arr[i-1];
        }
    }
    
    public int pickIndex() {
        int sum = arr[arr.length-1];
        int ran = (int)(Math.random()*sum)+1;
        int l = 0;
        int h = arr.length-1;
        while(l<h)
        {
            int m = l+(h-l)/2;
            if(arr[m] >= ran)
            {
                h = m;
            }
            else
            {
                l = m+1;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */