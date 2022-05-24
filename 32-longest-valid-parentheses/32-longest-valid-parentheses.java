class Solution {
    /*public int max;
    HashMap<String,Integer> h ;
    public int fun(String s, int x, int pen)
    {
        if(x >= s.length())
        {
            return -999999;
        }
        
        String key = String.valueOf(x)+"_"+String.valueOf(pen);
        if(h.containsKey(key) == true)
        {
            return h.get(key);
        }
        
        char c = s.charAt(x);
        int ans ;
        if(c == '(')
        {
            ans = fun(s,x+1,pen+1);
            int ans2 = fun(s,x+1,1);
            max = Math.max(max,ans2-x+1);
        }
        else
        {
            if(pen == 0)
            {
                ans = -999999;
                int ans2 = fun(s,x+1,0);
                max = Math.max(max,ans2-(x+1)+1);
            }
            else if(pen == 1)
            {
                int tm = x;
                ans = fun(s,x+1,0);
                ans = Math.max(tm,ans);
            }
            else
            {
                ans = fun(s,x+1,pen-1);
            }
        }
        h.put(key,ans);
        return ans;
    }*/
    public int longestValidParentheses(String s) {
      /*  h = new HashMap<String,Integer>();
        max = 0;
        int len = fun(s,0,0);
        max = Math.max(max,len+1);
        return max;*/
        int dp[] = new int[s.length()];
        int ans = 0;
        Stack<Integer> st  = new Stack<Integer>();
        int max = 0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(')
            {
                dp[i] = 0;
                st.push(i);
            }
            else
            {
                if(st.size() == 0)
                {
                    dp[i] = 0;
                    st = new Stack<Integer>();
                }
                else
                {
                    int x = st.pop();
                    if(x == 0)
                    {
                       dp[i] = (i-x+1); 
                    }
                    else
                    {
                        dp[i] = dp[x-1]+(i-x+1);
                    }
                    
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
}