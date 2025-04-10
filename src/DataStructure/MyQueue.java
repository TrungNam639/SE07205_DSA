package DataStructure;

public class MyQueue {
    Node head;
    int size;

    class Node {
        int data;
        Node next;

        Node(int value) {
            data = value;
        }
    }

    public MyQueue() {
        head = null;
        size = 0;
    }

    public void add(int value) {
        if (size == 0) {
            head = new Node(value);
            size += 1;
        } else {
            Node current = head;
            while (current != null) {
                if (current.next == null) {
                    current.next = new Node(value);
                    break;
                }
                current = current.next;
            }
            size += 1;
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
            if (current == null) {
                System.out.println("");
            } else {
                System.out.print("->");
            }
        }
    }

    // Sinh viên hoàn thành các operations sau
    // 2. remove
    // 3. peek
    // 4. isEmpty
    // 5. size
}