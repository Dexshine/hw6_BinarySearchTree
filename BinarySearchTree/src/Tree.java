
// This Tree needs to inherit BTreePrinter
public class Tree extends BTreePrinter{
    Node root;

    public Tree(Node root){
        this.root = root;
    }
    
    public Tree(){} // Dummy constructor (No need to edit)
    
    public void printTree(){
        if(this.root != null) super.printTree(root);
        else System.out.println("Empty tree!!!");
    }
    //visualize tree
    public static void printNode(Node node){
        //check if empty-tree or not
        if(node == null) System.out.println("Node not found!!!");
        else System.out.println(node.key);//inherit from superclass
    }
    //find search_key in BinarySearchTree
    public Node find(int search_key){
        return find(this.root, search_key); // Call the recursive version
    }
    //find search_key in BinarySearchTree (or subtree)
    public static Node find(Node node, int search_key){
        // this function should be recursive
        // You should check null in this function
        //if empty-tree or can't find search_key in tree
        if(node == null) return null;
        //create foundNode (use in return)
        Node foundNode = new Node(0);
        //check if search_key is equal, less than or more than node.key
        if(search_key == node.key) foundNode = node;
        //search_key is in the left-subtree
        else if(search_key < node.key){
            //recursive in left-subtree
            return find(node.left, search_key);
        //search_key is in the right-subtree
        }else if(search_key > node.key){
            //recursive in right-subtree
            return find(node.right, search_key);
        }
        return foundNode;
    }
    
    //find minimum key in BinarySearchTree
    public Node findMin(){
        return findMin(this.root); // Call the recursive version
    }
    //find minimum key in BinarySearchTree (or subtree)
    public static Node findMin(Node node){
        // this function should be recursive
        //check if empty-tree
        if(node == null) return null;
        
        //create foundMin (use in return)
        Node foundMin = new Node(0);
        //found the most left node in BinarySearchTree
        if(node.left == null) foundMin = node;
        //can't find the most left node yet
        else{
            //recursive in left-subtree
            return findMin(node.left);
        }
        return foundMin;
    }
    //find maximum key in BinarySearchTree
    public Node findMax(){
        return findMax(this.root); // Call the recursive version
    }
    //find maximum key in BinarySearchTree (or subtree)
    public static Node findMax(Node node){
        // this function should be recursive
        //check if empty-tree
        if(node == null) return null;
        
        //create foundMax (use in return)
        Node foundMax = new Node(0);
        //found the most right node in BinarySearchTree
        if(node.right == null) foundMax = node;
        //can't find the most right node yet
        else{
            //recursive in right-subtree
            return findMax(node.right);
        }
        return foundMax;
    }
    
    public Node findClosestLeaf(int search_key){
        return findClosestLeaf(this.root, search_key); // Call the recursive version
    }
    
    public static Node findClosestLeaf(Node node, int search_key){
        // this function should be recursive
        //check if empty-tree
        if(node == null) return null;

        //create closestLeaf (use in return)
        Node closestLeaf = node;
        if(search_key == node.key) closestLeaf = node;
        //if closestLeaf is in left-subtree
        else if(search_key < node.key){
            //if this node is leaf node --> change closestLeaf
            if(node.left == null) closestLeaf = node;
            //if this node isn't leaf node --> recursive in left-subtree
            else return findClosestLeaf(node.left, search_key);
        //if closestLeaf is in right-subtree
        }else if(search_key > node.key){
            //if this node is leaf node --> change closestLeaf
            if(node.right == null) closestLeaf = node;
            //if this node isn't leaf node --> recursive in right-subtree
            else return findClosestLeaf(node.right, search_key);
        }

        return closestLeaf;

    }
    
