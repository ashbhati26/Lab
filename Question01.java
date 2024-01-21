import java.util.*;

public class Question01 {
    public static int[] arrayInsertion(int arr[], int element, int position) {
        if (position < 0 || position > arr.length) {
            System.out.println("Invalid position");
            return arr;
        }

        int newArray[] = new int[arr.length + 1];

        for (int i = 0; i < position; i++) {
            newArray[i] = arr[i];
        }

        newArray[position] = element;

        for (int i = position + 1; i < newArray.length; i++) {
            newArray[i] = arr[i - 1];
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

        System.out.print("Enter the element to insert: ");
        int elementToInsert = sc.nextInt();

        System.out.print("Enter the position to insert (0-based index): ");
        int position = sc.nextInt();

        System.out.println("Original Array: " + Arrays.toString(arr));

        int result[] = arrayInsertion(arr, elementToInsert, position);

        System.out.println("Array after insertion: " + Arrays.toString(result));
    }  
}