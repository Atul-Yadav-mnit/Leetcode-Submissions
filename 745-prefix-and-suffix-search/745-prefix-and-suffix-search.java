class WordFilter {

    class Trie{
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Trie child[] = new Trie[26];
    }
    
    Trie prefix;
    Trie suffix;
    HashMap<String,ArrayList<Integer>> hp,hs;
    ArrayList<Integer> ax = new ArrayList<Integer>();
    
    public WordFilter(String[] words) {
        prefix = new Trie();
        suffix = new Trie();
        hp = new HashMap<String,ArrayList<Integer>>();
        hs = new HashMap<String,ArrayList<Integer>>();
        for(int i=0;i<words.length;i++)
        {
            Trie temp = prefix;
            for(int j=0;j<words[i].length();j++)
            {
                char c = words[i].charAt(j);
                if(temp.child[c-'a']==null)
                {
                    temp.child[c-'a'] = new Trie();
                }
                temp = temp.child[c-'a'];
                temp.arr.add(i);
            }
            temp = suffix;
            for(int j=words[i].length()-1;j>=0;j--)
            {
                char c = words[i].charAt(j);
                if(temp.child[c-'a']==null)
                {
                    temp.child[c-'a'] = new Trie();
                }
                temp = temp.child[c-'a'];
                temp.arr.add(i);
            }
        }
    }
    
    public ArrayList<Integer> pfun(Trie head, String p)
    {
         if(hp.containsKey(p))
        {
            return hp.get(p);
        }
        Trie temp = head;
        for(int i=0;i<p.length();i++)
        {
            char c = p.charAt(i);
            if(temp.child[c-'a']==null)
            {
                hp.put(p,ax);
                return ax;
            }
            temp = temp.child[c-'a'];
        }
        hp.put(p,temp.arr);
        return temp.arr;
    }
    
    public ArrayList<Integer> sfun(Trie head, String p)
    {
        if(hs.containsKey(p))
        {
            return hs.get(p);
        }
        Trie temp = head;
        for(int i=p.length()-1;i>=0;i--)
        {
            char c = p.charAt(i);
            if(temp.child[c-'a']==null)
            {
                hs.put(p,ax);
                return ax;
            }
            temp = temp.child[c-'a'];
        }
        hs.put(p,temp.arr);
        return temp.arr;
    }
        
        
    public int f(String p, String s) {
        ArrayList<Integer> pre = pfun(prefix,p);
        ArrayList<Integer> suf = sfun(suffix,s);
        // System.out.println(pre);
        // System.out.println(suf);
        int i = pre.size()-1;
        int j = suf.size()-1;
        while(i>=0 && j>=0)
        {
            int a = pre.get(i);
            int b = suf.get(j);
            if(a>b)
            {
                i--;
            }
            else if(a<b)
            {
                j--;
            }
            else
            {
                return a;
            }
        }
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */