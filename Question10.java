import java.util.Scanner;

public class Question10 {
    public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Move (n-1) disks from source to auxiliary peg using destination peg
        towerOfHanoi(n - 1, source, auxiliary, destination);

        // Move the nth disk from source to destination peg
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Move (n-1) disks from auxiliary peg to destination peg using source peg
        towerOfHanoi(n - 1, auxiliary, destination, source);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of disks: ");
        int numDisks = sc.nextInt();

        System.out.println("Steps to solve Tower of Hanoi with " + numDisks + " disks:");
        towerOfHanoi(numDisks, 'A', 'C', 'B');
    }
}