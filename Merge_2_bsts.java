class Solution
{
    public List<Integer> merge(Node root1,Node root2)
    {
        //step 1
        ArrayList <Integer> arr1 = new ArrayList<>();
        getInorder( root1 ,arr1);

        // step 2
        ArrayList <Integer> arr2 = new ArrayList<>();
        getInorder( root2 ,arr2);

        //merge
        int i = 0, j = 0;
        ArrayList <Integer> finalarr = new ArrayList<>();
        while( i < arr1.size() && j < arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                finalarr.add(arr1.get(i));
                i++;
            }else {
                finalarr.add(arr2.get(j));
                j++;
            }
        } 
        while( i < arr1.size()){
             finalarr.add(arr1.get(i));
                i++;            
        }
        while( j < arr2.size()){
            finalarr.add(arr2.get(j));
            j++;
        }
        createBst(finalarr, 0 , finalarr.size() - 1);
        return finalarr;
    }
    public void getInorder(Node root, ArrayList<Integer> arr){
        if( root == null)
           return ;
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }
    public Node createBst(ArrayList<Integer> arr, int l, int r){
        if( l > r)
           return null;
        int mid = ( l + r )/2;
        Node root = new Node(arr.get(mid));
        root.left = createBst(arr, l , mid - 1);
        root.right = createBst(arr, mid + 1, r);

        return root;
    }
    
}
