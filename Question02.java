import java.util.*;

public class Question02 {
     public static int[] arrayDeletion(int arr[], int position) {
        if (position < 0 || position >= arr.length) {
            return null;
        }

        int[] newArray = new int[arr.length - 1];

        for (int i = 0; i < position; i++) {
            newArray[i] = arr[i];
        }

        // Skip the element at the deletion position and continue copying the remaining elements
        for (int i = position; i < newArray.length; i++) {
            newArray[i] = arr[i + 1];
        }

        return newArray;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int arr[] = new int[size];

        System.out.println("Enter elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the position to delete (0-based index): ");
        int position = sc.nextInt();

        System.out.println("Original Array: " + Arrays.toString(arr));

        int arrayAfterDeletion[] = arrayDeletion(arr, position);

        if (arrayAfterDeletion != null) {
            System.out.println("Array after deletion: " + Arrays.toString(arrayAfterDeletion));
        } else {
            System.out.println("Invalid position for deletion");
        }
    }
}