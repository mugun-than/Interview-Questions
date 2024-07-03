class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class LoopLL {
    public static void main(String[] a) {
         Node head = new Node(0);
         Node current = head;

        for(int i = 1; i < 6; i++) {
            current.next = new Node(i);
            current = current.next;
        }

        Node last = current;
        Node third = head.next.next;

        last.next = third;

        Node slowPointer = head, fastPointer = head;
        boolean flag = false;
        while(slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer) {
                flag = true;
                break;
            }
        }

        if(flag) System.out.println("LOOPED");
        else System.out.println("NOT LOOPED");
    }
}
