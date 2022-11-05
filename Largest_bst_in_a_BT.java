
class Solution{
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size  = size;
            this.min   = min;
            this.max   = max;
        }
    }
    public static int maxBST = 0;
    public static Info l_BST(Node root){
        if ( root == null)
           return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    
        Info leftInfo = l_BST(root.left);
        Info rightInfo = l_BST(root.right);
        
        int size = leftInfo.size + rightInfo.size + 1 ;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.min, rightInfo.max));
        
        if( root.data <= leftInfo.max || root.data >= rightInfo.min)
             return new Info(false, size, min, max);
        if( leftInfo.isBST && rightInfo.isBST ) {
            maxBST = Math.max(maxBST, size);
            return new Info (true, size, min, max);
        }
        return new Info(false , size , min , max);
    }
    static int largestBst(Node root)
    {
        Info info  = l_BST(root);
        return maxBST;
    }
    
}
