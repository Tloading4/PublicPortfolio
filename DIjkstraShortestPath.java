import java.util.*;

class DijkstraAlgorithm {

    // Method to calculate shortest path
    public static void dijkstra(int[][] graph, int startVertex) {
        int vertexCount = graph.length;
        int[] distances = new int[vertexCount]; // Array to store the shortest distance from start
        boolean[] visited = new boolean[vertexCount]; // Array to track visited vertices

        // Initialize all distances to infinity and visited to false
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0; // Distance to the start vertex is 0

        // Loop to process each vertex
        for (int i = 0; i < vertexCount - 1; i++) {
            // Get the vertex with the smallest distance that hasn't been visited yet
            int currentVertex = getMinDistanceVertex(distances, visited);
            visited[currentVertex] = true;

            // Update distances for each neighbor of the current vertex
            for (int neighbor = 0; neighbor < vertexCount; neighbor++) {
                if (!visited[neighbor] && graph[currentVertex][neighbor] != 0 &&
                        distances[currentVertex] != Integer.MAX_VALUE &&
                        distances[currentVertex] + graph[currentVertex][neighbor] < distances[neighbor]) {
                    distances[neighbor] = distances[currentVertex] + graph[currentVertex][neighbor];
                }
            }
        }

     
        printSolution(distances, startVertex);
    }

    // Method to find the vertex with the smallest distance
    private static int getMinDistanceVertex(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minVertex = -1;

        for (int vertex = 0; vertex < distances.length; vertex++) {
            if (!visited[vertex] && distances[vertex] < minDistance) {
                minDistance = distances[vertex];
                minVertex = vertex;
            }
        }

        return minVertex;
    }

  
    private static void printSolution(int[] distances, int startVertex) {
        System.out.println("Vertex\tDistance from Vertex " + startVertex);
        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + "\t\t" + distances[i]);
        }
    }


    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        int[][] graph = {
                {0, 10, 0, 30, 100},
                {10, 0, 50, 0, 0},
                {0, 50, 0, 20, 10},
                {30, 0, 20, 0, 60},
                {100, 0, 10, 60, 0}
        };


        dijkstra(graph, 0); // Start vertex is 0
    }
}
