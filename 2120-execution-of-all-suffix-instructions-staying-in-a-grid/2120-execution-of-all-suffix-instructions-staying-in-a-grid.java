class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int ans[] = new int[s.length()];
        int cx = startPos[0];
        int cy = startPos[1];
        for(int i=0;i<s.length();i++)
        {
            int tx = cx;
            int ty = cy;
            int aa =0;
            for(int j=i;j<s.length();j++)
            {
                if(s.charAt(j) == 'U')
                {
                    
                    tx = tx-1;
                }
                else if(s.charAt(j) == 'D')
                {
                    
                    tx = tx+1;
                }
                else if(s.charAt(j) == 'L')
                {
                    
                    ty = ty-1;
                }
                else if(s.charAt(j) == 'R')
                {
                    
                    ty = ty+1;
                }
                if(tx>=0 && tx<n&&ty>=0 && ty<n)
                {
                    aa++;
                }
                else
                {
                    break;
                }
            }
            ans[i] = aa;
        }
        return ans;
    }
}