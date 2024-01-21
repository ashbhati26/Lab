import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class QueueUsingLinkedList {
    private Node front, rear;

    public QueueUsingLinkedList() {
        this.front = this.rear = null;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Method to enqueue an element into the queue
    public void enqueue(int element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Enqueued element: " + element);
    }

    // Method to dequeue an element from the queue
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow. Cannot dequeue element.");
        } else {
            int dequeuedElement = front.data;
            front = front.next;

            if (front == null) {
                rear = null;
            }

            System.out.println("Dequeued element: " + dequeuedElement);
        }
    }

    // Method to display the elements of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            Node temp = front;
            System.out.print("Queue elements: ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}

public class Question17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueueUsingLinkedList queue = new QueueUsingLinkedList();

        while (true) {
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    int elementToEnqueue = scanner.nextInt();
                    queue.enqueue(elementToEnqueue);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
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