import java.util.Scanner;

public class Question18 {
    private static final int MAX_SIZE = 5;
    private int[] queueArray;
    private int front, rear;

    public Question18() {
        queueArray = new int[MAX_SIZE];
        front = -1;
        rear = -1;
    }

    // Method to check if the circular queue is empty
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    // Method to check if the circular queue is full
    public boolean isFull() {
        return (rear + 1) % MAX_SIZE == front;
    }

    // Method to enqueue an element into the circular queue
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Circular Queue overflow. Cannot enqueue element " + element);
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % MAX_SIZE;
            }

            queueArray[rear] = element;
            System.out.println("Enqueued element: " + element);
        }
    }

    // Method to dequeue an element from the circular queue
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Circular Queue underflow. Cannot dequeue element.");
        } else {
            int dequeuedElement = queueArray[front];

            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % MAX_SIZE;
            }

            System.out.println("Dequeued element: " + dequeuedElement);
        }
    }

    // Method to display the elements of the circular queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty.");
        } else {
            int i = front;
            System.out.print("Circular Queue elements: ");

            do {
                System.out.print(queueArray[i] + " ");
                i = (i + 1) % MAX_SIZE;
            } while (i != (rear + 1) % MAX_SIZE);

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question18 circularQueue = new Question18();

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