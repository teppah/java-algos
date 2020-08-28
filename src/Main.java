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
        testBinarySearch();
    }

    public static void testSelectionSort() {
        int[] toSort = Arrays.copyOf(intArray, intArray.length);
        SelectionSort.sort(toSort);
        System.out.println("Selection sort:\n" + Arrays.toString(toSort));
    }

    public static void testQuicksort() {
        List<Integer> toSort = Arrays
                .stream(intArray)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        List<Integer> sorted = Quicksort.sort(toSort);
        System.out.println("Quicksort:\n" + sorted);
    }

    public static void testMergesort() {
        List<Integer> toSort = Arrays
                .stream(intArray)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        List<Integer> sorted = Mergesort.sort(toSort);
        System.out.println("Mergesort:\n" + sorted);
    }

    public static void testBinarySearch() {
        List<Integer> toSort = Arrays
                .stream(intArray)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        int[] sorted = Quicksort.sort(toSort).stream().mapToInt(i -> i).toArray();
        int key = 345;
        int index = BinarySearch.search(sorted, key);
        System.out.printf("Index of 345 with binary search: %d\n", index);
    }
}
