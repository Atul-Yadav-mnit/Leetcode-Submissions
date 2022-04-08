class KthLargest {

    int k;
    PriorityQueue<Integer> p ;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        p = new PriorityQueue<Integer>();
        Arrays.sort(nums);
        int i=0;
        while(i<k)
        {
            if(nums.length-1-i<0)
            {
                break;
            }
            p.add(nums[nums.length-1-i]);
            i++;
        }
    }
    
    public int add(int val) {
         int x = -1000000;
        if(p.size()==k)
        {
        x = p.poll();
        }
       
        p.add(Math.max(x,val));
      //  System.out.println(p);
        return p.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */