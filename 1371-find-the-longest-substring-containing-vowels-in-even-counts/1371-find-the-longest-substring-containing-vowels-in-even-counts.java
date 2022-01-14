class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        h.put(0,-1);
        int max = 0;
        int count[] = new int[5];
        for(int i=0;i<s.length();i++)
        {
            char x = s.charAt(i);
            if(x == 'a')
            {
                count[0] = (count[0]+1)%2;
            }
            else if(x == 'e')
            {
                count[1] = (count[1]+1)%2;
            }
            else if(x == 'i')
            {
                count[2] = (count[2]+1)%2;
            }
            else if(x == 'o')
            {
                count[3] = (count[3]+1)%2;
            }
            else if(x == 'u')
            {
                count[4] = (count[4]+1)%2;
            }
            
            int a = 0;
            for(int j=0;j<5;j++)
            {
                a = a*10 + (count[j]);
            }
            
           // System.out.println(a);
            
            if(h.containsKey(a))
            {
                max = Math.max(max,i-h.get(a));
            }
            else
            {
                h.put(a,i);
            }
           
        }
        return max;
    }
}