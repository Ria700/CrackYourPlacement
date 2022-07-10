// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        int ans = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(char c : pat.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        count = map.size();
        
        int k = pat.length(), size = txt.length(), i = 0, j = 0;
        while(j < size){
            char c = txt.charAt(j);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) count--;
            }
            
            if(j < k-1) j++;
            else{
                // cal ans
                if(count == 0){
                    ans++;
                }
                
                // slide the window
                char c2 = txt.charAt(i);
                if(map.containsKey(c2)){
                    if(map.get(c2) == 0) count++;
                    map.put(c2, map.get(c2)+1);
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}