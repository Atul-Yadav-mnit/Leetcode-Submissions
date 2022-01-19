// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [][] = new int[N][M];
		    
		    for(int i = 0;i<N;i++){
		        line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        for(int j = 0; j< M; j++){
		            arr[i][j] = Integer.parseInt(elements[j]);    
		        }
		    }
		    
		    Complete obj = new Complete();
		    int ans = obj.maximumSum(N, M, arr);
		    System.out.println(ans);
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Complete{
    
   
    // Function for finding maximum and value pair
    public static int maximumSum (int n, int m, int arr[][]) {
        //Complete the function
        for(int i=0;i<arr.length;i++)
        {
            Arrays.sort(arr[i]);
        }
        long sum =0 ;
        long prev = Integer.MAX_VALUE;
        for(int i=arr.length-1;i>=0;i--)
        {
            boolean f = false;
            for(int j=arr[i].length-1;j>=0;j--)
            {
                if(arr[i][j] < prev)
                {
                  //  System.ou.println(i+" "+arr[i][j]);
                    sum+=arr[i][j];
                    prev = arr[i][j];
                    f = true;
                    break;
                }
            }
            if(f == false)
            {
                return 0;
            }
        }
        return (int)sum;
    }
    
    
}





