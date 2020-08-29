package utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class GraphUtils {
    public static List<String> backtrace(Map<String, String> parents, String target) {
        Deque<String> path = new ArrayDeque<>();
        path.add(target);
        String next = target;
        while ((next = parents.get(next)) != null) {
            path.addFirst(next);
        }
        return List.copyOf(path);
    }
}
