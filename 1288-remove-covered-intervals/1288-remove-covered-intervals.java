class Solution {
    class Pair{
        int s,e;
        Pair(int s, int e)
        {
            this.s = s;
            this.e = e;
        }
    }
    public int removeCoveredIntervals(int[][] arr) {
        Arrays.sort(arr,(a1,a2) -> {
            if(a1[0] == a2[0])
            {
                return a2[1]-a1[1];
            }
            return a1[0]-a2[0];
        });
        ArrayList<Integer> index = new ArrayList<Integer>();
        index.add(0);
        for(int i=1;i<arr.length;i++)
        {
            int ps = arr[index.get(index.size()-1)][0];
            int pe = arr[index.get(index.size()-1)][1];
            if(arr[i][1] <= pe && arr[i][0] >=ps )
            {
               
            }
            else
            {
                index.add(i);
            }
        }
        return index.size();
    }
}