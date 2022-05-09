class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        for(int i=0;i<digits.length();i++)
        {
            char x = digits.charAt(i);
            if(x == '2')
            {
                if(ans.size() == 0)
                {
                    ans.add("a");
                    ans.add("b");
                    ans.add("c");
                   // System.out.println("ans in if "+ans);
                }
                else
                {
                    int len = ans.size();
                    for(int j=0;j<len;j++)
                    {
                        String temp = ans.get(j);
                        String p = new String(temp);
                        p = p+'a';
                        String y = new String(temp);
                        y = y+'b';
                        String z = new String(temp);
                        z = z+'c';
                        ans.add(p);
                        ans.add(y);
                        ans.add(z);
                        //System.out.println("ans in else "+ans);
                    }
                    for(int j=0;j<len;j++)
                    {
                        ans.remove(0);
                    }
                }
            }
            else if(x == '3')
            {
                if(ans.size() == 0)
                {
                    ans.add("d");
                    ans.add("e");
                    ans.add("f");
                   // System.out.println("ans in if "+ans);
                }
                else
                {
                    int len = ans.size();
                    for(int j=0;j<len;j++)
                    {
                        String temp = ans.get(j);
                        String p = new String(temp);
                        p = p+'d';
                        String y = new String(temp);
                        y = y+'e';
                        String z = new String(temp);
                        z = z+'f';
                        ans.add(p);
                        ans.add(y);
                        ans.add(z);
                        //System.out.println("ans in else "+ans);
                    }
                    for(int j=0;j<len;j++)
                    {
                        ans.remove(0);
                    }
                }
            }
            else if(x == '4')
            {
                if(ans.size() == 0)
                {
                    ans.add("g");
                    ans.add("h");
                    ans.add("i");
                   // System.out.println("ans in if "+ans);
                }
                else
                {
                    int len = ans.size();
                    for(int j=0;j<len;j++)
                    {
                        String temp = ans.get(j);
                        String p = new String(temp);
                        p = p+'g';
                        String y = new String(temp);
                        y = y+'h';
                        String z = new String(temp);
                        z = z+'i';
                        ans.add(p);
                        ans.add(y);
                        ans.add(z);
                        //System.out.println("ans in else "+ans);
                    }
                    for(int j=0;j<len;j++)
                    {
                        ans.remove(0);
                    }
                }
            }
            else if(x == '5')
            {
                if(ans.size() == 0)
                {
                    ans.add("j");
                    ans.add("k");
                    ans.add("l");
                   // System.out.println("ans in if "+ans);
                }
                else
                {
                    int len = ans.size();
                    for(int j=0;j<len;j++)
                    {
                        String temp = ans.get(j);
                        String p = new String(temp);
                        p = p+'j';
                        String y = new String(temp);
                        y = y+'k';
                        String z = new String(temp);
                        z = z+'l';
                        ans.add(p);
                        ans.add(y);
                        ans.add(z);
                        //System.out.println("ans in else "+ans);
                    }
                    for(int j=0;j<len;j++)
                    {
                        ans.remove(0);
                    }
                }
            }
            else if(x == '6')
            {
                if(ans.size() == 0)
                {
                    ans.add("m");
                    ans.add("n");
                    ans.add("o");
                   // System.out.println("ans in if "+ans);
                }
                else
                {
                    int len = ans.size();
                    for(int j=0;j<len;j++)
                    {
                        String temp = ans.get(j);
                        String p = new String(temp);
                        p = p+'m';
                        String y = new String(temp);
                        y = y+'n';
                        String z = new String(temp);
                        z = z+'o';
                        ans.add(p);
                        ans.add(y);
                        ans.add(z);
                        //System.out.println("ans in else "+ans);
                    }
                    for(int j=0;j<len;j++)
                    {
                        ans.remove(0);
                    }
                }
            }
            else if(x == '7')
            {
                if(ans.size() == 0)
                {
                    ans.add("p");
                    ans.add("q");
                    ans.add("r");
                    ans.add("s");
                   // System.out.println("ans in if "+ans);
                }
                else
                {
                    int len = ans.size();
                    for(int j=0;j<len;j++)
                    {
                        String temp = ans.get(j);
                        String p = new String(temp);
                        p = p+'p';
                        String y = new String(temp);
                        y = y+'q';
                        String z = new String(temp);
                        z = z+'r';
                        String zz = new String(temp);
                        zz = zz+'s';
                        ans.add(p);
                        ans.add(y);
                        ans.add(z);
                        ans.add(zz);
                        //System.out.println("ans in else "+ans);
                    }
                    for(int j=0;j<len;j++)
                    {
                        ans.remove(0);
                    }
                }
            }
            else if(x == '8')
            {
                if(ans.size() == 0)
                {
                    ans.add("t");
                    ans.add("u");
                    ans.add("v");
                   // System.out.println("ans in if "+ans);
                }
                else
                {
                    int len = ans.size();
                    for(int j=0;j<len;j++)
                    {
                        String temp = ans.get(j);
                        String p = new String(temp);
                        p = p+'t';
                        String y = new String(temp);
                        y = y+'u';
                        String z = new String(temp);
                        z = z+'v';
                        ans.add(p);
                        ans.add(y);
                        ans.add(z);
                        //System.out.println("ans in else "+ans);
                    }
                    for(int j=0;j<len;j++)
                    {
                        ans.remove(0);
                    }
                }
            }
            else if(x == '9')
            {
                if(ans.size() == 0)
                {
                    ans.add("w");
                    ans.add("x");
                    ans.add("y");
                    ans.add("z");
                   // System.out.println("ans in if "+ans);
                }
                else
                {
                    int len = ans.size();
                    for(int j=0;j<len;j++)
                    {
                        String temp = ans.get(j);
                        String p = new String(temp);
                        p = p+'w';
                        String y = new String(temp);
                        y = y+'x';
                        String z = new String(temp);
                        z = z+'y';
                        String zz = new String(temp);
                        zz = zz+'z';
                        ans.add(p);
                        ans.add(y);
                        ans.add(z);
                        ans.add(zz);
                        //System.out.println("ans in else "+ans);
                    }
                    for(int j=0;j<len;j++)
                    {
                        ans.remove(0);
                    }
                }
            }
            
        }
        return ans;
    }
}