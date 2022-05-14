// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        int l = 0, h = 0;
        for(int i: A){
            h += i;
            if(i > l) l = i;
        }
        
        while(l < h){
            int mid = l + (h - l)/2;
            
            int pieces = 0, sum = 0;
            for(int i: A){
                if(sum + i > mid){
                    sum = i;
                    pieces++;
                }else{
                    sum+=i;
                }
            }
            
            if(pieces < M){
                h = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
};