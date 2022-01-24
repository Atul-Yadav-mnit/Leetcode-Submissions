class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=1;i<10;i++)
        {
            for(int j=1;j<=9-i+1;j++)
            {
                int a =0;
                for(int k=0;k<i;k++)
                {
                    a = a*10 + (j+k);
                }
                if(a>=low && a<=high)
                arr.add(a);
            }
        }
        return arr;
    }
}