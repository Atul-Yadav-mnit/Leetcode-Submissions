class MyStack {

    ArrayDeque<Integer> q1;
    ArrayDeque<Integer> q2;
    public MyStack() {
        q1 = new ArrayDeque<Integer>();
        q2 = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        q1.addLast(x);
    }
    
    public int pop() {
        while(q1.size()>1)
        {
            q2.add(q1.removeFirst());
        }
        int x = q1.removeLast();
        ArrayDeque<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
        return x;
    }
    
    public int top() {
        while(q1.size()>1)
        {
            q2.add(q1.removeFirst());
        }
        int x = q1.removeLast();
        q2.add(x);
        ArrayDeque<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
        return x;
    }
    
    public boolean empty() {
        return q1.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */