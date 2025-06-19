class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // Phương thức để thực hiện duyệt hậu thứ tự (Post-order Traversal)
    public void postOrderTraversal() {
        System.out.print("Post-order Traversal: ");
        postOrderRec(root);
        System.out.println();
    }

    // Hàm đệ quy thực hiện duyệt hậu thứ tự
    private void postOrderRec(Node node) {
        if (node == null) {
            return;
        }

        // 1. Duyệt cây con bên trái
        postOrderRec(node.left);

        // 2. Duyệt cây con bên phải
        postOrderRec(node.right);

        // 3. Xử lý nút hiện tại (in giá trị ra màn hình)
        System.out.print(node.data + " ");
    }
}