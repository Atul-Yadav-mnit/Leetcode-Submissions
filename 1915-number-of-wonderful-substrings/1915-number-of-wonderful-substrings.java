class Solution {
    public long wonderfulSubstrings(String s) {
        int i =0;
        int count[] = new int[10];
        HashMap<Integer,Long> h = new HashMap<Integer,Long>();
        long ans = 0;
        //String ss = "0000000000";
        h.put(0,(long)1);
        while(i<s.length())
        {
            count[s.charAt(i)-'a']++;
            //StringBuilder temp = new StringBuilder();
            int temp = 0;
            for(int j=0;j<10;j++)
            {
                // temp.append(count[j]%2);
                temp = temp*10 + (count[j]%2);
            }
          //  String x = temp.toString();
           // System.out.println(x);
            int x = temp;
            
            //when all are even
            if(h.containsKey(x))
            ans += h.get(x);
            

            for(int j=0;j<10;j++)
            {
                // make the j one odd
                // StringBuilder temp2 = new StringBuilder();
                int temp2 = 0;
                for(int k=0;k<10;k++)
                {
                    if(j == k)
                    {
                        int y = Math.abs(1-(count[k]%2));
                        temp2 = temp2*10 + y;
                    }
                    else
                    {
                        int y = count[k]%2;
                         temp2 = temp2*10 + y;
                    }
                }
                // String z = temp2.toString();
                int z = temp2;
               // System.out.println("Needed z = "+z);
                if(h.containsKey(z))
                    ans += h.get(z);
            }
            
            if(h.containsKey(x))
            {
                h.put(x,h.get(x)+1);
            }
            else
            {
                h.put(x,(long)1);
            }
            i++;
            
            
        }
        return ans;
    }
}