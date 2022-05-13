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
    int isSame(String str) {
        // code here
        int n = str.length();
 
        // Traverse string from end and find the number
        // stored at the end.
        // x is used to store power of 10.
        int num = 0, x = 1, i = n - 1;
        for (i = n - 1; i >= 0; i--)
        {
            // if number
            if ('0' <= str.charAt(i) &&
                str.charAt(i) <= '9')
            {
                num = (str.charAt(i) - '0') * x + num;
                x = x * 10;
                if(num>=n)
                    return 0;
            }
            // break on first character
            else
                break;
        }
 
        // Check if number is equal to string
        // length except that number's digits
        if(num == i + 1) return 1;
        return 0;
    }
}