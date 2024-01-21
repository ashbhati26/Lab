import java.util.Scanner;

public class Question20 {
    static class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            this.left = this.right = null;
        }
    }

    private Node root;

    public Question20() {
        this.root = null;
    }

    // Method to insert a key into the BST
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // Method to perform in-order traversal of the BST
    public void inOrderTraversal() {
        System.out.print("In-order Traversal: ");
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.key + " ");
            inOrderTraversal(root.right);
        }
    }

    // Method to search for a key in the BST
    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {
        if (root == null || root.key == key) {
            return root != null;
        }

        if (key < root.key) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question20 bst = new Question20();

        // Inserting elements into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // In-order Traversal
        bst.inOrderTraversal();

        // Search for a key
        System.out.print("Enter a key to search: ");
        int keyToSearch = scanner.nextInt();
        if (bst.search(keyToSearch)) {
            System.out.println(keyToSearch + " is present in the BST.");
        } else {
            System.out.println(keyToSearch + " is not present in the BST.");
        }
    }
}