class Solution {
    public int compareVersion(String version1, String version2) {
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        ArrayList<Integer> a2 = new ArrayList<Integer>();
        int cur = 0;
        for(int i=0;i<version1.length();i++)
        {
            char c = version1.charAt(i);
            if(c == '.')
            {
                a1.add(cur);
                cur = 0;
            }
            else
            {
                cur = cur*10 + (c-'0');
            }
        } 
        a1.add(cur);
        cur = 0;
        for(int i=0;i<version2.length();i++)
        {
            char c = version2.charAt(i);
            if(c == '.')
            {
                a2.add(cur);
                cur = 0;
            }
            else
            {
                cur = cur*10 + (c-'0');
            }
        }
        a2.add(cur);
       //  System.out.println(a1+" "+a2);
        for(int i=a1.size()-1;i>=0;i--)
        {
            if( a1.get(i) == 0 )
            {
                a1.remove(i);
            }
            else
            {
                break;
            }
        }
        for(int i=a2.size()-1;i>=0;i--)
        {
            if( a2.get(i) == 0 )
            {
                a2.remove(i);
            }
            else
            {
                break;
            }
        }
        int x = 0;
        while(x<a1.size() && x<a2.size())
        {
            if(a1.get(x) > a2.get(x))
            {
                return 1;
            }
            else if(a1.get(x) < a2.get(x))
            {
                return -1;
            }
            else
            {
                x++;
            }
           
        }
    
       
        if(x < a1.size() )
        {
            return 1;
        }
        if(x < a2.size() )
        {
            return -1;
        } 
        return 0;
    }
}