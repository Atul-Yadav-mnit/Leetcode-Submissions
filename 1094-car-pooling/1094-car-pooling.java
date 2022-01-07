class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int arr[] = new int[1003];
        int diff[] = new int[1003];
        for(int i=0;i<trips.length;i++)
        {
            int x = trips[i][1];
            int y = trips[i][2];
            int z = trips[i][0];
            diff[x] += z;
            diff[y] -= z;
        }
        arr[0] = diff[0];
        if(arr[0] > capacity)
        {
            return false;
        }
        for(int i=1;i<1003;i++)
        {
            arr[i] = arr[i-1] + diff[i]; 
            if(arr[i]>capacity)
            {
                return false;
            }
        }
        return true;
    }
}