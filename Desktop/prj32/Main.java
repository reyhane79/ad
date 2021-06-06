import java.util.*;

public class Main {
    static class Graph {
        Set<Integer> vertices = new HashSet<>();
        Map<Integer, List<Integer>> adjacencyList;

        Graph() {
            adjacencyList = new HashMap<>();
        }

        void addEdge(int u, int v) {
            vertices.add(u);
            vertices.add(v);

            if (!adjacencyList.containsKey(u))
                adjacencyList.put(u, new ArrayList<>());
            adjacencyList.get(u).add(v);

            if (!adjacencyList.containsKey(v))
                adjacencyList.put(v, new ArrayList<>());
            adjacencyList.get(v).add(u);
        }

        List<List<Integer>> getAllPaths(int u, int v) {
            List<List<Integer>> result = new ArrayList<>();
            if (u == v) {
                List<Integer> temp = new ArrayList<>();
                temp.add(u);
                result.add(temp);
                return result;
            }
            boolean[] visited = new boolean[vertices.size()];
            Deque<Integer> path = new ArrayDeque<>();
            getAllPathsDFS(u, v, visited, path, result);
            return result;
        }

        void getAllPathsDFS(int u, int v, boolean[] visited, Deque<Integer> path, List<List<Integer>> result) {
            visited[u] = true;
            path.add(u);
            if (u == v)
                result.add(new ArrayList<>(path));
            else if (adjacencyList.containsKey(u))
                for (Integer i : adjacencyList.get(u))
                    if (!visited[i])
                        getAllPathsDFS(i, v, visited, path, result);
            path.removeLast();
            visited[u] = false;
        }
    }

    public static void main(String[] args) {
        int count = 1;

        while (true) {
            Graph g = new Graph();
            Scanner scanner = new Scanner(System.in);
            int target = scanner.nextInt();
            int x, y;
            do {
                x = scanner.nextInt();
                y = scanner.nextInt();
                g.addEdge(x, y);
            } while (x != 0 || y != 0);

            System.out.println("CASE " + count + ":");
            List<List<Integer>> results = g.getAllPaths(1, target);
            for (List<Integer> l : results) {
                StringBuilder sb = new StringBuilder();
                for (int s : l) {
                    sb.append(s);
                    sb.append("\t");
                }
                System.out.println(sb);
            }
            System.out.println("There are " + results.size() + " routes from the firestation to streetcorner " + target + ".");
            count++;
        }
    }
}