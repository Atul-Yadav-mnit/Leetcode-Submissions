class Solution {
    public int calPoints(String[] ops) {
        int sum= 0;
        int arr[] = new int[ops.length];
        int k = 0;
        for(int i=0;i<ops.length;i++)
        {
            String x = ops[i];
            if(x.equals("+"))
            {
                int p =(arr[k-1]+arr[k-2]);
                arr[k++] = p;
                sum+=p;
            }
            else if(x.equals("D"))
            {
                int p = arr[k-1]*2;
                
                arr[k++]=p;
                sum+=p;
            }
            else if(x.equals("C"))
            {
                k--;
                sum-=arr[k];
            }
            else
            {
                arr[k++] = Integer.valueOf(ops[i]);
                sum+=arr[k-1];
            }
            
        }
        return sum;
    }
}