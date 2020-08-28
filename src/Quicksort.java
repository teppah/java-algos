import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Quicksort {
    public static List<Integer> sort(List<Integer> array) {
        if (array.size() < 2) {
            return array;
        }
        int midIndex = array.size() / 2;
        int middle = array.remove(midIndex);
        List<Integer> smaller = array
                .stream()
                .filter(val -> val <= middle)
                .collect(Collectors.toCollection(ArrayList::new));
        List<Integer> bigger = array
                .stream()
                .filter(val -> val > middle)
                .collect(Collectors.toCollection(ArrayList::new));

        List<Integer> sortedSmaller = sort(smaller);
        List<Integer> sortedBigger = sort(bigger);

        List<Integer> result = new ArrayList<>(sortedSmaller);
        result.add(middle);
        result.addAll(sortedBigger);
        return result;
    }
}
