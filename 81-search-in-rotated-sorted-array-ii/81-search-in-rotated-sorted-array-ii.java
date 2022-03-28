class Solution {
    public boolean fun(int arr[], int l, int h, int t)
    {
        if(l>h)
        {
            return false;
        }
    
        int m = l+(h-l)/2;
        int part = -1;
        int tpart = 1;
        if(t<arr[0])
        {
            tpart = 2;
        }
        if(arr[m] > arr[0])
        {
            part = 1;
        }
        else if(arr[m]<arr[0])
        {
            part = 2;
        }
        if(arr[m] == t)
        {
            return true;
        }
        else if(arr[m] > t)
        {
            if(part == 1)
            {
                if(tpart == 1)
                {
                    return fun(arr,l,m-1,t);
                }
                else
                {
                    return fun(arr,m+1,h,t);
                }
                
            }
            else if(part == 2)
            {
                if(tpart == 1)
                {
                    return fun(arr,l,m-1,t);
                }
                else
                {
                    return fun(arr,l,m-1,t);
                }
            }
            else
            {
                return fun(arr,l,m-1,t) || fun(arr,m+1,h,t);
            }
        }
        else
        {
            if(part == 1)
            {
                if(tpart == 1)
                {
                    return fun(arr,m+1,h,t);
                }
                else
                {
                    return fun(arr,m+1,h,t);
                }
                
            }
            else if(part == 2)
            {
                if(tpart == 1)
                {
                    return fun(arr,l,m-1,t);
                }
                else
                {
                    return fun(arr,m+1,h,t);
                }
            }
            else
            {
                return fun(arr,l,m-1,t) || fun(arr,m+1,h,t);
            }
        }
    }
    public boolean search(int[] nums, int target) {
        if(nums[0] == target)
        {
            return true;
        }
        return fun(nums,0,nums.length-1,target);
    }
}