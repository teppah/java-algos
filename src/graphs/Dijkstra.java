package graphs;

import java.util.*;

import static utils.GraphUtils.backtrace;

public class Dijkstra {
    public static class Edge {
        private String nodeName;
        private int distance;

        @Override
        public String toString() {
            return "Edge{" +
                    "nodeName='" + nodeName + '\'' +
                    ", distance=" + distance +
                    '}';
        }

        public Edge(String nodeName, int distance) {
            this.nodeName = nodeName;
            this.distance = distance;
        }
    }

    private static class PathState {
        String nodeName;
        // encodes the path that was taken to arrive to this node
        int costToNode;

        @Override
        public String toString() {
            return "PathState{" +
                    "nodeName='" + nodeName + '\'' +
                    ", costToNode=" + costToNode +
                    '}';
        }

        public PathState(String nodeName, int costToNode) {
            this.nodeName = nodeName;
            this.costToNode = costToNode;
        }
    }

    public static int findShortestPath(Map<String, Set<Edge>> graph, String origin, String target) {
        Map<String, String> parents = new HashMap<>();
        Map<String, Integer> costs = new HashMap<>();

        PriorityQueue<PathState> toVisit = new PriorityQueue<>(Comparator.comparingInt(pathState -> pathState.costToNode));
        toVisit.add(new PathState(origin, 0));
        costs.put(origin, 0);

        PathState next;
        while ((next = toVisit.poll()) != null) {
            String currentNodeName = next.nodeName;
            if (currentNodeName.equals(target)) {
                List<String> path = backtrace(parents, target);
                System.out.println(path);
                return next.costToNode;
            }
            // a better PathState might already have been processed due to PrioQue, skip
            if (next.costToNode > costs.get(currentNodeName)) {
                continue;
            }
            // process all edges
            for (Edge edge : graph.getOrDefault(currentNodeName, Set.of())) {
                // (current lowest) cost to get to next node, defaults to infinity
                int currentCost = costs.getOrDefault(edge.nodeName, Integer.MAX_VALUE);
                // tentative cost to get to next node from current node (might be lower)
                int tentativeCost = next.costToNode + edge.distance;
                if (tentativeCost < currentCost) {
                    // update cost and parent, add it as a next PathState with the new shorter cost
                    costs.put(edge.nodeName, tentativeCost);
                    parents.put(edge.nodeName, next.nodeName);
                    toVisit.add(new PathState(edge.nodeName, tentativeCost));
                }
            }
        }
        return -1;
    }
}
