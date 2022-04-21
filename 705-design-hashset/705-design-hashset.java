class MyHashSet {
    boolean h[];
    public MyHashSet() {
        h = new boolean[1000003];
    }
    
    public void add(int key) {
        h[key] = true;
    }
    
    public void remove(int key) {
        h[key] = false;
    }
    
    public boolean contains(int key) {
        return h[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */