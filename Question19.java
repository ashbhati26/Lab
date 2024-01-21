import java.util.Scanner;

public class Question19 {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear;

    public Question19() {
        front = rear = null;
    }

    // Method to check if the circular queue is empty
    public boolean isEmpty() {
        return front == null && rear == null;
    }

    // Method to enqueue an element into the circular queue
    public void enqueue(int element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        // Make the queue circular by connecting the last node to the front
        rear.next = front;

        System.out.println("Enqueued element: " + element);
    }

    // Method to dequeue an element from the circular queue
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Circular Queue underflow. Cannot dequeue element.");
        } else {
            int dequeuedElement = front.data;

            if (front == rear) {
                front = rear = null;
            } else {
                front = front.next;
                rear.next = front; // Maintain circular structure
            }

            System.out.println("Dequeued element: " + dequeuedElement);
        }
    }

    // Method to display the elements of the circular queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty.");
        } else {
            Node temp = front;
            System.out.print("Circular Queue elements: ");

            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != front);

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question19 circularQueue = new Question19();  // Corrected class name

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
                    circularQueue.enqueue(elementToEnqueue);
                    break;
                case 2:
                    circularQueue.dequeue();
                    break;
                case 3:
                    circularQueue.display();
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
