class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int x = tops[0];
        int y = bottoms[0];
        int a1 = 0;
        int a2= 0;
        for(int i=0;i<tops.length;i++)
        {
            if(tops[i] == x)
            {
                
            }
            else if(bottoms[i] == x)
            {
                a1++;
            }
            else
            {
                
                a1 = tops.length+1;
                break;
            }
        }
        
        for(int i=0;i<tops.length;i++)
        {
            if(bottoms[i] == x)
            {
                
            }
            else if(tops[i] == x)
            {
                a2++;
            }
            else
            {
                a2 = tops.length+1;
                break;
            }
        }
        int ans = Math.min(a1,a2);
        a1 = 0;
        a2=0;
        for(int i=0;i<tops.length;i++)
        {
            if(tops[i] == y)
            {
                
            }
            else if(bottoms[i] == y)
            {
                a1++;
            }
            else
            {
                a1 = tops.length+1;
                break;
            }
        }
        for(int i=0;i<tops.length;i++)
        {
            if(bottoms[i] == y)
            {
                
            }
            else if(tops[i] == y)
            {
                a2++;
            }
            else
            {
                a2 = tops.length+1;
                break;
            }
        }
       // System.out.println(y+" "+a2);
        int t = Math.min(a1,a2);
        ans = Math.min(t,ans);
        if(ans<tops.length)
        {
            return ans;
        }
        return -1;
    }
}