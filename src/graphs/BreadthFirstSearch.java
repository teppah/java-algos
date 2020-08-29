package graphs;

import java.util.*;

public class BreadthFirstSearch {
    public static List<String> search(Map<String, Set<String>> graph, String origin, String target) {
        Map<String, String> parents = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Deque<String> toVisit = new ArrayDeque<>();
        toVisit.addLast(origin);
        while (!toVisit.isEmpty()) {
            String nodeToSearch = toVisit.removeFirst();
            if (nodeToSearch.equalsIgnoreCase(target)) {
                return backtrace(parents, nodeToSearch);
            }
            visited.add(nodeToSearch);
            for (String destination : graph.getOrDefault(nodeToSearch, Set.of())) {
                if (!visited.contains(destination)) {
                    toVisit.addLast(destination);
                    parents.put(destination, nodeToSearch);
                }
            }
        }
        return List.of();
    }

    private static List<String> backtrace(Map<String, String> parents, String target) {
        Deque<String> path = new ArrayDeque<>();
        path.add(target);
        String next = target;
        while ((next = parents.get(next)) != null) {
            path.addFirst(next);
        }
        return List.copyOf(path);
    }
}
