// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    
    Iterator<Integer> cur,prev;
    Integer num = -1;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        cur = iterator;
	    num = cur.next();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
       return num;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(cur.hasNext())
        {
            Integer t = num;
            num  = cur.next();
            return t;
        }
        else if(num!=-1)
        {
            Integer t = num;
            num = -1;
            return t;
        }
        else
        {
            return new Integer(-1);
        }
       
    
	}
	
	@Override
	public boolean hasNext() {
	    if(cur.hasNext() || num!=-1)
        {
            return true;
        }
        return false;
	}
}