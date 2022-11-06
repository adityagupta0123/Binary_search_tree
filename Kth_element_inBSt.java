class Solution {
    public int kthSmallest(TreeNode root, int k) {
       ArrayList<Integer> inorder = new ArrayList<>();
       Inorder(root, inorder);
       return inorder.get(k - 1); 

    }
    public void Inorder(TreeNode root, ArrayList<Integer> inorder){
        if( root == null)
           return ;
        Inorder(root.left, inorder);
        inorder.add(root.val);
        Inorder(root.right, inorder);
    }
   
}
