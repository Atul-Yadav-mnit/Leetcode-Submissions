/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<List<NestedInteger>> n;
    Stack<Integer> s;
    int cur;
    public NestedIterator(List<NestedInteger> nestedList) {
        n = new Stack<List<NestedInteger>>();
        s = new Stack<Integer>();
        n.add(nestedList);
        s.add(0);
        cur = -100000000;
    }

    @Override
    public Integer next() {
        int temp = cur;
        cur = -100000000;
        return temp;
    }

    @Override
    public boolean hasNext() {
        while(!n.isEmpty())
        {
            List<NestedInteger> x = n.peek();
            int y = s.pop();
            s.push(y+1);
            //System.out.println(y+" "+x.size());
            if(y == x.size())
            {
                s.pop();
                n.pop();
            }
            else
            {
                NestedInteger z = x.get(y);
                List<NestedInteger> a = z.getList();
                if(a.size() == 0)
                {
                    if(z.isInteger())
                    {
                        cur = z.getInteger();
                        //System.out.println(cur);
                        return true;
                    }
                }
                else
                {
                    n.push(a);
                    s.push(0);
                }
            }            
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */