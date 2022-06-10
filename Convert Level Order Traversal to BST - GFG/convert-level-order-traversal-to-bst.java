// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java


class GFG 
{
    class Meta{
        int min, max;
        Node parent;
        
        public Meta(int a, int b, Node c){
            min = a;
            max = b;
            parent = c;
        }
    }
    //Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] arr)
    {
        //Write your code here 
        Queue<Meta> q = new LinkedList<>();
        Node root = null;
        int i = 0;
        q.add(new Meta(Integer.MIN_VALUE, Integer.MAX_VALUE, null));
        
        while(i < arr.length && q.size() > 0){
            Meta fn = q.remove();
            if(arr[i] > fn.min && arr[i] < fn.max){
                Node node = new Node(arr[i]);
                if(fn.parent == null) root = node;
                else if(node.data < fn.parent.data)
                    fn.parent.left = node;
                else
                    fn.parent.right = node;
                    
                q.add(new Meta(fn.min, node.data, node));
                q.add(new Meta(node.data, fn.max, node));
                
                i++;
            }
        }
        return root;
    }
}