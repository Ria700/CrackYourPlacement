/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "n"; // need to mark null
        }
        
        StringBuilder ans = new StringBuilder();
        ans.append(root.val+" ");
        ans.append(serialize(root.left));
        ans.append(" ");
        ans.append(serialize(root.right));
        return ans.toString();
    }
    
    // Decodes your encoded data to tree.
    int i;
    public TreeNode deserialize(String data) {
        String arr[] = data.split(" ");
        i = 0;
        
        return deserializeHelper(arr);
    }
    
    public TreeNode deserializeHelper(String[] arr) {
        if(i >= arr.length) return null;
        
        if(arr[i].equals("n")){
            i++;
            return null;
        } 
        
        int val = Integer.parseInt(arr[i++]);
        TreeNode root = new TreeNode(val);
        root.left = deserializeHelper(arr);
        root.right = deserializeHelper(arr);
        return root;
    }
    
    
    
    
    
//     public String preorder(TreeNode root){
        
//     }

//     class Pair{
//         TreeNode node;
//         int state;
        
//         public Pair(TreeNode a, int b){
//             node = a;
//             state = b;
//         }
        
//     }
    
    // deserialize(data, 0, data.length()-1);
//     Stack<Pair> stack = new Stack<>();
//         stack.push(new  Pair(data.charAt(0), 0));
//         int i = 1;
//         while(i < data.length()){
//             Pair top = stack.peek();
//             if(top.state == 0){
//                 stack.push(new Pair(new TreeNode(data.charAt(i)), 0))

//             }
//         }
    
    // public TreeNode deserialize(String data, int si, int ei) {
    //     if(si>ei) return null;
    //     TreeNode root = new TreeNode(data.charAt(0));
    //     root.left = deserialize(data, si+1, )
    // }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));