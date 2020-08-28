import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final int[] intArray = {44, 42, 55, 82, 13, 767, 5, 56, 8, 3, 6, 86, 58, 23, 3, 5433, 654, 234, 5, 5435, 345, 68546, 345544, 4, 43243, 4, 33, 22, 6564, 5233};

    public static void main(String[] args) {
        testSelectionSort();
        testQuicksort();
        testMergesort();
    }

    public static void testSelectionSort() {
        int[] toSort = Arrays.copyOf(intArray, intArray.length);
        long before = System.nanoTime();
        SelectionSort.sort(toSort);
        long elapsed = System.nanoTime() - before;
        System.out.println("Selection sort:\n" + Arrays.toString(toSort));
        System.out.printf("Time elapsed: %d ns\n", elapsed);
    }

    public static void testQuicksort() {
        List<Integer> toSort = Arrays
                .stream(intArray)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        long before = System.nanoTime();
        List<Integer> sorted = Quicksort.sort(toSort);
        long elapsed = System.nanoTime() - before;
        System.out.println("Quicksort:\n" + sorted);
        System.out.printf("Time elapsed: %d ns\n", elapsed);
    }

    public static void testMergesort() {
        List<Integer> toSort = Arrays
                .stream(intArray)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        long before = System.nanoTime();
        List<Integer> sorted = Mergesort.sort(toSort);
        long elapsed = System.nanoTime() - before;
        System.out.println("Mergesort:\n" + sorted);
        System.out.printf("Time elapsed: %d ns\n", elapsed);
    }
}
