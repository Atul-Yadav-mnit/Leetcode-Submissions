class Solution {
    public int maxProduct(String[] words) {
       
        int ans[][] = new int[words.length][26];
        
        for(int i=0;i<words.length;i++)
        {
            for(int j=0;j<words[i].length();j++)
            {
                char x = words[i].charAt(j);
                ans[i][x-'a'] = 1; 
            }
        }
        int anss = 0;
        for(int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                boolean is = false;
                for(int k=0;k<26;k++)
                {
                    if(ans[i][k]+ans[j][k] == 2)
                    {
                        is = true;
                        break;
                    }
                }
                if(!is)
                {
                    anss = Math.max(anss,words[i].length()*words[j].length());
                }
            }
        }
        return anss;
    }
}