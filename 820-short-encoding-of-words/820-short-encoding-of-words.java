class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words,(w1,w2) -> w2.length()-w1.length());
        int ans = 0;
        for(int i=0;i<words.length;i++)
        {
            String s = words[i];
            int needed = s.length()+1;
            for(int j=0;j<i;j++)
            {
                String x = words[j].substring(words[j].length()-s.length(),words[j].length());
                if(x.equals(s))
                {
                    needed = 0;
                    break;
                }
            }
            ans+=needed;
        }
        return ans;
    }
}