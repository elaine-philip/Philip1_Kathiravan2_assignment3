Elaine Philip(emp49872@uga.edu):

Contribution - Created and implemented insert, retrieve, inOrder, and getCousins function and all helper methods for those functions. Implemented code in Driver class for execution of the previously listed functions I created in BinarySearchTree class.

getCousins()-

    Pseudo Code: The get cousins functions initalizes the instance variables used to 0/null and then first calls the getSiblings() method. This method first loops through the tree until it's it finds the node in the parameter and assigns the parent of that node to the parent variable. Then it checks if the parent has a right or left child that isn't the parameter node and assigns that child to the sibling variable. Then the getCousins method calls levNum() method which finds the level of the user inputed node. levNum searches through the tree recursivley with the item = node as the base case and countinuing down the tree with the left or right child depending on the item as the recursive case. For each recurisve call the insytance vairbale levelCount is icnrease by 1 so we know what level the item is at and return true if present and false is not present. Then getCousins calls the levelOrder() method which traverses through the tree recursivley until it reaches the levelCount level. Then it checks that the tree isn't equal to the key or the sibling and if so prints it.

    Big O: getSibling is O(log(n)), levNum is O(log(n)), and levelOrder is O(n). So the getCousin is O(n).





How to Compile: javac -cp bin/ -d bin/ src/datastr/a3/NodeType.java
                javac -cp bin/ -d bin/ src/datastr/a3/BinarySearchTree.java
                javac -cp bin/ -d bin/ src/datastr/a3/BinarySearchTreeDriver.java

How to Run:     java -cp bin/ src/datastr/a3/BinarySearchTreeDriver.java [add input file at end] (ex: int-input.txt)