    public Node findClosest(int search_key){
        // Please use while loop to implement this function
        // Try not to use recursion
        
        Node currentNode, closestNode;
        currentNode = this.root;
        closestNode = null;
        int min_diff = Integer.MAX_VALUE;
        
        // Use while loop to traverse from root to the closest leaf
        while(currentNode != null){
            //use absolute to find difference between search_key and current.key
            int diffSearchAndCurrent = Math.abs(search_key - currentNode.key);
            //if we found the exact key 
            if(search_key == currentNode.key) closestNode = currentNode;
            //if closest is in left-subtree
            else if(search_key < currentNode.key){
                //if the difference is less than the min_diff
                if(diffSearchAndCurrent < min_diff){
                     //update min_diff & save current to closestNode
                    min_diff = diffSearchAndCurrent;
                    closestNode = currentNode;
                }
                currentNode = currentNode.left;
            //if closest is in right-subtree
            }else if(search_key > currentNode.key){
                //if the difference is less than the min_diff
                if(diffSearchAndCurrent < min_diff){
                    //update min_diff & save current to closestNode
                    min_diff = diffSearchAndCurrent;
                    closestNode = currentNode;
                }
                currentNode = currentNode.right;
            }
        }
        return closestNode;
    }
    
    // Implement this function using the findClosestLeaf technique
    // Do not implement the recursive function
    public void insert(int key) {
        // Implement insert() using the non-recursive version
        // This function should call findClosestLeaf()
    }
    
    public void printPreOrderDFT(){
        System.out.print("PreOrder DFT node sequence [ ");
        // Call the recursive version
        printPreOrderDFT(this.root);
        
        System.out.println("]");
    }
    
    public static void printPreOrderDFT(Node node){
        // this function should be recursive   
    }
    
    public void printInOrderDFT(){
        System.out.print("InOrder DFT node sequence [ ");
        // Call the recursive version
        printInOrderDFT(this.root);
        System.out.println("]");
    }
    
    public static void printInOrderDFT(Node node){
        // this function should be recursive  
    }
    
    public void printPostOrderDFT(){
        System.out.print("PostOrder DFT node sequence [ ");
        // Call the recursive version
        printPostOrderDFT(this.root);
        System.out.println("]");
    }
    
    public static void printPostOrderDFT(Node node){
        // this function should be recursive 
    }
    
    public static int height(Node node){
        // Use recursion to implement this function
        // height = length(path{node->deepest child})
        return -2;
    }
    
    public static int size(Node node){
        // Use recursion to implement this function
        // size = #children + 1(itself)
        return -2;
    }
    
    public static int depth(Node root, Node node){
        // Use recursion to implement this function
        // Similar to height() but start from node, go up to root
        // depth = length(path{node->root})
        return -2;

    }
    
    public int height(){ // Tree height
        // Hint: call the static function
        return -2;
    }
    
    public int size(){ // Tree size
        // Hint: call the static function
        return -2;
    }
    
    public int depth(){ // Tree depth
        // Hint: call the static function
        return -2;
    }
    
    public Node findKthSmallest(int k){
        return null; // Call the recursive version
    }
    
    public static Node findKthSmallest(Node node, int k){
        // this function should be recursive
        return null;
    }
    
    public static Node findNext(Node node){
        //this function should call other functions
        return null;
    }
    
    public static Node leftDescendant(Node node){// Case 1 (findMin)
        // this function should be recursive
        return null;
    }
    
    public static Node rightAncestor(Node node) {// Case 1 (first right parent)
        // this function should be recursive
        return null;
    }
    
    public List rangeSearch(int x, int y){
        // This function utilizes findCloest() and findNext()
        // Use List list append(node) to add node to the list
        // List is the static Array
        return new List(100);
    }
    
         
    // This function is for deleting the root node
    // If the node is not the root, please call the recursive version
    public void delete(int key) {
        // There should be 6 cases here
        // Non-root nodes should be forwarded to the static function
    }

    // Use this function to delete non-root nodes
    public static void delete(Node node){
        // There should be 7 cases here
    }
}

