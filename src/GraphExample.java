import java.util.List;

public class GraphExample {
    public static void main(String[] args) {
        // Napravi neusmereni graf (false = neusmeren)
        Graph g = new Graph(false);

        // Dodavanje čvorova (nije neophodno ako addEdge automatski dodaje)
        for (int i = 1; i <= 5; i++) {
            g.addVertex(i);
        }

        // Dodavanje grana
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);

        // Ispis grafa
        System.out.println("Graf (lista susedstva):");
        g.printGraph();

        // Test BFS od čvora 1
        System.out.println("\nBFS od čvora 1:");
        List<Integer> bfsOrder = g.bfs(1);
        System.out.println(bfsOrder);

        // Test uklanjanja i ponovni ispis
        g.removeEdge(1, 3);
        System.out.println("\nNakon uklanjanja grane 1-3:");
        g.printGraph();

        g.removeVertex(4);
        System.out.println("\nNakon uklanjanja čvora 4:");
        g.printGraph();
    }
}
