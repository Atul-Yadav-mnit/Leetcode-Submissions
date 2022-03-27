class Solution {
    class Pair
    {
        int x,c;
        Pair(int x, int c)
        {
            this.x = x;
            this.c = c;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int ans[] = new int[k];
        ArrayList<Pair> arr = new ArrayList<Pair>();
        for(int i=0;i<mat.length;i++)
        {
            int temp = 0;
            for(int j=0;j<mat[0].length;j++)
            {
                temp+=mat[i][j];
            }
            arr.add(new Pair(i,temp));
        }
        Collections.sort(arr,(p1,p2) -> {
            if(p1.c!=p2.c)
            {
                return p1.c-p2.c;
            }
            return p1.x-p2.x;
        });
        for(int i=0;i<k;i++)
        {
            ans[i] = arr.get(i).x;
        }
        return ans;
    }
}