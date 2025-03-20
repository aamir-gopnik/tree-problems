import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

    Node root = null;

    static class Node{
        Node left;
        int data;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public void addDefaultData() {
        root = new Node(12);
        root.left = new Node(6);
        root.right = new Node(13);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(11);
        root.right.right = new Node(15);
    }

    /**
     * Method to build tree from user input
     * @param scanner  - Scanner will help in reading user input
     */
    public void populate(Scanner scanner){
        System.out.println("Enter the root node : ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner,root);
    }

    private void populate(Scanner scanner,Node node){
        System.out.println("Do you want to enter the left of " + node.data);
        boolean response = scanner.nextBoolean();
        if(response)
        {
            System.out.println("Enter the left value : ");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner,node.left);
        }

        System.out.println("Do you want to enter the right of " + node.data);
        boolean reply = scanner.nextBoolean();
        if(reply)
        {
            System.out.println("Enter the right value : ");
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner,node.right);
        }
    }

    public void display(){
        display(root," ");
    }

    private void display(Node node,String indent){
        if(node == null)
            return;
        System.out.println(indent + node.data);
        display(node.left,indent + "\t");
        display(node.right,indent + "\t");
    }

    /**
     * Method to switch between the Type of DFS
     * @param type - PREORDER INORDER POSTORDER
     */
    public void displayDFS(String type) {
        switch (type) {
            case "preorder" : displayPreOrder(root);
                break;
            case "postorder" : displayPostOrder(root);
                break;
            case "inorder" : displayInOrder(root);
                break;
        }
    }

    /**
     *
     * @param rootNode Node from which tree will start
     * Post Order traversal ROOT LEFT RIGHT
     */
    private void displayPreOrder(Node rootNode) {
        if(rootNode == null)
        {
            return;
        }
        System.out.print(rootNode.data + " ");
        displayPreOrder(rootNode.left);
        displayPreOrder(rootNode.right);
    }

    /**
     *
     * @param rootNode Node from which tree will start
     * Post Order traversal LEFT RIGHT ROOT
     */
    private void displayPostOrder(Node rootNode) {
        if(rootNode == null)
        {
            return;
        }
        displayPostOrder(rootNode.left);
        displayPostOrder(rootNode.right);
        System.out.print(rootNode.data + " ");
    }

    /**
     *
     * @param rootNode Node from which tree will start
     * Post Order traversal LEFT ROOT RIGHT
     */
    private void displayInOrder(Node rootNode) {
        if(rootNode == null)
        {
            return;
        }
        displayInOrder(rootNode.left);
        System.out.print(rootNode.data + " ");
        displayInOrder(rootNode.right);
    }

    public void displayLevelOrder() {displayLevelOrder(root);}
    /**
     *
     * @param node Node from which tree will start
     * Level Order traversal 0 ,1, 2 ...
     */
    private void displayLevelOrder(Node node) {
        if(root == null)
        {
            System.out.println("Illegal Argument provided");
            return;
        }
        Queue<Node> nodesQueue = new LinkedList<>();
        nodesQueue.add(node);
        while(!nodesQueue.isEmpty())
        {
            Node currentNode = nodesQueue.poll();
            System.out.print(currentNode.data + " ");
            if(currentNode.left != null)
            {
                nodesQueue.add(currentNode.left);
            }
            if(currentNode.right != null)
            {
                nodesQueue.add(currentNode.right);
            }
        }
    }


    /**
     *
     * @param node Node from which tree will start
     * Level Order traversal 0 ,1, 2 ...  in progress
     */
    private void displayLevelOrderZigZag(Node node) {
        if(root == null)
        {
            System.out.println("Illegal Argument provided");
            return;
        }
        int height = 0;
        Queue<Node> nodesQueue = new LinkedList<>();
        nodesQueue.add(node);
        while(!nodesQueue.isEmpty())
        {
            Node currentNode = nodesQueue.poll();
            System.out.print(currentNode.data + " ");
            if(currentNode.left != null)
            {
                nodesQueue.add(currentNode.left);
            }
            if(currentNode.right != null)
            {
                nodesQueue.add(currentNode.right);
            }
        }
    }



}
