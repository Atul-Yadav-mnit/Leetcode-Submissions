class Solution {
    public int fun(String s, int l , int h)
    {
      //  System.out.println(l+" "+h);
        
        
        Stack<Integer> st = new Stack<Integer>();
        int ans =0;
        int cur = l;
        for(int i=l;i<=h;i++)
        {
            char c = s.charAt(i);
            if(c == '(')
            {
                st.push(i);
            }
            else
            {
                int j = st.pop();
            }
            
            if(st.isEmpty())
            {
               // System.out.println((cur)+" "+(i));
               
                if(i-1==cur)
                {
                    ans+=1;
                }
                else
                {
                    ans+= 2*fun(s,cur+1,i-1); 
                }
                
                cur = i+1;
            }
           
        }
        return ans;
    }
    public int scoreOfParentheses(String s) {
       return fun(s,0,s.length()-1);
    }
}