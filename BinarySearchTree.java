class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Search for a value in the BST
    public boolean search(int value) {
        return searchHelper(root, value);
    }

    // Insert a value into the BST
    public void insert(int value) {
        root = insertHelper(root, value);
    }

    // Delete a value from the BST
    public void deleteNode(int value) {
        root = deleteHelper(root, value);
    }

    // In-order traversal
    public void inOrderTraversal() {
        inOrderHelper(root);
        System.out.println();
    }

    private void inOrderHelper(Node node) {
        if (node != null) {
            inOrderHelper(node.left);
            System.out.print(node.data + " ");
            inOrderHelper(node.right);
        }
    }

    // Pre-order traversal
    public void preOrderTraversal() {
        preOrderHelper(root);
        System.out.println();
    }

    private void preOrderHelper(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    // Post-order traversal
    public void postOrderTraversal() {
        postOrderHelper(root);
        System.out.println();
    }

    private void postOrderHelper(Node node) {
        if (node != null) {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.print(node.data + " ");
        }
    }

    // Helper method for searching a value
    private boolean searchHelper(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.data) {
            return true;
        }
        if (value < node.data) {
            return searchHelper(node.left, value);
        } else {
            return searchHelper(node.right, value);
        }
    }

    // Helper method for inserting a value
    private Node insertHelper(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.data) {
            node.left = insertHelper(node.left, value);
        } else if (value > node.data) {
            node.right = insertHelper(node.right, value);
        }
        return node;
    }

    // Helper method for deleting a value
    private Node deleteHelper(Node node, int value) {
        if (node == null) {
            return node;
        }
        if (value < node.data) {
            node.left = deleteHelper(node.left, value);
        } else if (value > node.data) {
            node.right = deleteHelper(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.data = minValue(node.right);
            node.right = deleteHelper(node.right, node.data);
        }
        return node;
    }

    // Helper method to find the minimum value in a subtree
    private int minValue(Node node) {
        int minv = node.data;
        while (node.left != null) {
            minv = node.left.data;
            node = node.left;
        }
        return minv;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("In-order Traversal:");
        bst.inOrderTraversal();

        System.out.println("Pre-order Traversal:");
        bst.preOrderTraversal();

        System.out.println("Post-order Traversal:");
        bst.postOrderTraversal();

        System.out.println("Search 50: " + bst.search(50)); // Output: true
        bst.deleteNode(20);
        System.out.println("Search 20: " + bst.search(20)); // Output: false
    }
}
