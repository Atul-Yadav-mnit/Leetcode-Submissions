class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> h = new  HashSet<Integer>();
        HashSet<Integer> prev = new  HashSet<Integer>();
        prev.add(0);
        for(int i=0;i<arr.length;i++)
        {
            HashSet<Integer> t = new  HashSet<Integer>();
            t.add(arr[i]);
            for(Integer x: prev)
            {
                t.add(x|arr[i]);
            }
            prev = t;
            h.addAll(t);
        }
       // System.out.println(h);
        return h.size();
    }
}