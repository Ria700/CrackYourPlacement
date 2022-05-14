// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s1 = br.readLine().trim().split(" ");
            int[] height = new int[n];
            for(int i = 0; i < n; i++){
                height[i] = Integer.parseInt(s1[i]);
            }
            String[] s2 = br.readLine().trim().split(" ");
            int[] width = new int[n];
            for(int i = 0; i < n; i++){
                width[i] = Integer.parseInt(s2[i]);
            }
            String[] s3 = br.readLine().trim().split(" ");
            int[] length = new int[n];
            for(int i = 0; i < n; i++){
                length[i] = Integer.parseInt(s3[i]);
            }
            Solution obj = new Solution();
            System.out.println(obj.maxHeight(height, width, length, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class box implements Comparable<box>{
    int h, w, l;
    int area;
    int mh;
    
    box(int h1, int w1, int l1){
        h = h1;
        w = w1;
        l = l1;
    }
    
    public int compareTo(box b){
        int area1 = this.w*this.l;
        int area2 = b.w*b.l;
        if(area1 == area2) return b.h - this.h;
        return area2 - area1; //non-inc manner
    }
}

class Solution
{
    public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        // Code here
        box arr[] = new box[3*n];
        for(int i = 0; i < n; i++){
            arr[i*3] = new box(height[i], Math.max(width[i], length[i]), Math.min(width[i], length[i]));
            arr[i*3+1] = new box(width[i], Math.max(height[i], length[i]), Math.min(height[i], length[i]));
            arr[i*3+2] = new box(length[i], Math.max(height[i], width[i]), Math.min(height[i], width[i]));
        }
        
        Arrays.sort(arr);
        
        int best = 0;

        for(int i = 0; i < arr.length; i++){
            box cur = arr[i];
            for(int p = 0; p < i; p++){
                box prv = arr[p];
                if(prv.w > cur.w && prv.l > cur.l && (prv.mh > cur.mh)){
                    cur.mh = prv.mh;
                }
            }
            
            cur.mh += cur.h;
            
            if(cur.mh > best) best = cur.mh;
        }
        
        return best;
    }
}