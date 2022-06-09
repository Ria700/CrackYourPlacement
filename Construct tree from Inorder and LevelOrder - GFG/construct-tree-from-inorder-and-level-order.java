// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}
// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    Node buildTree(int inord[], int level[])
    {
        //your code here
        return buildTree(inord, level, 0, inord.length-1);
    }
    
    Node buildTree(int inorder[], int level[], int ii, int ij)
    {
        if(ii > ij) return null;
        
        if(ii == ij) return new Node(level[0]);
        
        Node root = new Node(level[0]);
        HashSet<Integer> set = new HashSet<>();
        int idx = -1;
        for(int i = ii; i <= ij; i++){
            if(level[0] == inorder[i]){
                idx = i;
                break;
            } 
            set.add(inorder[i]);
        }
        
        int[] levelLeft = new int[idx-ii];
        int[] levelRight = new int[ij-idx];
        int lp = 0, rp = 0;
        
        for(int i = 1; i < level.length; i++){
            // if(i == idx) continue;
            if(set.contains(level[i])){
                levelLeft[lp] = level[i];
                lp++;
            }else{
                levelRight[rp] = 
                level[i];
                rp++;
            }
        }
        
        root.left = buildTree(inorder, levelLeft, ii, idx-1);
        root.right = buildTree(inorder, levelRight, idx+1, ij);
        
        return root;
        
    }
    
   
}


