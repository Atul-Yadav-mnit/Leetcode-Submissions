class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<List<String>>();
      //  System.out.println("a".compareTo("b"));
        for(int i=0;i<searchWord.length();i++)
        {
            String s = searchWord.substring(0,i+1);
            int l = 0;
            int h = products.length-1;
            int in = -1;
            while(l<=h)
            {
                int m = l+(h-l)/2;
                int min = Math.min(i+1,products[m].length());
                String a = products[m].substring(0,min);
                int k = a.compareTo(s);
                if(k == 0)
                {
                    in = m;
                    h = m-1;
                }
                else if(k<0)
                {
                    l = m+1;
                }
                else
                {
                    h = m-1;
                }
            }
            if(in == -1)
            {
                ans.add(new ArrayList<String>());
            }
            else
            {
                ans.add(new ArrayList<String>());
                for(int j=0; j<3 && in+j<products.length ;j++)
                {
                    int min = Math.min(i+1,products[in+j].length());
                    if(min!=i+1)
                    {
                        break;
                    }
                    String a = products[in+j].substring(0,i+1);
                    int k = a.compareTo(s);
                    if(k == 0)
                    {
                        ans.get(i).add(products[in+j]);
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
        return ans;
        
    }
}














// class Solution {
//     class Trie{
//         boolean isend = false;
//         Trie[] a = new Trie[26];
//     }
    
//     List<List<String>> ans;
//     int count;
    
//     public void add(String p,Trie t)
//     {
//         for(int i=0;i<p.length();i++)
//         {
//             int x = p.charAt(i)-'a';
//             if(t.a[x] == null)
//             {
//                 t.a[x] = new Trie();
//             }
//             t = t.a[x];
//         }
//         t.isend = true;
//     }
    
//     public List<String> fun(Trie t)
//     {
//         List<String> ans = new ArrayList<String>();
//         if(count >= 3)
//         {
//             return ans;
//         }
//         else if(t == null)
//         {
//             return ans;
//         }
//         for(int i=0;i<26;i++)
//         {
//             if(count >= 3)
//             {
//                 return ans;
//             }
//             if(t.a[i]!=null)
//             {
//                 List<String> temp = fun(t.a[i]);
//                 char c = (char)(i+'a');
//                 if(t.a[i].isend)
//                 {
//                     temp.add(String.valueOf(c));
//                 }
//                 for(int j=0;j<temp.size();j++)
//                 {
//                     if(count >= 3)
//                     {
//                         return ans;
//                     }
//                     ans.add(j,String.valueOf(c)+temp.get(j));
//                     count++;
//                 }
//             }
//         }
//         return ans;
//     }
        
//     public List<List<String>> suggestedProducts(String[] products, String searchWord) {
//         Trie t = new Trie();
//         for(int i=0;i<products.length;i++)
//         {
//             add(products[i],t);
//         }
//         ans = new ArrayList<List<String>>(); 
//         for(int i=0;i<searchWord.length();i++)
//         {
//             int x = searchWord.charAt(i)-'a';
//             if(t.a[x] == null)
//             {
//                 for(int j=i;i<searchWord.length();j++)
//                 {
//                     ans.add(new ArrayList<String>());
//                 }
//                 return ans;
//             }
//             else
//             {
//                 t = t.a[x];
//                 count = 0;
//                 List<String> temp = fun(t);
//                 for(int j=0;j<temp.size();j++)
//                 {
//                     temp.set(j,searchWord.substring(0,i+1)+temp.get(j));
//                 }
//                 ans.add(temp);
//             }
//         }
//         return ans;
//     }
// }