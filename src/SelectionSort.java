import java.util.Arrays;

import static utils.ArrayUtils.swap;

public class SelectionSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int smallestIndex = findSmallestIndex(Arrays.copyOfRange(array, i, array.length));
            swap(array, i, smallestIndex + i);
        }
    }

    private static int findSmallestIndex(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int smallest = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            if (current < smallest) {
                smallest = current;
                index = i;
            }
        }
        return index;
    }
}
