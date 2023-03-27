package datastr.a3;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class BinarySearchTreeDriver {
    public static void main(String[] args) {
        try {

            System.out.print("Enter list type (i - int, d - double, s - string): ");
            Scanner scanType = new Scanner(System.in);
            String listType = scanType.next();

            boolean isInt = false;
            boolean isDouble = false;
            boolean isString = false;


            if (listType.equals("i")) {
                isInt = true;
            } else if (listType.equals("d")) {
                isDouble = true;
            } else if (listType.equals("s")) {
                isString = true;
            } // if
            // finds data type from user

            File fileName = new File(args[0]);
            Scanner scan = new Scanner(fileName);

            BinarySearchTree<Integer> listI = new BinarySearchTree<Integer>();
            BinarySearchTree<Double> listD = new BinarySearchTree<Double>();
            BinarySearchTree<String> listS = new BinarySearchTree<String>();

            if (isInt) {
                while(scan.hasNextInt()) {
                    int itemInt = scan.nextInt();
                    listI.insert(itemInt);
                } // while
            } else if (isDouble) {
                while(scan.hasNextDouble()) {
                    double itemDouble = scan.nextDouble();
                    listD.insert(itemDouble);
                } // while
            } else if (isString) {
                while(scan.hasNext()) {
                    String itemString = scan.next();
                    listS.insert(itemString);
                } // while
            } // if
            // adds values from input file to list



            String command = "";
            System.out.print("Enter a command: ");

            while (!command.equals("q")) {
                boolean invalid = false;
                Scanner scanCom  = new Scanner(System.in);
                command = scanCom.next();
                // user input

                if (command.equals("p")) {
                    if (isInt) {
                        listI.inOrder();
                    } else if (isDouble) {
                        listD.inOrder();
                    } else if (isString) {
                        listS.inOrder();
                    } // if
                    // prints list
                } else if (command.equals("i")) {
                    if (isInt) {
                        listI.inOrder();
                        System.out.print("Enter a number to insert: ");
                        scanCom = new Scanner(System.in);
                        int val = scanCom.nextInt();
                        listI.insert(val);
                        listI.inOrder();
                    } else if (isDouble) {
                        listD.inOrder();
                        System.out.print("Enter a number to insert: ");
                        scanCom = new Scanner(System.in);
                        double val = scanCom.nextDouble();
                        listD.insert(val);
                        listD.inOrder();
                    } else if (isString) {
                        listS.inOrder();
                        System.out.print("Enter a string to insert: ");
                        scanCom = new Scanner(System.in);
                        String val = scanCom.next();
                        listS.insert(val);
                        listS.inOrder();
                    } // if
                    // prints in-order tree, inserts item, and prints new tree
                } else if (command.equals("r")) {
                    if (isInt) {
                        listI.inOrder();
                        System.out.print("Enter a number to search: ");
                        scanCom = new Scanner(System.in);
                        int val = scanCom.nextInt();
                        listI.retrieve(val);
                    } else if (isDouble) {
                        listD.inOrder();
                        System.out.print("Enter a number to search: ");
                        scanCom = new Scanner(System.in);
                        double val = scanCom.nextDouble();
                        listD.retrieve(val);
                     } else if (isString) {
                        listS.inOrder();
                        System.out.print("Enter a string to search: ");
                        scanCom = new Scanner(System.in);
                        String val = scanCom.next();
                        listS.retrieve(val);
                     } // if

/**
                } else if (command.equals("l")) {
                    System.out.print("The length of the list is ");
                    if (isInt) {
                        System.out.println(listI.length());
                    } else if (isDouble) {
                        System.out.println(listD.length());
                    } else if (isString) {
                        System.out.println(listS.length());
                    } // if
               } else if (command.equals("d")) {
                    System.out.print("The list is : ");

                    if (isInt) {
                        listI.print();
                        System.out.print("Enter a number to delete: ");
                        scanCom = new Scanner(System.in);
                        int val = scanCom.nextInt();
                        listI.deleteItem(val);
                        System.out.print("The list is : ");
                        listI.print();
                        listI.printReverse();
                    } else if (isDouble) {
                        listD.print();
                        System.out.print("Enter a number to delete: ");
                        scanCom = new Scanner(System.in);
                        double val = scanCom.nextDouble();
                        listD.deleteItem(val);
                        System.out.print("The list is : ");
                        listD.print();
                        listD.printReverse();
                    } else if (isString) {
                        listS.print();
                        System.out.print("Enter a number to delete: ");
                        scanCom = new Scanner(System.in);
                        String val = scanCom.next();
                        listS.deleteItem(val);
                        System.out.print("The list is : ");
                        listS.print();
                        listS.printReverse();
                    } // if
                    // prints original list, deletes item, and prints new list
                } else if (command.equals("r")) {
                    System.out.print("The original list: ");
                    if (isInt) {
                        listI.print();
                        System.out.print("The reversed list: ");
                        listI.reverseList();
                        listI.print();
                    } else if (isDouble) {
                        listD.print();
                        System.out.print("The reversed list: ");
                        listD.reverseList();
                        listD.print();
                    } else if (isString) {
                        listS.print();
                        System.out.print("The reversed list: ");
                        listS.reverseList();
                        listS.print();
                    } // if
                } else if (command.equals("t")) {

                    if (isInt) {
                        listI.printReverse();
                    } else if (isDouble) {
                        listD.printReverse();
                    } else if (isString) {
                        listS.printReverse();
                    } // if
            */
                } else if (command.equals("q")) {
                    System.out.println("Exiting the program...");
                    System.exit(0);
                } else {
                    invalid = true;
                } // if
                // all command cases

                if (invalid) {
                    System.out.print("Invalid command, try again: ");
                } else if (!command.equals("q")){
                    System.out.print("Enter a command: ");
                } // if
                //prompting user

            } // while
            // loop to prompt user




        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found");
        } // try
    } // main
} // LinkedListDriver
