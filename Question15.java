import java.util.Scanner;

public class Question15 {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class StackUsingLinkedList {
        private Node top;

        public StackUsingLinkedList() {
            this.top = null;
        }

        // Method to check if the stack is empty
        public boolean isEmpty() {
            return top == null;
        }

        // Method to push an element onto the stack
        public void push(int element) {
            Node newNode = new Node(element);
            newNode.next = top;
            top = newNode;
            System.out.println("Pushed element: " + element);
        }

        // Method to pop an element from the stack
        public void pop() {
            if (isEmpty()) {
                System.out.println("Stack underflow. Cannot pop element.");
            } else {
                int poppedElement = top.data;
                top = top.next;
                System.out.println("Popped element: " + poppedElement);
            }
        }

        // Method to display the elements of the stack
        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
            } else {
                Node temp = top;
                System.out.print("Stack elements: ");
                while (temp != null) {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackUsingLinkedList stack = new StackUsingLinkedList();

        while (true) {
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int elementToPush = scanner.nextInt();
                    stack.push(elementToPush);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}