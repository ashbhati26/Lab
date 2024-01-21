import java.util.Arrays;

public class Question07 {
    public static void insertionSort(int array[]){
        for(int i = 1; i<array.length; i++){
            int current = array[i];
            int previous = i-1;
            // finding out the correct position to insert
            while(previous >= 0 && array[previous] > current){
                array[previous+1] = array[previous];
                previous--;
            }
            array[previous+1] = current;
        }
    }

    public static void main(String[] args) {
        int array[] = {5, 4, 1, 3, 2};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}