public class BST {

    public class Node {
        int value;
        Node left;
        Node right;
        int height;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    private int getHeight(Node node) {
        if(node == null)
        {
            return -1;
        }
        return node.height;
    }

    public void insertElements(int[] nums) {
        for (int num : nums) {
            insert(num);
        }
        displayInOrder(root);
        System.out.println();
        System.out.println("Height of tree is  -> " + getHeight(root));

    }

    public void insert(int value) {
        root = insertElement(root, value);
    }

    private Node insertElement(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if(value > node.value){
            node.right = insertElement(node.right, value);
        }
        if(value < node.value)
        {
            node.left = insertElement(node.left, value);
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return node;
    }

    /**
     * Display inorder for BSt to ensure the BST is built correctly.
     * In-order will display the elements by default in ascending order
     */
    public void displayInOrder(Node root) {
        if(root == null)
        {
            return;
        }
        displayInOrder(root.left);
        System.out.print(root.value + " ");
        displayInOrder(root.right);
    }
}

