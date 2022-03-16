class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<Integer>();
        int x = 0;
        int y = 0;
        while(x<pushed.length)
        {
            if(s.isEmpty()==false && s.peek()==popped[y])
            {
                s.pop();
                y++;
            }
            else
            {
                s.push(pushed[x]);
                x++;
            }
        }
        while(s.isEmpty()==false && s.peek()==popped[y])
        {
            s.pop();
            y++;
        }
        return s.isEmpty() && y==popped.length;
    }
}