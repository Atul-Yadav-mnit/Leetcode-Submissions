class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<String>();
        StringBuilder temp = new StringBuilder();
        boolean isa = false;
        for(int i=0;i<path.length();i++)
        {
            char x = path.charAt(i);
            char y = '-';
            char z = '-';
            
            if(i+2<path.length())
            {
                z = path.charAt(i+2);
            }
            if(i+1<path.length())
            {
                y = path.charAt(i+1);
            }
           
            if(x == '/')
            {
                isa = true;
                if(temp.length() > 0)
                {
                    st.push(temp.toString());
                    temp = new StringBuilder();
                }
            }
            else if(isa &&x == '.' && y == '.' && ( z=='/' || z == '-' ) )
            {
                if(st.isEmpty()==false)
                {
                     st.pop();
                }
                i++;
               
            }
            else if(isa &&x == '.' && (y == '/' || y == '-') )
            {
                
            }
            else if(isa &&x == '.')
            {
                while(i<path.length())
                {
                    if(path.charAt(i) == '.')
                    {
                        temp.append('.');
                        i++;
                    }
                    else
                    {
                        break;
                    }
                }
                i--;
            }
            else
            {
                isa = false;
                temp.append(x);
            }
        }
        if(temp.length() > 0)
        {
            st.push(temp.toString());
            temp = new StringBuilder();
        }
        temp = new StringBuilder();
        Stack<String> st2 = new Stack<String>();
        while(!st.isEmpty())
        {
            st2.push(st.pop());
        }
        while(!st2.isEmpty())
        {
            temp.append('/');
            temp.append(st2.pop());
        }
        if(temp.length() == 0)
        {
            return "/";
        }
        else
        {
            return temp.toString();
        }
    }
}