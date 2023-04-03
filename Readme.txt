Elaine Philip(emp49872@uga.edu):

Contribution - Created and implemented insert, retrieve, inOrder, and getCousins
     function and all helper methods for those functions. Implemented code in
     Driver class for execution of the previously listed functions I created
     in BinarySearchTree class.

getCousins()-

    Pseudo Code: The getCousins() functions initalizes the instance variables used to 0/null and then calls the
     getSiblings() method. This method first loops through the tree until it finds the node in the parameter and
     assigns the parent of that node to the parent variable. Then it checks if the parent has a right or left child
     that isn't the parameter node and assigns that child to the sibling variable. Then the getCousins method calls the
     levNum() method which finds the level of the user inputed node. levNum searches through the tree recursivley with
     the item = node as the base case and continuing down the tree with the left or right child depending on the item
     as the recursive case. For each recurisve call the instance vairbale levelCount is increased by 1 so we know what
     level the item is at and returns true if present and false is not present. Then getCousins calls the levelOrder()
     method which traverses through the tree recursivley until it reaches the levelCount level. Then it checks that the
     tree isn't equal to the key or the sibling and if so prints it.


    levNum: T(n) = T(n/2) + 1
    Master Therom:
    a = 1, b = 2, d = 0
    1 = 2^0
    0(log(n))

    levOrder: T(n) = T(n-1) + 1
    Master Theorm:
    a = 1, b = 1, d = 0
    1 = 1
    O(n)

    Big O: getSibling is O(log(n)), levNum is O(log(n)), and levelOrder is O(n). So the getCousin is O(n).



Kavya Kathiravan(krk08454@uga.edu):

Contribution - Created and implemented delete, getNumLeafNodes, getSingleParent, and
    all helper methods for those functions including isPresent, countOfNumLeafNodes,
    and outSingleParent. Implemented code in the Driver class for execution of the
    previously listed functions that I created in BinarySearchTree class.

getNumLeafNodes(): The getNumLeafNodes function takes a root node of a BST as input and returns
the number of leaf nodes in the tree. The function first checks if the root node is null, if it is,
it returns 0. Then it checks if the root node is a leaf node, in which case it returns 1. Otherwise,
it recursively calls getNumLeafNodes on the left and right children of the root node and returns the
sum of the results.

Big O: O(n)
The time complexity of the getNumLeafNodes is O(n), where n is the number of nodes in the
tree rooted at the input root node. This is because the function visits each node in the tree once,
performs constant-time operations at each node, and makes recursive calls to itself on its left and
right children.

Recurrence Relation: T(n) = 2T(n/2) + c if n > 1

Master Method:
    a = 2, b = 2, and f(n) = 1
    log_b(a) = log_2(2) = 1, and f(n) = O(n^0) = O(1)
    f(n) = O(n^c) for some constant c, which is less than or equal to 0
    T(n) = O(n^log_b(a)) = O(n^1) = O(n)

getSingleParents(): The getSingleParent function takes a node as input and prints out the values of
nodes that have only one child. First it checks if the input node is null and returns if it is. It
then checks if the node has exactly one child, and if so, the function prints the value of the node.
Lastly, it recursively calls itself on the left and right children of the input node.

Big O: O(n)
The time complexity of getSingleParent is O(n), where n is the number of nodes in the binary tree.
This is because the function visits each node in the tree exactly once and performs a constant amount
of work at each node. Therefore, the time taken by the function is proportional to the number of nodes
in the tree.

Recurrence Relation: T(n) = 2T(n/2) + O(1) [O(1) is the constant amount of work performed at each node]

Master Method:
    a = 2, b = 2, and f(n) = O(1)
    logb(a) = log2(2) = 1
    O(n log n)
    Since f(n) = O(1) is a constant function, the expression can be simplified to O(n).

How to Compile: javac -cp bin/ -d bin/ src/datastr/a3/NodeType.java
                javac -cp bin/ -d bin/ src/datastr/a3/BinarySearchTree.java
                javac -cp bin/ -d bin/ src/datastr/a3/BinarySearchTreeDriver.java

How to Run:     java -cp bin/ src/datastr/a3/BinarySearchTreeDriver.java [add input file at end] (ex: int-input.txt)
