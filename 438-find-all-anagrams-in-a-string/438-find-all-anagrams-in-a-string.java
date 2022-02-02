class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int count[] = new int[26];
        int i = 0;
        int j = 0;
        int size = p.length();
        while(j<p.length())
        {
            count[p.charAt(j)-'a']++;
            j++;
        }
        j = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(j<s.length())
        {
           //  System.out.println(i+" "+j+" "+size);
            int c = s.charAt(j)-'a';
            if(count[c] > 0)
            {
                count[c]--;
                size--;
                if(size == 0)
                {
                    ans.add(i);
                    size++;
                    count[s.charAt(i)-'a']++;
                    i++;
                }
                j++;
            }
            else
            {
                if(i<j)
                {
                    count[s.charAt(i)-'a']++;
                    size++;
                    i++;
                }
                else
                {
                    size = p.length();
                    j++;
                    i = j;
                }
            }
           
        }
         
        return ans;
    }
}