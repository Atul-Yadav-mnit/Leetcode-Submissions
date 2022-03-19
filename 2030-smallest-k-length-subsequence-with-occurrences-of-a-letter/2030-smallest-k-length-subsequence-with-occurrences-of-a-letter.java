class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int count[] = new int[s.length()];
        int c = 0;
        for(int i=s.length()-1;i>=0;i--)
        {
            count[i] = c;
            if(s.charAt(i) == letter)
            {
                c++;
            }
        }
        Stack<Character> st = new Stack<Character>();
        int cnt = 0;
        
        
        for(int i=0;i<s.length();i++)
        {
            while(!st.isEmpty())
            {
                if(st.peek() == letter)
                {
                    
                    if(count[i] >= repetition-cnt+1 )
                    {
                        if(s.charAt(i) < st.peek() && ( k-st.size()+1 <= s.length()-i ))
                        {
                            st.pop();
                            cnt--;
                        }
                        else
                        {
                            break;
                        }
                    }
                    else
                    {
                        break;
                    }
                }
                else
                {
                    if(s.charAt(i) < st.peek() && ( k-st.size()+1 <= s.length()-i ))
                    {
                        st.pop();
                    }
                    else
                    {
                        break;
                    }
                }
            }
            if(st.size()<k)
            {
                if(s.charAt(i) == letter)
                {
                    st.push(s.charAt(i));
                    cnt++;
                }
                else
                {
                    if(k-st.size()-1 >= repetition-cnt)
                    {
                        st.push(s.charAt(i));
                    }
                }
                
            }
           
        }
        
        
        Stack<Character> rev = new Stack<Character>();
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