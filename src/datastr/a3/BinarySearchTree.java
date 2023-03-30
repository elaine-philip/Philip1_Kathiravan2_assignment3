package datastr.a3;

public class BinarySearchTree<T extends Comparable<T>> {

    private NodeType<T> root;
    private int levelCount;
    T sibling = null;

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
    // empty check?

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

    public boolean isPresent(T key) {
        return search(root,key);
    } // isPresent

    public void delete(T key) {
        NodeType<T> curr = root;
        NodeType<T> parent = null;
        boolean isLChild = false;

        // traverse tree to find node w the right key
        while (curr != null) {
            int comp = key.compareTo(curr.info);

            if (comp == 0) {
                // key acquired, check and handle delete cases

                if (curr.left == null && curr.right == null) {
                    // case 1 - leaf node, simply remove
                    if (parent == null) {
                        root = null;
                    } else if (isLChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else if (curr.left == null) {
                    // case 2 - no left child, replace w right
                    if (parent == null) {
                        root = curr.right;
                    } else if (isLChild) {
                        parent.left = curr.right;
                    } else {
                        parent.right = curr.right;
                    }
                } else if (curr.right == null) {
                    // case 3 - no right child, replace w left
                    if (parent == null) {
                        root = curr.left;
                    } else if (isLChild) {
                        parent.left = curr.left;
                    } else {
                        parent.right = curr.left;
                    }
                } else {
                    // case 4 - node has two children, replace w pre or suc
                    NodeType<T> successor = curr.right;
                    NodeType<T> successorParent = curr;

                    while (successor.left != null) {
                        successorParent = successor;
                        successor = successor.left;
                    } // while

                    curr.info = successor.info;

                    if (successorParent.left == successor) {
                        successorParent.left = successor.right;
                    } else {
                        successorParent.right = successor.right;
                    }
                }

                return;
            } else if (comp < 0) {
                parent = curr;
                curr = curr.left;
                isLChild = true;
            } else {
                parent = curr;
                curr = curr.right;
                isLChild = false;
            } // if
        } // while
    } // delete


    public int getNumLeafNodes(NodeType<T> root) {
        if (root == null) {
            return 0;
        } // if
        if (root.left == null && root.right == null) {
            return 1;
        } // if
        return getNumLeafNodes(root.left) + getNumLeafNodes(root.right);
    } // getNumLeafNodes

    public int countOfNumLeafNodes() {
        return getNumLeafNodes(root);
    }

}
