class Solution {
    public String removeDuplicateLetters(String s) {
        int count[] = new int[26];
        Arrays.fill(count,-1);
        boolean cur[] = new boolean[26];
        for(int i=0;i<s.length();i++)
        {
            int x = s.charAt(i)-'a';
            count[x] = i;
        }
        Stack<Character> st = new  Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            int x = s.charAt(i)-'a';
            if(!cur[x])
            {
                while(!st.isEmpty())
                {
                    char y = st.peek();
                    char c = (char)(x+'a');
                    if(y > c && count[y-'a']>i)
                    {
                        
                        st.pop();
                        cur[y-'a'] = false;
                    }
                    else
                    {
                        break;
                    }
                }
                st.push((char)(x+'a'));
                cur[x] = true;
            }
           // System.out.println(st);
        }
        Stack<Character> rev = new  Stack<Character>();
        while(!st.isEmpty())
        {
            rev.push(st.pop());
        }
        StringBuilder a = new StringBuilder();
        while(!rev.isEmpty())
        {
            a.append(rev.pop());
        }
        return a.toString();
    }
}