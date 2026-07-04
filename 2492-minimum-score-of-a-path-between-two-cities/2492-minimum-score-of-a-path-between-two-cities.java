class Solution {
    public int minScore(int n, int[][] roads) {
        // Create an adjacency list to represent the graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph from the roads array
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int distance = road[2];
            graph.get(a).add(new int[]{b, distance});
            graph.get(b).add(new int[]{a, distance});
        }
        
        // Use BFS to find the minimum score path from city 1 to city n
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        
        int minScore = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            int currentCity = queue.poll();
            
            for (int[] neighbor : graph.get(currentCity)) {
                int nextCity = neighbor[0];
                int distance = neighbor[1];
                
                // Update the minimum score
                minScore = Math.min(minScore, distance);
                
                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.offer(nextCity);
                }
            }
        }
        
        return minScore;  
    }
}