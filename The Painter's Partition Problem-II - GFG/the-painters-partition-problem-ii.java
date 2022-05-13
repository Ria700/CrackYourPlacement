// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

 class Solution{
    static long minTime(int[] arr,int n,int k){
        //code here
        long l = 0, h = 0;
        for(int i: arr){
            h += i;
            if(i > l){
                l = i;
            }
        }
        
        while(l<h){
            long mid = l + (h-l)/2;
            
            // cal pieces
            long sum = 0, pieces = 0;
            for(int i: arr){
                if(sum+i > mid){
                    sum = i;
                    pieces++;
                }else{
                    sum += i;
                }
            }
            
            if(pieces < k){
                h = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}


