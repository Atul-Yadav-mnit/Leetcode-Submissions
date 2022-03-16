class Solution {
    public boolean t[][],b[][];
    public boolean fun(int push[], int pop[], int x, int y,Stack<Integer> s)
    {
        if(b[x][y])
        {
            return t[x][y];
        }
        if(x==push.length)
        {
            while(y<pop.length)
            {
                if(s.pop()!=pop[y])
                {
                    b[x][y] = true;
                    return t[x][y] = false;
                }
                y++;
            }
            b[x][y] = true;
            return t[x][y] = true;
        }
        if(s.isEmpty()==false && s.peek() == pop[y])
        {
            int z = s.pop();
            boolean ans1 = fun(push,pop,x,y+1,s);
            s.push(z);
            s.push(push[x]);
            boolean ans2 = fun(push,pop,x+1,y,s);
            b[x][y] = true;
            return t[x][y] = ans1 || ans2;
        }
        else
        {
            s.push(push[x]);
            boolean ans = fun(push,pop,x+1,y,s);
            b[x][y] = true;
            return t[x][y] =  ans;
        }
    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        b = new boolean[pushed.length+1][pushed.length+1];
        t = new boolean[pushed.length+1][pushed.length+1];
        Stack<Integer> s = new Stack<Integer>();
        return fun(pushed,popped,0,0,s);
    }
}