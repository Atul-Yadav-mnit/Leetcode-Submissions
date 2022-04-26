class Solution {
    class Pair{
        int x,y;
        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public int videoStitching(int[][] clips, int time) {
        ArrayList<Pair> arr = new  ArrayList<Pair>();
        for(int i=0;i<clips.length;i++)
        {
            arr.add(new Pair(clips[i][0],clips[i][1]));
        }
        Collections.sort(arr,(a1,a2) -> a1.x-a2.x);
        if(arr.get(0).x!=0)
        {
            return -1;
        }
        int cov = 0;
        int prev = arr.get(0).y;
        int count = 1;
        for(int i=1;i<arr.size();i++)
        {
            if(prev >= time)
            {
                break;
            }
            int s = arr.get(i).x;
            int e = arr.get(i).y;
            if(s<=prev)
            {
                if(e > prev)
                {
                    if(s<=cov)
                    {
                        prev = e;
                    }
                    else
                    {
                        count++;
                        cov = prev;
                        prev = e;
                    }
                }
                else
                {
                    //
                }
            }
            else if(s > prev)
            {
                return -1;
            }
        }
        if(prev<time)
        {
            return -1;
        }
        return count;
        
    }
}