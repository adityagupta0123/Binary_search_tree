
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        //Inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // sorted inorder
        root = createBst(inorder, 0, inorder.size() - 1);

        return root;
    }
    public void getInorder(TreeNode root, ArrayList<Integer> inorder){
        if(root == null)
           return;
        getInorder(root.left, inorder);
        inorder.add(root.val);
        getInorder(root.right, inorder);
    }
    public TreeNode createBst(ArrayList<Integer> inorder ,int l , int r){
        if( l > r)
        return null;
        int mid = ( l  + r ) / 2;
        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = createBst(inorder, l , mid-1);
        root.right = createBst(inorder, mid + 1, r );

        return root;
    }
}
