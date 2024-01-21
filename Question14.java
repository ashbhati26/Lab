import java.util.Scanner;

public class Question14 {
    static final int MAX_SIZE = 100;
    int stackArray[];
    int top;

    public Question14() {
        stackArray = new int[MAX_SIZE];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == MAX_SIZE - 1;
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack overflow. Cannot push element " + element);
        } else {
            stackArray[++top] = element;
            System.out.println("Pushed element: " + element);
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow. Cannot pop element.");
        } else {
            int poppedElement = stackArray[top--];
            System.out.println("Popped element: " + poppedElement);
        }
    }

    // Method to display the elements of the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question14 stack = new Question14();  // Corrected class name

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