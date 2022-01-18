class Solution {
    public int[] asteroidCollision(int[] a) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0;i<a.length;i++)
        {
            if(a[i] > 0)
            {
                arr.add(a[i]);
            }
            else
            {
                if(arr.size()>0)
                {
                    
                    int k = arr.size()-1;
                    boolean flag = true;
                    while(k>=0)
                    {
                        int x = arr.get(k);
                        if(x > 0)
                        {
                            
                            if(x > Math.abs(a[i]))
                            {
                               k--;
                                flag = false;
                               break;
                            }
                            else if(x < Math.abs(a[i]))
                            {
                                arr.remove(k--);
                                
                            }
                            else
                            {
                                flag = false;
                                arr.remove(k--);
                                break;
                            }
                        }
                        else
                        {
                            flag = false;
                            arr.add(a[i]);
                            break;
                        }
                       
                    }
                    if(flag)
                    {
                        arr.add(a[i]);
                    }
                }
                else   
                {
                    arr.add(a[i]);
                }
            }
        }
        int ans[] = new int[arr.size()];
        for(int i=0;i<arr.size();i++)
        {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}