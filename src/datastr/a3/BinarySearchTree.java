package datastr.a3;

public class BinarySearchTree<T extends Comparable<T>> {

    private NodeType<T> root;
    int count = 0;

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



    public void deleteNode(T item) {

    } // deleteNode

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

    public boolean search(NodeType<T> tree, T item) {
        if (tree == null) { // not present
            return false;
        } else if (item.compareTo(tree.info) == 0) { // if present - base case
            return true;
        } else if (item.compareTo(tree.info) < 0) {
            count++;
            return search(tree.left, item);
        } else {
            count++;
            return search(tree.right, item);
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


    public void getCousins(NodeType<T> node) {

    } // getCousins


/**
    public NodeType<T> getRoot() {
        return root;
    } // getRoot

    public void print(NodeType<T> root) {
        if(root == null) {
            System.out.println("EMPTY");
            return;
        } // if

        System.out.println(root.info + " ");
        print(root.left);
        print(root.right);
    } // print

*/

}
