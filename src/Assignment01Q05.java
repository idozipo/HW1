public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        // Edge case same vertex
        if (i == j) {
            return 0;
        }

        int vCount = m.length;
        boolean[] visited = new boolean[vCount];
        visited[i] = true;

        // Start with the first layer containing only the starting vertex 'i'
        int[] currentLayer = new int[vCount];
        currentLayer[0] = i;

        return recursiveHelper(m, currentLayer, 1, j, visited, 1);
    }

    private static int recursiveHelper(int[][] m, int[] currentLayer, int layerSize,
            int target, boolean[] visited, int currentDistance) {
        // Base case If there are no more vertices to explore, no path exists
        if (layerSize == 0) {
            return -1;
        }

        int numVertices = m.length;
        int[] nextLayer = new int[numVertices];
        int nextLayerSize = 0;

        // Explore all vertices in the current distance layer
        for (int idx = 0; idx < layerSize; idx++) {
            int current = currentLayer[idx];

            for (int neighbor = 0; neighbor < numVertices; neighbor++) {
                // If an edge exists and the neighbor hasn't been visited yet
                if (m[current][neighbor] == 1 && !visited[neighbor]) {
                    // If we found the target, return the current distance immediately
                    if (neighbor == target) {
                        return currentDistance;
                    }

                    visited[neighbor] = true;
                    nextLayer[nextLayerSize] = neighbor;
                    nextLayerSize++;
                }
            }
        }

        // Recurse to the next layer, incrementing the path length by 1
        return recursiveHelper(m, nextLayer, nextLayerSize, target, visited, currentDistance + 1);
    }

    public static void main(String[] args) {
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 0, 1)); // -1
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 1, 1)); // 0
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 }, { 1, 0, 0, 0 } }, 0, 2)); // 2
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } }, 0, 2)); // 2
    }
}