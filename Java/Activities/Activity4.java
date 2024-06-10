package Activities;
import java.util.Arrays;
public class Activity4 {

static void sort (int array[]){
        int size = array.length, i;
        for (i=1;i<size;i++){
            int key = array[i];
            int j = i - 1;
        while (j >= 0 && key < array[j]) {
         array[j+1] = array[j];
         --j;
        }
        array [j+1] = key;

    }
}
    public static void main(String[] args){
        int[] ArrNum = {10,4,28,9,23,57,42,100,4324,873};
        sort(ArrNum);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(ArrNum));

    }
}
