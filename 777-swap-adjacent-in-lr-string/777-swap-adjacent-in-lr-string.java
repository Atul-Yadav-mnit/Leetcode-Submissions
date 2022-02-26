class Solution {
    public boolean canTransform(String start, String end) {
        StringBuilder s = new StringBuilder();
        StringBuilder e = new StringBuilder();
        ArrayList<Integer> spos = new ArrayList<Integer>();
        ArrayList<Integer> epos = new ArrayList<Integer>();
        for(int i=0;i<start.length();i++)
        {
            char x = start.charAt(i);
            if(x == 'L' || x == 'R')
            {
                s.append(x);
                spos.add(i);
            }
            
        }
         for(int i=0;i<end.length();i++)
        {
            char x = end.charAt(i);
            if(x == 'L' || x == 'R')
            {
                e.append(x);
                epos.add(i);
            }
            
        }
        String a = e.toString();
        String b = s.toString();
        if(a.length()!=b.length())
        {
            return false;
        }
       for(int i=0;i<a.length();i++)
       {
           char x = a.charAt(i) ;
           char y = b.charAt(i) ;
           if(x!=y)
           {
               return false;
           }
           if(x == 'L')
           {
               if(spos.get(i) < epos.get(i))
               {
                   return false;
               }
           }
           else
           {
              if(spos.get(i) > epos.get(i))
               {
                   return false;
               } 
           }
       }
        return true;
    }
}