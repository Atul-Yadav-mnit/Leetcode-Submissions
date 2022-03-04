class Solution {
    public boolean closeStrings(String s, String t) {
        int arr1[] =new int[26];
        int arr2[] =new int[26];
        int a1[] =new int[26];
        int a2[] =new int[26];
        for(int i=0;i<s.length();i++)
        {
            arr1[s.charAt(i)-'a']++;
            a1[s.charAt(i)-'a']=1;
        }
        for(int i=0;i<t.length();i++)
        {
            arr2[t.charAt(i)-'a']++;
            a2[t.charAt(i)-'a']=1;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0;i<26;i++)
        {
            if(arr1[i]!=arr2[i] || a1[i]!=a2[i])
            {
                return false;
            }
        }
        return true;
    }
}