class Solution {
    
    public long m = 1000000007;
    public long t[][][];
    
    public long fun(int x, int n , int k, int s)
    {
       // System.out.println("start "+x+" "+k+" "+s);
        if(t[x][k][s]!=-1)
        {
            return t[x][k][s];
        }
        long ans = 0;
        if(k == 0)
        {
            ans = 1;
        }
        else if(x == n-1)
        {
            ans = 0;
        }
        else
        {
            if(k == 1 && s==1)
            {
                ans  = (fun(x+1,n,k,s)%m+fun(x+1,n,k-1,s)%m)%m;
            }
            else if(s == 1)
            {
                ans  = (fun(x+1,n,k,s)%m+fun(x+1,n,k-1,s)%m+fun(x+1,n,k-1,0)%m)%m;
            }
            else
            {
                ans = (fun(x+1,n,k,s)%m+fun(x+1,n,k,1)%m)%m;
            }
        }
       // System.out.println("end "+x+" "+k+" "+s+" "+ans);
        return t[x][k][s] = ans;
    }
    
    public int numberOfSets(int n, int k) {
        t = new long[n+1][k+2][2];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<k+2;j++)
            {
                Arrays.fill(t[i][j],-1);
            }
        }
        return (int)((fun(0,n,k,0)%m+fun(0,n,k,1)%m)%m);
    }
}