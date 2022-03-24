// { Driver Code Starts
//Initial Template for Java

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
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Complete obj = new Complete();
		    arr = obj.greaterElement(arr, sizeOfArray);
		    for(int i=0; i< sizeOfArray;i++){
		        if(arr[i] == -10000000)
		            System.out.print("_ ");
		        else
		            System.out.print(arr[i] + " ");
		    }
		    System.out.println();
		}
	}
}


// } Driver Code Ends


//User function Template for Java

//User function Template for Java

//User function Template for Java

            

class Complete{
    
   
    // Function for finding maximum and value pair
    public static int[] greaterElement (int arr[], int n) {
        // Complete the function
        int brr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            brr[i] = arr[i];
        }
        Arrays.sort(brr);
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        int prev = brr[0];
        int cur = brr[1];
        for(int i=1;i<n;i++)
        {
            cur = brr[i];
            if(cur == prev)
            {
                
            }
            else
            {
                h.put(prev,cur);
                prev = cur;
            }
        }
        
        Stack<Integer> s = new Stack<Integer>();
        int ans[] = new int[n];
        for(int i=0;i<n;i++)
        {
            if(h.containsKey(arr[i]))
            {
                ans[i] = h.get(arr[i]);
            }
            else
            {
                ans[i] = -10000000;
            }
        }
        return ans;
    }
    
    
}


