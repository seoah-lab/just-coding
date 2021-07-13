/**
 * 작은 값은 왼쪽, 큰값은 오른쪽 
 * 검색 시간 log n
 * insertion log n 
 * deletion  log n
 * 1. no child 부모노드 링크 삭제
 * 2. one child 자식의 자식 노드로 링크 조정
 * 3. 2 children 지울 노드를 삭제하고 왼쪽 트리의 가장 작은값을 자리로 이동하고 옴긴 상위 링크 삭제
 */
class BST {
    class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
        }
    }
    Node root;
    
    public Node search(Node root, int key) {
        if(root == null || root.data == key) return root; //root 가 비어있으면 리턴
        if(root.data > key) return search(root.left , key); // root의 데이터보다 key 값이 작으면 왼쪽으로 재귀호출
        return search(root.right, key); // root의 데이터보다 key 값이 크면 오른쪽으로 재귀호출
    }

    public void insert(int data) {
        root = insert(root, data);
    }
    private Node insert(Node root, int data) {
        if (root == null) { // root 가 비었으면 root 생성
            root = new Node(data);
        }

        if(data < root.data) {
            root.left = insert(root.left, data); // root의 데이터보다 key 값이 작으면 왼쪽으로 재귀호출
        } else if(data > root.data) {
            root.right = insert(root.right, data); // root의 데이터보다 key 값이 크면 오른쪽으로 재귀호출
        }
        return root;
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node root, int data) {
        if(root == null) return root;
        if(data < root.data)
            root.left = delete(root.left, data);
        else if(data > root.data)
            root.right = delete(root.right, data);
        /**
         * 1. no child 부모노드 링크 삭제
         * 2. one child 자식의 자식 노드로 링크 조정
         * 3. 2 children 지울 노드를 삭제하고 왼쪽 트리의 가장 작은값을 자리로 이동하고 옴긴 상위 링크 삭제
         */
        else {
            if(root.left == null && root.right == null) return null;
            else if(root.left == null) return root.right; 
            else if(root.right == null) return root.left;
            
            root.data = findMin(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }
    int findMin(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }
    public void inorder() {
        inorder(root);
        System.out.println("");
    }

    private void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        tree.inorder();
        tree.delete(5);
        tree.inorder();
        tree.insert(5);
        tree.inorder();
    }
}