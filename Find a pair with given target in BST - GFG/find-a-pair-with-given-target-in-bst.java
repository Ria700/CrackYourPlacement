// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            int target = Integer.parseInt(br.readLine().trim());
            
            Solution T = new Solution();
            System.out.println(T.isPairPresent(root,target));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // root : the root Node of the given BST
    // target : the target sum
    // M-3: Iterative inorder
    class pair{
        Node node;
        int state;
        
        pair(Node a, int b){
            node = a;
            state = b;
        }
    }
    
    public int isPairPresent(Node root, int target)
    {
        // Write your code here
        Stack<pair> ls = new Stack<>();
        Stack<pair> rs = new Stack<>();
        
        ls.add(new pair(root, 0));
        rs.add(new pair(root, 0));
        
        Node left = getNextIterInorder(ls);
        Node right = getNexReverseIterInorder(rs);
        while(left.data < right.data){
            int sum = left.data+right.data;
            if(sum == target) return 1;
            else if(sum < target) left = getNextIterInorder(ls);
            else right = getNexReverseIterInorder(rs);
        }
        return 0;
    }
    
    private Node getNextIterInorder(Stack<pair> s){
        while(s.size() > 0){
            pair top = s.peek();
            if(top.state == 0){
                if(top.node.left!= null) s.add(new pair(top.node.left, 0));
                top.state++;
            }else if(top.state == 1){
                if(top.node.right!= null) s.add(new pair(top.node.right, 0));
                top.state++;
                return top.node;
            }else s.pop();
        }
        return null;
    }
    
    private Node getNexReverseIterInorder(Stack<pair> s){
        while(s.size() > 0){
            pair top = s.pop();
            if(top.node == null) continue;
            if(top.state == 0){
                s.add(new pair(top.node, top.state+1));
                s.add(new pair(top.node.right, 0));
            }else if(top.state == 1){
                s.add(new pair(top.node, top.state+1));
                s.add(new pair(top.node.left, 0));
                return top.node;
            }
        }
        return null;
    }
}
