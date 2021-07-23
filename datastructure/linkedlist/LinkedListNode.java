class LinkedList {
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    LinkedList() {
        header = new Node();
    }

    void append(int d) {
        Node end = new Node();
        end.data = d;
        Node n = header;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void delete(int d) {
        Node n  = header;
        while(n.next != null) {
            if(n.next.data == d) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retrieve() {
        Node n = header.next;
        while(n.next != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data);
    }
}

public class LinkedListNode {
    public static void main(String[] args) {
        LinkedList head = new LinkedList();
        head.append(1);
        head.append(2);
        head.append(3);
        head.append(4);

        head.retrieve();
        head.delete(1);
        head.retrieve();
        head.delete(2);
        head.retrieve();
    }    
}
