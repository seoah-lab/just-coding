import java.util.Comparator;

public class BinTree<K, V> {

    static class Node<K, V> {
        private K key;
        private V data;

        private Node<K, V> left;
        private Node<K, V> right;

        Node(K key, V data, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return data;
        }

        void print() {
            System.out.println(data);
        }
    }

    private Node<K, V> root;
    private Comparator<? super K> comparator = null;

    public BinTree() {
        root = null;
    }

    public BinTree(Comparator<? super K> c) {
        this();
        comparator = c;
    }

    private int comp(K key1, K key2) {
        return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2)
                : comparator.compare(key1,key2);
    }

    public V search(K key)  {
        Node<K,V> p = root;

        while (true) {
            if (p == null)
                return null;

            int cond = comp(key, p.getKey());
            if(cond == 0)
                return p.getValue();
            else if (cond < 0)
                p = p.left;
            else
                p = p.right;
        }
    }

    private void addNode(Node<K,V> node, K key, V data) {
        int cond = comp(key, node.getKey());
        if(cond == 0)
            return;
        else if (cond < 0) {
            if(node.left == null)
                node.left = new Node<K,V>(key, data, null, null);
            else
                addNode(node.left, key, data);
        } else {
            if (node.right == null)
                node.right = new Node<K,V>(key, data, null, null);
            else
                addNode(node.right, key, data);
        }
    }

    public void add(K key, V data) {
        if(root == null)
            root = new Node<K,V>(key, data, null, null);
        else
            addNode(root, key, data);
    }

    public boolean remove(K key) {
        Node<K, V> p = root; // pointer
        Node<K, V> parent = null; // pointer 의 부모루트
        boolean isLeftChild = true;
        //key 값을 트리에서 찾아서 p 에 저장
        while (true) {
            if (p == null)
                return false;// 삭제할 값이 없다.
            int cond = comp(key, p.getKey()); // 검색할 키와 루트의 키를 비교한다.
            if (cond == 0) // 키값과 루트의 값이 일치하면
                break;// ture 리턴
            else {
                parent = p; //  pointer를 부모로 설정
                if (cond < 0) { //key 가 포인터 보다 작으면
                    isLeftChild = true;//왼쪽 노드에 있다
                    p = p.left; // 부모의 값을 왼쪽 노드로 설정
                } else {
                    isLeftChild = false; // 왼쪽노드에 없다
                    p = p.right; // 오른쪽으로 검색하기 위해서 노드 설정
                }
            }
        }

        if (p.left == null) { // pointer 에 왼쪽 자식이 없는 경우
            if (p == root) // 트리의 root와 찾는 key가 같을 때 값이 같을때
                root = p.right;  // pointer를 삭제하고 p.right 로 root로 해새 p를 삭제
            else if (isLeftChild) // 왼쪽 서브 트리면
                parent.left = p.right; //왼쪽 자식을 부모의 왼쪽 자식으로 변경 pointer 삭제
            else
                parent.right = p.right; // 오른쪽 서브 트리면 pointer의 오른쪽 자식을 부모의 오른쪽 자식으로 변경 pointer 삭제
        } else if (p.right == null) { // pointer의 오른쪽 자식이 없는 경우
            if (p == root)
                root = p.left;
            else if (isLeftChild)
                parent.left = p.left;
            else
                parent.right = p.left;
        } else {  //양쪽다 있는 경우
            parent = p;
            Node<K, V> left = p.left;
            isLeftChild = true;
            while (left.right != null) { //가장 큰 left를 검색
                parent = left;
                left = left.right;
                isLeftChild = false;
            }
            p.key = left.key;
            p.data = left.data;
            if (isLeftChild)
                parent.left = left.left;
            else
                parent.right = left.left;
        }
        return true;
    }

    private void printSubTree(Node node) {
        if (node != null) {
            printSubTree(node.left);
            System.out.println(node.key + " " + node.data );
            printSubTree(node.right);
        }
    }

    public void print() {
        printSubTree(root);
    }
    //최소 노드를 반환
    private Node<K,V> getMinNode() {
        if(root == null) {
            return null;
        } else {
            Node<K,V> p = root;
            while (p.left != null)
                p = p.left;
            return p;
        }
    }

    //최대 노드를 반환
    private Node<K, V> getMaxNode() {
        if(root == null)
            return null;
        else {
            Node<K,V> p = root;
            while (p.right != null)
                p = p.right;

            return p;
        }
    }
}
