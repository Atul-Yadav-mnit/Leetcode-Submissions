class Solution {
    public String removeKdigits(String num, int k) {
        ArrayList<Character> arr = new ArrayList<Character>();
        int i=0;
        while(i<num.length())
        {
            char x = num.charAt(i);
            if(k>0 && arr.size()>0 && arr.get(arr.size()-1) > x )
            {
                arr.remove(arr.size()-1);
                k--;
            }
            else
            {
                arr.add(x);
                i++;
            }
        }
        StringBuilder ans = new StringBuilder();
        boolean isz = true;
        for(i=0;i<arr.size()-k;i++)
        {
            if(isz && arr.get(i)=='0')
            {
                continue;
            }
            else
            {
                isz = false; 
                ans.append(arr.get(i));
            }
            
        }
        //System.out.println(ans.toString());
        if(ans.length()==0)
        {
            return "0";
        }
        return ans.toString();
    }
}