class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int even = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2 == 0)
            {
                even++;
            }
            else
            {
                arr.add(even+1);
                arr.add(-1);
                even = 0;
            }
        }
        int count = 0;
       
        arr.add(even+1);
       //  System.out.println(arr);
        for(int i=1;i+2*k-1<arr.size();i=i+2)
        {
           // System.out.println((i-1)+" "+(i+2*k-1));
            count+=arr.get(i-1)*arr.get(i+2*k-1);
        }
        return count;
        
    }
}