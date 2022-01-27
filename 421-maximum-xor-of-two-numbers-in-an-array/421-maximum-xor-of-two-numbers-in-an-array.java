class Solution {
    
    class Node{
        Node left = null;
        Node right = null;
    }
    
    
    int n = (int)Math.pow(2,30);
    Node head;
    
    void add(int nums)
    {
        int temp = n;
        Node ntemp = head;
      //  System.out.println("Createing nums "+nums+" ");
        for(int i=0;i<31 && temp>0;i++)
        {
           
            int x = nums/temp;
          //  System.out.print(x+" ");
            if(x == 0)
            {
             //   System.out.print("Here 0 and ");
                if(ntemp.left == null)
                {
             //       System.out.print("new  ");
                    ntemp.left = new Node();
                }
                ntemp = ntemp.left;
             //   System.out.println(" temp = "+temp);
            }
            else
            {
             ////   System.out.print("Here 1 and ");
                if(ntemp.right == null)
                {
             //       System.out.print("new  ");
                    ntemp.right = new Node();
                }
                ntemp = ntemp.right;
             //   System.out.println(" temp = "+temp);
            }
            
            nums = nums%temp;
            temp=temp/2;
            
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        head = new Node();
        add(nums[0]);
        int ans = 0;
        for(int i=1;i<nums.length;i++)
        {
            int temp = n;
            Node ntemp = head;
            int p = nums[i];
            int cur = 0;
           // System.out.println(nums[i]);
            for(int j=0;j<31 && temp>0;j++)
            {
                int x = nums[i]/temp;
                
                if(x == 0)
                {
                   // System.out.println("for x = "+temp+" "+ntemp.right);
                   
                    if(ntemp.right != null)
                    {
                         
                        cur+=temp;
                        ntemp = ntemp.right;
                    }
                    else if(ntemp.left != null)
                    {
                        ntemp = ntemp.left;
                    }
                    else
                    {
                        break;
                    }
                }
                else
                {
                    if(ntemp.left != null)
                    {
                        cur+=temp;
                        ntemp = ntemp.left;
                    }
                    else if(ntemp.right != null)
                    {
                        ntemp = ntemp.right;
                    }
                    else
                    {
                        break;
                    }
                }
                nums[i] = nums[i]%temp;
               // System.out.print(cur+" "+temp+" "+x+" -> ");
                temp=temp/2;
            }
           // System.out.println();
            ans = Math.max(ans,cur);
            add(p);
        }
        return ans;
    }
}