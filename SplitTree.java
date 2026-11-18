
class Node {
    int value;
    Node left, right;
    public Node(int value) {
        this.value = value;
    }
}

public class SplitTree {
    private static boolean ans;
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(6);
        root.right.left = new Node(7);
        root.right.left.left = new Node(3);
        root.right.left.right = new Node(2);
        root.right.right = new Node(4);
        root.right.right.right = new Node(8);

        int sizeoftree = getSize(root, -1);
        getSize(root, sizeoftree / 2);
        System.out.println(ans ? "YES" : "NO");
    }

    public static int getSize(Node root, int size) {
        if(root == null) return 0;

        int lsize = getSize(root.left, size);
        int rsize = getSize(root.right, size);

        if(lsize == size || rsize == size) ans = true;

        return lsize + rsize + 1;
    }
}
