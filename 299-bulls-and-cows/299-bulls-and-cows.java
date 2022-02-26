class Solution {
    public String getHint(String secret, String guess) {
        int arr[] = new int[10];
        int brr[] = new int[10];
        for(int i=0;i<secret.length();i++)
        {
            arr[secret.charAt(i)-'0']++;
        }
        for(int i=0;i<guess.length();i++)
        {
            brr[guess.charAt(i)-'0']++;
        }
        int count = 0;
        for(int i=0;i<10;i++)
        {
            count += Math.min(arr[i],brr[i]);
        }
        int same = 0;
        for(int i=0;i<secret.length();i++)
        {
            if(secret.charAt(i) == guess.charAt(i) )
            {
                same++;
            }
        }
        StringBuilder ans = new StringBuilder();
        ans.append(same);
        ans.append("A");
        count -= same;
      
        ans.append(count);
        ans.append("B");
        return ans.toString();
    }
}