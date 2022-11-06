class Solution{
    static int min_diff, min_diff_key;
    static int minDiff(Node  root, int k){
   
    min_diff = Integer.MAX_VALUE; min_diff_key = -1;
  
    maxDiffUtil(root, k);
  
    return Math.abs(k - min_diff_key);
  }
    
   static void maxDiffUtil(Node  root, int k){
        if (root == null)
           return ;
        
        if (root.data == k){
           min_diff_key = k;
           return;
        }
  
        if (min_diff > Math.abs(root.data - k)){
           min_diff = Math.abs(root.data - k);
           min_diff_key = root.data;
        }
  
        if (k < root.data)
           maxDiffUtil(root.left, k);
        else
           maxDiffUtil(root.right, k);
    }
 
}
