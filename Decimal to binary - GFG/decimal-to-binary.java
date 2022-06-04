// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-- > 0) {
			int N = sc.nextInt();
			Solution obj = new Solution();
			obj.toBinary(N);
			System.out.println();
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution{
	void toBinary(int n) {
		//Write your code here
		StringBuilder ans = new StringBuilder();
		while(n > 0){
			ans.insert(0, n%2);
			n/=2;
		}
		System.out.print(ans.toString());
	}
}