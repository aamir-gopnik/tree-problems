import java.util.Scanner;
import java.util.TreeMap;


public class Main {



    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();

        //Adding default data as data adding is taking time.
        binaryTree.addDefaultData();


        //printing level order traversal of binary tree
        binaryTree.displayLevelOrder();
        System.out.println();

        //printing depth first order traversal of binary tree
        //System.out.println("DFS - > ");
        //binaryTree.displayDFS("inorder");

        /**
         * Main function used for calling BST methods
         */
        /*
        int[] nums = new int[]{2,5,1,6,3,7,4};

        BST bst = new BST();
        System.out.println();
        System.out.println("******************* BST *********************");
        bst.insertElements(nums);*/


    }
}