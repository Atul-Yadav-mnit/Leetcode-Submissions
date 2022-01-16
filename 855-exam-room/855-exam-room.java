class ExamRoom {

    public ArrayList<Integer> arr;
    public int n;
    public ExamRoom(int n) {
        this.n = n;
        arr = new ArrayList<Integer>();
    }
    
    public int seat() {
        if(arr.size() == 0)
        {
            arr.add(0);
            return 0;
        }
        int prev = -1;
        int mdis = 0;
        int pos = 0;
        int k = 0;
        if(arr.get(0) == 0)
        {
            mdis =  0;
            pos = -1;
        }
        else
        {
            mdis = arr.get(0);
            pos = 0;
            k = 0;
        }
        for(int i=1;i<arr.size();i++)
        {
            if( (arr.get(i)-arr.get(i-1))/2 > mdis )
            {
                mdis = (arr.get(i)-arr.get(i-1))/2 ;
                pos = arr.get(i-1) + mdis;
                k = i;
            }
        }
        if( n-1-arr.get(arr.size()-1) > mdis )
        {
            mdis = n-1-arr.get(arr.size()-1) ;
            pos = n-1;
            k = arr.size();
        }
        arr.add(k,pos);
        return pos;
    }
    
    public void leave(int p) {
        arr.remove((Integer)p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */