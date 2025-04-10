// import java.util.*;
package DataStructure;

public class MyStack {
    // Linked list to store the data
    // top
    Node top;
    int size;

    class Node {
        int data;
        Node next;

        Node(int value) {
            data = value;
        }
    }

    public MyStack() {
        top = null;
        size = 0;
    }

    public void push(int value) {
        if (top == null) {
            top = new Node(value);
            size += 1;
        } else {
            // top.next = new Node(value);
            // top = top.next;
            // Viết lại như sau:
            Node temp = new Node(value);
            temp.next = top;
            top = temp;
            size += 1;

        }
    }

    // Sinh viên hoàn thành các operations sau:
    // 2. pop()
    // 3. peek()
    // 4. isEmpty()
    // 5. search()
    // 6. display()
    // 7. size()
    public int size() {
        return size;
    }

    public void pop() {
        if (size > 0) {
            top = top.next;
            size -= 1;
        } else {
            System.out.println("Stack is empty");
        }
    }

}