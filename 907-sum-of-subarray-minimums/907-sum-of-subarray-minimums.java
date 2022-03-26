class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long m = 1000000007;
        long ans = 0;
        Stack<Integer> s = new Stack<Integer>();
        int left[] = new int[n];
        int right[] = new int[n];
        s.push(0);
        left[0] = -1;
        for(int i=1;i<arr.length;i++)
        {
            while(s.isEmpty() == false && arr[s.peek()] >= arr[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            left[i] = -1;
            else
            left[i] = s.peek();
            s.push(i);
        }
        s = new Stack<Integer>();
        s.push(arr.length-1);
        right[arr.length-1] = arr.length;
        for(int i=arr.length-2;i>=0;i--)
        {
            while(s.isEmpty() == false && arr[s.peek()] > arr[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            right[i] = arr.length;
            else
            right[i] = s.peek();
            s.push(i);
        }
        for(int i=0;i<arr.length;i++)
        {
            long a = (i-left[i])%m;
            long b = (right[i]-i)%m;
            long x = (a%m * b%m)%m;
            long y = arr[i];
            x = ((x%m) * (y%m))%m;
            ans = (ans%m + x%m)%m;
        }
        return (int)ans;
    }
}