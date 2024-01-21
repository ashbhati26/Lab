import java.util.Scanner;

public class Question16 {
    private static final int MAX_SIZE = 100;
    private int[] queueArray;
    private int front, rear;

    public Question16() {
        queueArray = new int[MAX_SIZE];
        front = -1;
        rear = -1;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return rear == MAX_SIZE - 1;
    }

    // Method to enqueue an element into the queue
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue overflow. Cannot enqueue element " + element);
        } else if (isEmpty()) {
            front = rear = 0;
            queueArray[rear] = element;
            System.out.println("Enqueued element: " + element);
        } else {
            queueArray[++rear] = element;
            System.out.println("Enqueued element: " + element);
        }
    }

    // Method to dequeue an element from the queue
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow. Cannot dequeue element.");
        } else if (front == rear) {
            int dequeuedElement = queueArray[front];
            front = rear = -1;
            System.out.println("Dequeued element: " + dequeuedElement);
        } else {
            int dequeuedElement = queueArray[front++];
            System.out.println("Dequeued element: " + dequeuedElement);
        }
    }

    // Method to display the elements of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queueArray[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question16 queue = new Question16();

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
