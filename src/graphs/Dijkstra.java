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

    public static class Result {
        private int cost;
        private List<String> path;

        public int getCost() {
            return cost;
        }

        public List<String> getPath() {
            return path;
        }

        public Result(int cost, List<String> path) {
            this.cost = cost;
            this.path = path;
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

    public static Result findShortestPath(Map<String, Set<Edge>> graph, String origin, String target) {
        Map<String, String> parents = new HashMap<>();
        Map<String, Integer> costs = new HashMap<>();

        PriorityQueue<PathState> toVisit = new PriorityQueue<>(Comparator.comparingInt(pathState -> pathState.costToNode));
        toVisit.add(new PathState(origin, 0));
        costs.put(origin, 0);

        PathState toSearch;
        while ((toSearch = toVisit.poll()) != null) {
            String currentNodeName = toSearch.nodeName;
            if (currentNodeName.equals(target)) {
                List<String> path = backtrace(parents, target);
                return new Result(toSearch.costToNode,path);
            }
            // a better PathState might already have been processed due to PrioQue, skip
            if (toSearch.costToNode > costs.get(currentNodeName)) {
                continue;
            }
            // process all edges
            for (Edge edge : graph.getOrDefault(currentNodeName, Set.of())) {
                // (current lowest) cost to get to next node, defaults to infinity
                int currentCost = costs.getOrDefault(edge.nodeName, Integer.MAX_VALUE);
                // tentative cost to get to next node from current node (might be lower)
                int tentativeCost = toSearch.costToNode + edge.distance;
                if (tentativeCost < currentCost) {
                    // update cost and parent, add it as a next PathState with the new shorter cost
                    costs.put(edge.nodeName, tentativeCost);
                    parents.put(edge.nodeName, toSearch.nodeName);
                    toVisit.add(new PathState(edge.nodeName, tentativeCost));
                }
            }
        }
        return new Result(-1, List.of());
    }
}
