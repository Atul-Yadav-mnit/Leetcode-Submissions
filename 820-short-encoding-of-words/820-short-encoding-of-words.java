class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words,(w1,w2) -> w2.length()-w1.length());
        int ans = 0;
        HashSet<String> h = new HashSet<String>();
        for(int i=0;i<words.length;i++)
        {
            String s = words[i];
            if(h.contains(s))
            {
                continue;
            }
            ans+=s.length()+1;
            for(int j=0;j<words[i].length();j++)
            {
                String m = words[i].substring(j,words[i].length());
                h.add(m);
            }
        }
        return ans;
    }
}