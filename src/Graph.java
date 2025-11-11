import java.util.*;

class Graph {
    private final Map<Integer, List<Integer>> adjList = new HashMap<>();
    private final boolean directed;

    // Ako directed = true, graf je usmeren; inače neusmeren.
    public Graph(boolean directed) {
        this.directed = directed;
    }

    // Dodaj čvor (ako već postoji, ništa se ne menja)
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Dodaj granu; automatski kreira čvorove ako ne postoje
    public void addEdge(int v1, int v2) {
        // Osiguraj da su oba vrha prisutna
        addVertex(v1);
        addVertex(v2);

        adjList.get(v1).add(v2);
        if (!directed) {
            adjList.get(v2).add(v1);
        }
    }

    // Ukloni granu (ako postoji)
    public void removeEdge(int v1, int v2) {
        List<Integer> list1 = adjList.get(v1);
        if (list1 != null) list1.remove(Integer.valueOf(v2));
        if (!directed) {
            List<Integer> list2 = adjList.get(v2);
            if (list2 != null) list2.remove(Integer.valueOf(v1));
        }
    }

    // Ukloni čvor i sve njegove veze
    public void removeVertex(int v) {
        if (!adjList.containsKey(v)) return;
        adjList.remove(v);
        // ukloni ovaj čvor iz svih lista suseda
        for (List<Integer> neighbors : adjList.values()) {
            neighbors.remove(Integer.valueOf(v));
        }
    }

    // Ispis grafa (lista susedstva)
    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Primer BFS (početak od start)
    public List<Integer> bfs(int start) {
        List<Integer> order = new ArrayList<>();
        if (!adjList.containsKey(start)) return order;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            order.add(cur);
            for (int neigh : adjList.getOrDefault(cur, Collections.emptyList())) {
                if (!visited.contains(neigh)) {
                    visited.add(neigh);
                    q.add(neigh);
                }
            }
        }
        return order;
    }
}

