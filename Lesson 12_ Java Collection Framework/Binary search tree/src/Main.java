public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Chèn các nút vào cây theo hình ảnh đã cho
        bst.insert(27);
        bst.insert(14);
        bst.insert(35);
        bst.insert(10);
        bst.insert(19);
        bst.insert(31);
        bst.insert(42);

        bst.postOrderTraversal();
    }
}