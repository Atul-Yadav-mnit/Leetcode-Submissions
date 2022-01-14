class Solution {
    public int minCharacters(String s1, String s2) {
        if(s1.length() == 1 && s2.length()==1)
        {
            return 0;
        }
        char a[] = s1.toCharArray();
        char b[] = s2.toCharArray();
        int fra[] = new int[26];
        int frb[] = new int[26];
        for(int i=0;i<a.length;i++)
        {
            fra[a[i]-'a']++; 
        }
        for(int i=0;i<b.length;i++)
        {
            frb[b[i]-'a']++; 
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int min = Math.min(a.length+frb[0],b.length+fra[0]);
        for(int i=0;i<26;i++)
        {
            min = Math.min(a.length+b.length-fra[i]-frb[i],min);
        }
        // keeping a smaller
       
        for(int i=0;i<a.length;i++)
        {
            // delete 0 from a and fing from b
            char c = a[a.length-1-i];
            if(c == 'z')
            {
                continue;
            }
            int d = i;
            int l = 0;
            int h = b.length;
            while(l<h)
            {
                int m = l+(h-l)/2;
                if(b[m] > c)
                {
                    h = m;
                }
                else
                {
                    l = m+1;
                }
            }
            //if(l< a.length && a[l]<) 
            d += (l);
          //System.out.println(d);
            min = Math.min(d,min);
        }
        
        for(int i=0;i<b.length;i++)
        {
            // delete 0 from a and fing from b
            char c = b[b.length-1-i];
            if(c == 'z')
            {
                continue;
            }
            int d = i;
            int l = 0;
            int h = a.length;
            while(l<h)
            {
                int m = l+(h-l)/2;
                if(a[m] > c)
                {
                    h = m;
                }
                else
                {
                    l = m+1;
                }
            }
            d += (l);
            min = Math.min(d,min);
        }
        return min;
    }
}