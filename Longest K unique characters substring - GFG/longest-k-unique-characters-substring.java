// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, max = -1;
        while(j < s.length()){
            char c = s.charAt(j); 
            map.put(c, map.getOrDefault(c, 0)+1);
            j++;
            
            if(map.size() == k){
                // an answer found
                if(j-i > max){
                    max = j-i;
                }
                if(j == s.length()) break;
            }else{
                while(map.size() > k){
                    char ch = s.charAt(i);
                    map.put(ch, map.get(ch)-1);
                    if(map.get(ch) == 0) map.remove(ch);
                    i++;
                }
            }
        }

        return max;
    }
}