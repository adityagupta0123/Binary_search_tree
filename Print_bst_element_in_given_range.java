class Solution
{   
    //Function to return a list of BST elements in a given range.
	public static ArrayList<Integer> printNearNodes(Node root,int low,int high) {
	    ArrayList<Integer> rs = new ArrayList<Integer>();
        helper(root, low, high, rs);
        return rs;
    }
    public static void helper(Node root, int l, int h, ArrayList<Integer> rs){
         if(root == null)
           return;
         helper(root.left,l,h,rs);
         if(root.data>=l && root.data<=h){
           rs.add(root.data);
         }
         helper(root.right,l,h, rs);
    }
    
}
