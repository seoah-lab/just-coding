package tree;
class ArrayToTree {
    class Node{
        int data;
        Node left, right;
        Node (int data) {
            this.data = data;
        }
    }
    Node root;
    public void makeTree(int[] a) {
        root = makeTreeR(a, 0, a.length -1);
    }
    public Node makeTreeR(int[] a, int start, int end) {
        if(start > end) return null;
        int mid = (start + end) / 2;
        Node node = new Node(a[mid]);
        node.left = makeTreeR(a, start, mid - 1);
        node.right = makeTreeR(a, mid + 1, end);
        return node;
    }

    public void searchBTree(Node n, int find) {
        if(find < n.data) {
            System.out.println("Data is small than " + n.data);
            searchBTree(n.left, find);
        } if(find > n.data) {
            System.out.println("Data is bigger than " + n.data);
            searchBTree(n.right, find);
        } else {
            System.out.println("Data found!");
        }
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        ArrayToTree t = new ArrayToTree();
        t.makeTree(a);
        t.searchBTree(t.root, 2);
    }
}




