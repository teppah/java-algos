import java.util.ArrayList;
import java.util.List;

public class Mergesort {
    public static List<Integer> sort(List<Integer> array) {
        if (array.size() < 2) {
            return array;
        }
        int mid = array.size() / 2;
        List<Integer> firstHalf = new ArrayList<>(array.subList(0, mid));
        List<Integer> secondHalf = new ArrayList<>(array.subList(mid, array.size()));

        List<Integer> sortedFirstHalf = sort(firstHalf);
        List<Integer> sortedSecondHalf = sort(secondHalf);

        return merge(sortedFirstHalf, sortedSecondHalf);
    }

    private static List<Integer> merge(List<Integer> a, List<Integer> b) {
        List<Integer> sorted = new ArrayList<>();
        while (a.size() > 0 && b.size() > 0) {
            int firstA = a.get(0);
            int firstB = b.get(0);
            if (firstA < firstB) {
                sorted.add(a.remove(0));
            } else {
                sorted.add(b.remove(0));
            }
        }
        sorted.addAll(a);
        sorted.addAll(b);
        return sorted;
    }
}
