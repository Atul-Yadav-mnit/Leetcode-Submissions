class Solution {
    public char[][] rotateTheBox(char[][] box) {
        for(int i=0;i<box.length;i++)
        {
            int cc = box[0].length-1;
            for(int j=box[0].length-1;j>=0;j--)
            {
                if(box[i][j] == '#')
                {
                    box[i][j] = '.';
                    box[i][cc] = '#';
                    cc = cc-1;
                }
                else if(box[i][j] == '*')
                {
                    cc = j-1;
                }
            }
        }
        char ans[][] = new char[box[0].length][box.length];
        for(int i=0;i<box.length;i++)
        {
            for(int j=box[0].length-1;j>=0;j--)
            {
                int k = box.length-1-i;
                ans[j][k] = box[i][j];
            }
        }
        return ans;
    }
}