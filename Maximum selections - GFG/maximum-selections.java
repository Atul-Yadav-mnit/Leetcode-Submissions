// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*; 

class GFG{
	public static void main(String args[]) throws IOException { 
		
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
       		int n = sc.nextInt();
			
			int arr[][] = new int[n][2];
          
        	for( int i=0 ; i<n ; i++ ){            
            	for( int j=0 ; j<2 ; j++ ){
                	arr[i][j] = sc.nextInt();
            	}
         	}
            
            solver solve = new solver();
			System.out.println( solve.max_non_overlapping(arr,n) ); 
			t--;
		}
	} 
}

// } Driver Code Ends


// ranges[i][0] is the start of ith range
// ranges[i][1] is the end of ith range

class solver
{
    static int max_non_overlapping(int r[][], int n){
        // code here
        Arrays.sort(r,(r1,r2) -> r1[0]-r2[0]);
        int ans = 1;
        int cur = r[0][1];
        for(int i=1;i<n;i++)
        {
            if(r[i][0] >= cur)
            {
                ans++;
                cur = r[i][1];
            }
            else if(r[i][1] < cur)
            {
                cur = r[i][1];
            }
        }
        return ans;
    }
}