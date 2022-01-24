class Solution {
    public boolean detectCapitalUse(String word) {
        boolean a = false;
        if(word.charAt(0)<='Z')
        {
            if(word.length()>1 && word.charAt(1)<='Z' )
            {
                a = true;
            }
        }
        
        for(int i=1;i<word.length();i++)
        {
            
            if(word.charAt(i)>'Z' && a )
            {
                return false;
            }
            if(word.charAt(i)<='Z' && !a )
            {
                return false;
            }
            
        }
        return true;
    }
}