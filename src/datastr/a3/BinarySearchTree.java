package datastr.a3;

public class BinarySearchTree<T extends Comparable<T>> {

    private NodeType<T> root;
<<<<<<< HEAD
    int count = 0;
=======
    private int levelCount;
    T sibling = null;
>>>>>>> new-branch

    public BinarySearchTree() {
        root = null;
    } // default constructor

    public void insert(T key) {
        if (search(root, key) == true) { // duplicate check
            System.out.println("The item already exists in the tree.");
        } else {
            NodeType<T> node = new NodeType<T>();
            node.info = key;
            // create new node to insert

            if (root == null) { //empty
                root = node;
                return;
            } // if
            // make root new node if empty tree

            NodeType<T>  parent = null;
            NodeType<T> tree = root;
            while (tree != null) {
                parent = tree; // assigns parent each time
                if (tree.info.compareTo(key) > 0) {
                    tree = tree.left;
                } else {
                    tree = tree.right;
                } // if
            } // while
            // searchs through tree until finds where to insert

            if (parent.info.compareTo(key) < 0) {
                parent.right = node;
            } else {
                parent.left = node;
            } // if
            // inserts new node in correct spot
        } // if
    } // insert


    public boolean retrieve(T item) {
        boolean isPresent = search(root, item);
        System.out.println("Cousin count - " + count);
        if (isPresent == true) {
            System.out.println("Item is present in the tree");
            return true;
        } else {
            System.out.println("Item is not present in the tree");
            return false;
        } // if
    } // retrieve
    // empty check?

    public boolean search(NodeType<T> tree, T item) {
        if (tree == null) { // not present
            return false;
        } else if (item.compareTo(tree.info) == 0) { // if present - base case
            return true;
        } else if (item.compareTo(tree.info) < 0) {
<<<<<<< HEAD
            count++;
            return search(tree.left, item);
        } else {
            count++;
            return search(tree.right, item);
=======
             return search(tree.left, item);
        } else {
             return search(tree.right, item);
>>>>>>> new-branch
        } // if
    } //search

   public void inOrderPrint(NodeType<T> tree) {
        if (tree != null) { // empty check
            inOrderPrint(tree.left);
            System.out.print(tree.info);
            System.out.print(" ");
            inOrderPrint(tree.right);
        } // if
    } // inOrder

    public void inOrder() {
        System.out.print("In-order: ");
        inOrderPrint(root); // recursion call
        System.out.println("");
    } // inOrder
    // empty check?

    public boolean levNum(NodeType<T> tree, T item) {
        if (tree == null) { // not present
            return false;
        } else if (item.compareTo(tree.info) == 0) { // if present - base case
            return true;
        } else if (item.compareTo(tree.info) < 0) {
            levelCount++;
            return levNum(tree.left, item);
        } else {
            levelCount++;
            return levNum(tree.right, item);
        } // if
     } // levNum


    public void levelOrder(NodeType<T> tree, int level, T key) {
        if (tree != null) {
            if (level == 0) { // base case

                if (sibling == null) { // no siblings
                    if (tree.info.compareTo(key) != 0) {
                        System.out.print(tree.info + " ");
                    } // if
                } else {
                    if (tree.info.compareTo(key) != 0 && tree.info.compareTo(sibling) != 0) {
                        System.out.print(tree.info + " ");
                    } // if
                } // if
                // prints cousins only

            } else { // recursion
                levelOrder(tree.left, level - 1, key);
                levelOrder(tree.right, level - 1, key);
            } // if
        } // if
    } // levelOrder


    public void getCousins(T key) {
        levelCount = 0;
        sibling = null;
        getSiblings(root, key);
        levNum(root, key);
        levelOrder(root, levelCount, key);
        System.out.println("");
    } // getCousins

    public void getSiblings(NodeType<T> tree, T key) {
        while (tree != null) {
            NodeType<T> parent = null;
            if (key.compareTo(tree.info) < 0) {
                parent = tree;
                tree = tree.left;
            } else if (key.compareTo(tree.info) > 0) {
                parent = tree;
                tree = tree.right;
            } else {
                break;
            } // if
            // finds parent of key node

            if (parent.left != null) {
                if (key.compareTo(parent.left.info) == 0) { // sibling on right
                    if (parent.right != null ) { // checks if parent.right is present
                        sibling = parent.right.info;
                    } // if
                } // if
            } // if
            if (parent.right != null) {
                if (key.compareTo(parent.right.info) == 0) { // sibling on right
                    if (parent.left != null ) { // checks if parent.left is present
                        sibling = parent.left.info;
                    } // if
                } // if
            } // if
           // finds sibling

        } // while
    } // getSiblings

}
