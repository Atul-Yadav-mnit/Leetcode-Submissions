class Solution {
    public Stack<Integer> sum = new Stack<Integer>();
    public Stack<Character> s = new Stack<Character>();
    public int ans;
    public int scoreOfParentheses(String st) {
        ans = 0;
        for(int i=0;i<st.length();i++)
        {
            char x = st.charAt(i);
            if(x == '(')
            {
                s.push(x);
                sum.push(0);
            }
            else
            {
                s.pop();
                int y = Math.max(1,sum.pop());
                if(s.isEmpty())
                {
                    ans += y;
                }
                else
                {
                    int z = sum.pop();
                    sum.push(z+2*y);
                }
            }
        }
        return ans;
    }
}