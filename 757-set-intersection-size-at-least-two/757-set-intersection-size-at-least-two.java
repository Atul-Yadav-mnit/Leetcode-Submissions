class Solution {
    public int intersectionSizeTwo(int[][] arr) {
        Arrays.sort(arr,(a1,a2) -> {
            if(a1[1]==a2[1])
            {
                return a2[0]-a1[0];
            }
            else
            {
                return a1[1]-a2[1];
            }
        });
        int prev1 = arr[0][1];
        int prev2 = arr[0][1]-1;
        int count = 2;
        ArrayList<Integer> brr = new ArrayList<Integer>();
        brr.add(prev2);
        brr.add(prev1);
      //  System.out.println(prev1+" "+prev2+" "+count);
        for(int i=1;i<arr.length;i++)
        {
            int l = arr[i][0];
            int h = arr[i][1];
            int kk = 0;
            for(int j=0;j<brr.size();j++)
            {
                int x = brr.get(j);
                if(x>=l && x<=h)
                {
                    kk++;
                }
            }
            if(kk == 0)
            {
                brr.add(h-1);
                brr.add(h);
                count+=2;
            }
            else if(kk == 1)
            {
                brr.add(h);
                count++;
            }
            
           // System.out.println(prev1+" "+prev2+" "+count+" "+i);
        }
        return count;
    }
}