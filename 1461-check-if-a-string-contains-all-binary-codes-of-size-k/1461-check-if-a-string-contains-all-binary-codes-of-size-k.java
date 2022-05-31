class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<Integer> h = new HashSet<Integer>();
        int pow = (int)Math.pow(2,k-1);
        int cur = pow;
        int num = 0;
        if(s.length()<k)
        {
            return false;
        }
        for(int i=0;i<k;i++)
        {
            
            num += (s.charAt(i)-'0')*cur;
            cur = cur/2;
           // System.out.println(num);
        }
        h.add(num);
     //   System.out.println(h);
        for(int i=k;i<s.length();i++)
        {
            num -= (s.charAt(i-k)-'0')*pow;
            num = num*2;
            num += (s.charAt(i)-'0');
            h.add(num);
        }
        pow = pow*2;
        
        return h.size()==pow;
    }
}