class MyCircularQueue {

    int arr[];
    int f = 0;
    int e = -1;
    int k;
    int count = 0;
    public MyCircularQueue(int k) {
        arr = new int[k];
        this.k = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull())
        {
            return false;
        }
        e = (e+1)%k;
        arr[e] = value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())
        {
            return false;
        }
        f = (f+1)%k;
        count--;
        return true;
    }
    
    public int Front() {
        if(isEmpty())
        {
            return -1;
        }
        int ans = arr[f];
        return ans;
    }
    
    public int Rear() {
        if(isEmpty())
        {
            return -1;
        }
        int ans = arr[e];
        return ans;
    }
    
    public boolean isEmpty() {
        return count==0;
    }
    
    public boolean isFull() {
        return count == k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */