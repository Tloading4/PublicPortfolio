import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void printLevel(Node node) {
        if (node == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.key + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }

    // Helper method to find a Node by key
    public Node getNode(Key key) {
        return getNode(root, key);
    }

    private Node getNode(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return getNode(x.left, key);
        else if (cmp > 0) return getNode(x.right, key);
        else return x;
    }

    //printLevel() Method for three nodes
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();

        //BST Keys to be inserted
        int[] keys = {50, 30, 20, 40, 70, 60, 80, 90, 10, 25};
        for (int key : keys) {
            bst.put(key, "Value" + key);
        }

        // Test printLevel() method with three different nodes
        System.out.println("Level order traversal from root node 50:");
        bst.printLevel(bst.getNode(50));

        System.out.println("Level order traversal from node 30:");
        bst.printLevel(bst.getNode(30));

        System.out.println("Level order traversal from node 70:");
        bst.printLevel(bst.getNode(70));
    }
}
