
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

    public static void printNode(Node node){
        if(node == null) System.out.println("Node not found!!!");
        else System.out.println(node.key);
    }
        
    public Node find(int search_key){
        return find(this.root, search_key); // Call the recursive version
    }
    
    public static Node find(Node node, int search_key){
        // this function should be recursive
        // You should check null in this function
        Node foundNode = new Node(0);
        if(node == null) {
            //System.out.println("Node not found!!!");
            return null;
        }
        if(search_key == node.key) foundNode = node;
        else if(search_key < node.key){
            return find(node.left, search_key);
        }else if(search_key > node.key){
            return find(node.right, search_key);
        }
        return foundNode;
    }
    
    
    public Node findMin(){
        return findMin(this.root); // Call the recursive version
    }
    
    public static Node findMin(Node node){
        // this function should be recursive
        if(node == null) return null;
        
        Node foundMin = new Node(0);
        if(node.left == null) foundMin = node;
        else{
            return findMin(node.left);
        }
        return foundMin;
    }
    
    public Node findMax(){
        return findMax(this.root); // Call the recursive version
    }
    
    public static Node findMax(Node node){
        // this function should be recursive
        if(node == null) return null;
        Node foundMax = new Node(0);
        if(node.right == null) foundMax = node;
        else{
            return findMax(node.right);
        }
        return foundMax;
    }
    
    public Node findClosestLeaf(int search_key){
        return findClosestLeaf(this.root, search_key); // Call the recursive version
    }
    
    public static Node findClosestLeaf(Node node, int search_key){
        // this function should be recursive
        if(node == null) return null;

        Node closestNode = new Node(0);
        if(search_key == node.key) closestNode = node;
        else if(search_key < node.key){
            if(node.left == null) closestNode = node;
            else return findClosestLeaf(node.left, search_key);
        }else if(search_key > node.key){
            if(node.right == null) closestNode = node;
            else return findClosestLeaf(node.right, search_key);
        }

        return closestNode;

    }
    
    public Node findClosest(int search_key){
        // Please use while loop to implement this function
        // Try not to use recursion
        
        Node current, closest;
        closest = current = root;
        int min_diff = Integer.MAX_VALUE;
        
        // Use while loop to traverse from root to the closest leaf
        
        return closest;
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
        
        System.out.println("]");
    }
    
    public static void printPreOrderDFT(Node node){
        // this function should be recursive   
    }
    
    public void printInOrderDFT(){
        System.out.print("InOrder DFT node sequence [ ");
        // Call the recursive version
        System.out.println("]");
    }
    
    public static void printInOrderDFT(Node node){
        // this function should be recursive  
    }
    
    public void printPostOrderDFT(){
        System.out.print("PostOrder DFT node sequence [ ");
        // Call the recursive version
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

