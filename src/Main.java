import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] toSort = {44, 3, 5435, 654, 234, 5, 5435};
        InsertionSort.sort(toSort);
        System.out.println(Arrays.toString(toSort));
    }
}
