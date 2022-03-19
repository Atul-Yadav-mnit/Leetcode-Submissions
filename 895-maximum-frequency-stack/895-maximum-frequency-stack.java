class FreqStack {
    ArrayList<Integer> num;
    ArrayList<ArrayList<Integer>> time;
    int t=0;
    public FreqStack() {
        num = new ArrayList<Integer>();
        time = new ArrayList<ArrayList<Integer>>();
        t = 0;
    }
    
    public void push(int val) {
        int in = -1;
        t++;
        for(int i=0;i<num.size();i++)
        {
            if(num.get(i) == val)
            {
                in = i;
                break;
            }
        }
        if(in == -1)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(t);
            num.add(val);
            time.add(temp);
        }
        else
        {
            ArrayList<Integer> temp = time.get(in);
            temp.add(t);
        }
    }
    
    public int pop() {
        int mf = 0;
        int in = -1;
        int lt = 0;
        for(int i=0;i<num.size();i++)
        {
            if(time.get(i).size() > mf)
            {
                mf = time.get(i).size();
                lt = time.get(i).get(mf-1);
                in = i;
            }
            else if(time.get(i).size() == mf && time.get(i).get(mf-1) > lt )
            {
                mf = time.get(i).size();
                lt = time.get(i).get(mf-1);
                in = i;
            }
        }
        ArrayList<Integer> temp = time.get(in);
        temp.remove(temp.size()-1);
        return num.get(in);
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */