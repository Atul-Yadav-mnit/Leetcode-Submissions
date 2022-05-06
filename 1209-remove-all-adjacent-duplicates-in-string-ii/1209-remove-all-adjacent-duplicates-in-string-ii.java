class Solution {
    public String removeDuplicates(String s, int k) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Character> brr = new ArrayList<Character>();
        for(int i=0;i<s.length();i++)
        {
            char x = s.charAt(i);
            if(arr.size()>0)
            {
                if(brr.get(arr.size()-1) == x)
                {
                    int y = arr.get(arr.size()-1);
                    if(y == k-1)
                    {
                        arr.remove(arr.size()-1);
                        brr.remove(brr.size()-1);
                    }
                    else
                    {
                        arr.remove(arr.size()-1);
                        arr.add(y+1);
                    }
                }
                else
                {
                    arr.add(1);
                    brr.add(x);
                }
            }
            else
            {
                    arr.add(1);
                    brr.add(x);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<brr.size();i++)
        {
            for(int j=0;j<arr.get(i);j++)
            ans.append(brr.get(i));
        }
        return ans.toString();
    }
}