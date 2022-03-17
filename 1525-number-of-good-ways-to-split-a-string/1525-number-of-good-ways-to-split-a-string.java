class Solution {
    public int numSplits(String s) {
        int n = s.length();
        int left[] = new int[26];
        int right[] = new int[26];
        int rcount = 0;
        for(int i=0;i<s.length();i++)
        {
            if(right[s.charAt(i)-'a']==0)
            {
                rcount++;
            }
            right[s.charAt(i)-'a']++;
        }
       
        int lcount = 0;
        int count = 0;
        for(int i=0;i<s.length();i++)
        {
            if(right[s.charAt(i)-'a'] == 1)
            {
                rcount--;
            }
            right[s.charAt(i)-'a']--;
            left[s.charAt(i)-'a']++;
            if(left[s.charAt(i)-'a'] == 1)
            {
                lcount++;
            }
            if(lcount == rcount)
            {
                count++;
            }
           // System.out.println(left[0]+" "+right[0]);
        }
        return count;
    }
}