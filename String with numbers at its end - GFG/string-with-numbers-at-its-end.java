// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            
            Solution ob = new Solution();
            int result = ob.isSame(s);
            
            System.out.println(result);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int isSame(String s) {
        // code here
        int n = s.length();
        int num = 0;
        int len = n;
        for(int i = n-1; i > 0; i--){
            num = num + Integer.parseInt(s.charAt(i)+"")*(int)Math.pow(10, n-i-1);
            len--;
            if(num == len){
                if(s.charAt(i-1) >= '0' && s.charAt(i-1) <= '9')
                    continue;
                return 1;
            }
            if(num > n) break;
        }
        
        return 0;
    }
}