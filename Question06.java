import java.util.Arrays;

public class Question06 {
    public static void selectionSort(int array[]){
        for(int turn = 0; turn < array.length; turn++){
            int minPos = turn;
            for(int j = turn+1; j < array.length; j++){
                if(array[minPos] > array[j]){
                    minPos = j;
                }
            }
            // swap
            int temp = array[minPos];
            array[minPos] = array[turn];
            array[turn] = temp;
        }
    }

    public static void main(String[] args) {
        int array[] = {5, 4, 1, 3, 2};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}