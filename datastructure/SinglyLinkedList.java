import org.graalvm.compiler.graph.Node;

/**
 * array 는 크기가 정해진다. 검색이 빠르다.
 * list 는 링크를 추가/삭제 하는 것으로 크기를 조작하기 쉽다. 검색은 순서대로 
 */
class Node {
    int data;
    Node next;
    public Node(int d) {
        this.data = d;
    }

    // 원래는 boolen 타입 리턴해야
    void append(int d) {
        Node end = new Node(d);
        Node n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    // 문제! 루트가 삭제되지 않음!
    void delete(int d) {
        Node n  = this;
        while(n.next != null) {
            if(n.next.data == d) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retrieve() {
        Node n = this;
        while(n.next != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data);
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);

        head.retrieve();
        head.delete(3);
        head.retrieve();
        head.delete(2);
        head.retrieve();

    }
}
