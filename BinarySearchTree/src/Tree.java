
// This Tree needs to inherit BTreePrinter
public class Tree extends BTreePrinter{
    Node root;

    public Tree(Node root){
        this.root = root;
    }
    
    public Tree(){} // Dummy constructor (No need to edit)

    //visualize tree
    public void printTree(){
        //check if empty-tree or not
        if(this.root == null) System.out.println("Empty tree!!!");
        else super.printTree(this.root); //inherit from superclass
    }
    
    public static void printNode(Node node){
        if(node == null) System.out.println("Node not found!!!");
        else System.out.println(node.key);
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
        //if empty-tree
        if(this.root == null){
            //insert new node as root
            this.root = new Node(key);
        }
        Node leafNode = findClosestLeaf(this.root, key);
        //if the key is duplicate --> exit function
        if(leafNode.key == key) return;
        //unique key
        else{
            //if new key is less than leaf key --> hang new node to the left side
            if(key < leafNode.key){
                leafNode.left = new Node(key);
                leafNode.left.parent = leafNode;
            }
            //new key is more than leaf key --> hang new node to the right side
            else{
                leafNode.right = new Node(key);
                leafNode.right.parent = leafNode;
            }
        }
    }
    
    public void printPreOrderDFT(){
        System.out.print("PreOrder DFT node sequence [ ");
        // Call the recursive version
        printPreOrderDFT(this.root);
        
        System.out.println("]");
    }
    
    public static void printPreOrderDFT(Node node){
        // this function should be recursive   
        if(node == null) return;
        else{
            System.out.print(node.key + " ");
            printPreOrderDFT(node.left);
            printPreOrderDFT(node.right);
        }
    }
    
    public void printInOrderDFT(){
        System.out.print("InOrder DFT node sequence [ ");
        // Call the recursive version
        printInOrderDFT(this.root);
        System.out.println("]");
    }
    
    public static void printInOrderDFT(Node node){
        // this function should be recursive  
        if(node == null) return;
        else{
            printInOrderDFT(node.left);
            System.out.print(node.key + " ");
            printInOrderDFT(node.right);
        }
    }
    
    public void printPostOrderDFT(){
        System.out.print("PostOrder DFT node sequence [ ");
        // Call the recursive version
        printPostOrderDFT(this.root);
        System.out.println("]");
    }
    
    public static void printPostOrderDFT(Node node){
        // this function should be recursive 
        if(node == null) return;
        else{
            printPostOrderDFT(node.left);
            printPostOrderDFT(node.right);
            System.out.print(node.key + " ");
        }
    }
    
    public static int height(Node node){
        // Use recursion to implement this function
        // height = length(path{node->deepest child})
        // return -2;
        if(node == null) return -1;
        else{
            int heightLeft = height(node.left);
            int heightRight = height(node.right);
            int maxHeight = Math.max(heightLeft, heightRight);
            return maxHeight + 1;
        }
    }
    
    public static int size(Node node){
        // Use recursion to implement this function
        // size = #children + 1(itself)
        if(node == null) return 0;
        else{
            int sizeLeft = size(node.left);
            int sizeRight = size(node.right);
            int treeSize = sizeLeft + sizeRight + 1;//1 is node itself
            return treeSize;
        }
    }
    
    public static int depth(Node root, Node node){
        // Use recursion to implement this function
        // Similar to height() but start from node, go up to root
        // depth = length(path{node->root})
        if(node == null) return -1;//base case
        if(node == root) return 0;
        else{
            int length = depth(root, node.parent);//recursive up till root node
            return length + 1;
        }

    }
    
    public int height(){ // Tree height
        // Hint: call the static function
        if(this.root == null) return -1;
        else return height(this.root);
    }
    
    public int size(){ // Tree size
        // Hint: call the static function
        if(this.root == null) return 0;
        else return size(this.root);
    }
    
    public int depth(){ // Tree depth
        // Hint: call the static function
        if(this.root == null) return -1;
        else return height(this.root);
    }
    
    public Node findKthSmallest(int k){
        if(this.root == null) return null;
        else return findKthSmallest(this.root, k); // Call the recursive version
    }
    
    public static Node findKthSmallest(Node node, int k){
        // this function should be recursive
        if(node == null) return null; //base case, beyond smallest node
        int size_left = size(node.left); //find size of left-subtree
        if(k == size_left + 1) return node; //found k-th node
        //k-th node is in left-subtree --> recursive left-subtree
        else if(k < size_left + 1) return findKthSmallest(node.left, k);
        //k-th node is in right-subtree --> recursive right-subtree
        else return findKthSmallest(node.right, k - size_left - 1);
        
    }
    
