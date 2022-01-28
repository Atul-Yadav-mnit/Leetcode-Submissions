class WordDictionary {
    
    class Trie
    {
        boolean end = false;
        Trie child[] = new Trie[26];
    }
    
    Trie head;
    
    public WordDictionary() {
        head = new Trie();
    }
    
    public void addWord(String word) {
        Trie temp = head;
        int n = word.length();
        for(int i=0;i<n;i++)
        {
            char c = word.charAt(i);
            if(temp.child[c-'a'] == null)
            {
                temp.child[c-'a'] = new Trie();
            }
            temp = temp.child[c-'a'];
        }
        temp.end = true;
    }
    
    public boolean fun(String word, int x,Trie temp)
    {
        if(x == word.length())
        {
            return temp.end;
        }
        char c = word.charAt(x);
        if(c!='.')
        {
            if(temp.child[c-'a'] == null)
            {
                return false;
            }
            temp = temp.child[c-'a'];
            return fun(word,x+1,temp);
        }
        else
        {
            boolean ans = false;
            for(int j=0;j<26;j++)
            {
                if(temp.child[j]!=null)
                ans = ans || fun(word,x+1,temp.child[j]);
            }
            return ans;
        }
    }
    
    public boolean search(String word) {
        
        return fun(word,0,head);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */