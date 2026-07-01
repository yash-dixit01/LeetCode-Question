class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
      int n = grid.size();
        int maxDistance = 2 * n;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = maxDistance;
            }
        }

        Queue<int[]> bfs = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    bfs.offer(new int[]{i, j});
                }
            }
        }

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        while (!bfs.isEmpty()) {
            int[] cell = bfs.poll();
            int r = cell[0];
            int c = cell[1];
            int currentDist = dist[r][c];
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] > currentDist + 1) {
                    dist[nr][nc] = currentDist + 1;
                    bfs.offer(new int[]{nr, nc});
                }
            }
        }

        int[][] best = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                best[i][j] = -1;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        best[0][0] = dist[0][0];
        pq.offer(new int[]{best[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] item = pq.poll();
            int safeness = item[0];
            int r = item[1];
            int c = item[2];
            if (safeness < best[r][c]) {
                continue;
            }
            if (r == n - 1 && c == n - 1) {
                return safeness;
            }
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int nextSafeness = Math.min(safeness, dist[nr][nc]);
                    if (nextSafeness > best[nr][nc]) {
                        best[nr][nc] = nextSafeness;
                        pq.offer(new int[]{nextSafeness, nr, nc});
                    }
                }
            }
        }

        return best[n - 1][n - 1];
   
    }
}