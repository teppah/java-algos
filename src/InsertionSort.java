public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0) {
                int toCompare = array[j];
                if (toCompare > current) {
                    array[j + 1] = array[j];
                    j--;
                } else {
                    break;
                }
            }
            array[j + 1] = current;
        }
    }
}
