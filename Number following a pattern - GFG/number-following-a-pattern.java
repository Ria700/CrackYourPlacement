//{ Driver Code Starts
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
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S){
        // code here
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int i = 1;
        
        for(char c: S.toCharArray()) {
            stack.push(i++);
            if(c == 'I') {
                while(stack.size() > 0) sb.append(stack.pop());
            }
        }
        stack.push(i);
        while(stack.size() > 0) sb.append(stack.pop());
        return sb.toString();
    }
}
