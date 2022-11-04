class Solution {
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList();
        helper(root, "");
        return ans;
    }
    
    private void helper(TreeNode root, String cur) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            ans.add(cur + root.val);
            return;
        }
        cur += root.val;
        cur += "->";
        helper(root.left, cur);
        helper(root.right, cur);
    }
}
