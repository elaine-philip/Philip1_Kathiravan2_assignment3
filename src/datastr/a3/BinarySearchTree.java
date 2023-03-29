package datastr.a3;

public class BinarySearchTree<T extends Comparable<T>> {

    private NodeType<T> root;

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
            return search(tree.left, item);
        } else {
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

    public void delete(T key) {
        NodeType<T> curr = root;
        NodeType<T> parent = null;
        boolean isLeftChild = false;

        // Traverse the tree to find the node with the key to delete
        while (curr != null) {
            int cmp = key.compareTo(curr.info);

            if (cmp == 0) {
                // Node with key found, handle deletion cases
                if (curr.left == null && curr.right == null) {
                    // Case 1: Node is a leaf, simply remove it
                    if (parent == null) {
                        root = null;
                    } else if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else if (curr.left == null) {
                    // Case 2: Node has no left child, replace with right child
                    if (parent == null) {
                        root = curr.right;
                    } else if (isLeftChild) {
                        parent.left = curr.right;
                    } else {
                        parent.right = curr.right;
                    }
                } else if (curr.right == null) {
                    // Case 3: Node has no right child, replace with left child
                    if (parent == null) {
                        root = curr.left;
                    } else if (isLeftChild) {
                        parent.left = curr.left;
                    } else {
                        parent.right = curr.left;
                    }
                } else {
                    // Case 4: Node has two children, replace with predecessor or successor
                    NodeType<T> successor = curr.right;
                    NodeType<T> successorParent = curr;

                    while (successor.left != null) {
                        successorParent = successor;
                        successor = successor.left;
                    }

                    curr.info = successor.info;

                    if (successorParent.left == successor) {
                        successorParent.left = successor.right;
                    } else {
                        successorParent.right = successor.right;
                    }
                }

                return;
            } else if (cmp < 0) {
                parent = curr;
                curr = curr.left;
                isLeftChild = true;
            } else {
                parent = curr;
                curr = curr.right;
            isLeftChild = false;
            } // if
        } // while
        System.out.println("Item is not present in the tree");
    }


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
