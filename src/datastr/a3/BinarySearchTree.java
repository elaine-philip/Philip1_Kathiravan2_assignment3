package datastr.a3;

public class BinarySearchTree<T extends Comparable<T>> {

    private NodeType<T> root;

    public BinarySearchTree() {
        root = null;
    } // default constructor

    public void insert(T key) {
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
    } // insert
    // ADD DUP CHECK AFTER SEARCH


    public void deleteNode(T item) {

    } // deleteNode


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
