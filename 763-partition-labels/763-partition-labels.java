class Solution {
    public List<Integer> partitionLabels(String s) {
        int first[] = new int[26];
        int last[] = new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);
        for(int i=0;i<s.length();i++)
        {
            int x = s.charAt(i)-'a';
            if(first[x] == -1)
            {
                first[x] = i;
                last[x] = i;
            }
            else
            {
                last[x] = i;
            }
        }
        int st = 0;
        int ed = 0;
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<s.length();i++)
        {
            int x = s.charAt(i)-'a';
            ed = Math.max(ed,last[x]);
            if(ed == i)
            {
                ans.add(ed-st+1);
                st = i+1;
                ed = i+1;
            }
        }
        return ans;
    }
}