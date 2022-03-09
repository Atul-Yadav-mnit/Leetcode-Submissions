class Solution {
    public int maxChunksToSorted(int[] arr) {
        int brr[] = new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            brr[i] = arr[i];
        }
        Arrays.sort(brr);
        int count = 0;
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        // add for sorted and subtract for unsorted
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] == brr[i] && h.size()==0)
            {
                count++;
            }
            else
            {
                if(h.containsKey(arr[i]) == false)
                {
                    h.put(arr[i],-1);
                }
                else
                {
                    int x = h.get(arr[i])-1;
                    if(x != 0)
                    {
                        h.put(arr[i],x);
                    }
                    else
                    {
                        h.remove(arr[i]);
                    }
                }
                
                
                if(h.containsKey(brr[i]) == false)
                {
                    h.put(brr[i],1);
                }
                else
                {
                    int x = h.get(brr[i])+1;
                    if(x != 0)
                    {
                        h.put(brr[i],x);
                    }
                    else
                    {
                        h.remove(brr[i]);
                    }
                }
            //    System.out.println(h);
                
                if(h.size()==0)
                {
                    count++;
                }
                
            }
            
        }
        return count;
    }
}