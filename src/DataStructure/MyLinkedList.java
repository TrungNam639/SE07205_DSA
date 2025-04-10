package DataStructure;

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }
}

public class MyLinkedList {
    Node head;

    // Constructor;
    public MyLinkedList(int value) {
        head = new Node(value);
    }

    // Add item into linkedlist
    public void add(int value) {
        // Tao ra node moi
        // Node newNode = new Node(value);
        // head.next = newNode;
        // Can phai viet lai nhu sau:
        Node newNode = new Node(value);
        Node temp = head;
        head = newNode;
        head.next = temp;
    }

    public void print() {
        // Dung vong lap while de in ra cac phan tu trong linked list
        Node current = head;
        while (current != null) {
            System.out.print(current.value);
            current = current.next;
            if (current == null) {
                System.out.println("");
            } else {
                System.out.print("->");
            }
        }
    }

    // Viết hàm lấy ra phần tử theo chỉ số
    public int get(int index) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.value;
            }
            current = current.next;
            count++;
        }
        return 0;
    }

    // Viết hàm xoá phần tử theo chỉ số
    public void remove() {
        if (head != null) {
            head = head.next;
        }
    }

    public void remove(int index) {
        // Student coding here
        int count = 0;
        Node current = head;
        while (current != null) {
            if (count == index - 1) {
                Node temp = current;
                current = current.next;
                if (current.next != null) {
                    temp.next = current.next;
                } else {
                    temp.next = null;
                }
                break;
            }
            current = current.next;
            count++;
        }
    }
}