    public static Node findNext(Node node){
        //this function should call other functions
        //if node have right child --> leftDescendant(right-subtree)
        if(node.right != null) return leftDescendant(node.right);
        //if node don't have right child --> rightAncestor(node)
        else return rightAncestor(node);
    }
    
    public static Node leftDescendant(Node node){// Case 1 (findMin)
        // this function should be recursive
        //found Min of right-subtree --> return node
        if(node.left == null) return node;
        //not found yet --> continue recursive
        else return leftDescendant(node.left);
    }
    
    public static Node rightAncestor(Node node) {// Case 1 (first right parent)
        // this function should be recursive
        //node == root --> return null
        if(node.parent == null) return null;
        //found right ancestor --> return right ancestor
        if(node.key < node.parent.key) return node.parent;
        //not found yet --> continue recursive
        else return rightAncestor(node.parent);
    }
    
    public List rangeSearch(int x, int y){
        // This function utilizes findClosest() and findNext()
        // Use list.append(node) to add node to the list
        List list = new List(Math.abs(x) + Math.abs(y));
        //starter node 
        Node current = findClosest(x);
        //run till we reach y
        while(current.key <= y){
            //current.key is in range --> append to list
            if(current.key >= x) list.append(current);
            //current = current.next
            current = findNext(current);
            //if current is the right most node, findNext will return null
            //findNext return null --> escape loop
            if(current == null) break;
        }
        return list;
    }
            
    // This function is for deleting the root node
    // If the node is not the root, please call the recursive version
    public void delete(int key) {
        // There should be 6 cases here
        // Non-root nodes should be forwarded to the static function

        //if empty-tree
        if(this.root == null) System.out.println("Empty Tree!!!");
        //key isn't exist in tree
        else if(find(this.root, key) == null) System.out.println("Key not found!!!");
        //key exist in tree
        else{
            //check if node that we want to delete is root node or not
            //node that we want to delete is root node --> no child, single child, 2 child
            if(this.root.key == key){
                //root have no child --> root = null
                if(this.root.left == null && this.root.right == null){
                    this.root = null;
                //root only have left child --> replace root with its left child
                }else if(this.root.left != null && this.root.right == null){
                    Node oldRoot = this.root;
                    this.root = this.root.left;
                    this.root.parent = null;
                    oldRoot.left = null;
                //root only have right child --> replace root with its right child
                }else if(this.root.right != null && this.root.left == null){
                    Node oldNode = this.root;
                    this.root = this.root.right;
                    this.root.parent = null;
                    oldNode.right = null;
                //root have both child --> replace root's data with min of right-subtree data
                }else{
                    Node minRightSubTree = findMin(this.root.right);
                    this.root.key = minRightSubTree.key;
                    delete(minRightSubTree); //delete with recursive
                }
            }
            else{//node that we want to delete isn't root node, call recursive version
                delete(find(this.root, key));
            }
        }
    }

    // Use this function to delete non-root nodes
    public static void delete(Node node){
        // There should be 7 cases here
        //node don't have a child --> delete node --> 2 cases
        if(node.left == null && node.right == null){
            //node is left child
            if(node.parent.left == node){
                Node parentNode = node.parent;
                node.parent = null;
                parentNode.left = null;
            //node is right child
            }else{
                Node parentNode = node.parent;
                node.parent = null;
                parentNode.right = null;
            }
        //node have both child --> replace node's data with min of right-subtree data
        }else if(node.left != null && node.right != null){
            Node minRightSubTree = findMin(node.right);
            node.key = minRightSubTree.key;
            delete(findMin(node.right)); //delete with recursive
        //node have single child --> replace node with its child --> 4 cases
        }else{
            Node parentNode = node.parent;
            if(parentNode.left == node && node.left != null){
                parentNode.left = node.left;                //           parentNode
                node.left.parent = parentNode;              //      node/
                node.parent = null;                         //     /
                node.left = null;                           // child
            }else if(parentNode.left == node && node.right != null){
                parentNode.left = node.right;               //          parentNode
                node.right.parent = parentNode;             //     node/
                node.parent = null;                         //         \
                node.right = null;                          //          child
            }else if(parentNode.right == node && node.left != null){
                parentNode.right = node.left;               //     parentNode
                node.left.parent = parentNode;              //               \node
                node.parent = null;                         //               /
                node.left = null;                           //           child
            }else if(parentNode.right == node && node.right != null){
                parentNode.right = node.right;              //      parentNode
                node.right.parent = parentNode;             //                \node
                node.parent = null;                         //                     \
                node.right = null;                          //                      child
            }
        }
    }
}

