package com.example;


import java.util.ArrayDeque;
import java.util.Queue;

public class Test001 {
    public static void main(String[] args) {
        // --- 1. グリッドの定義 (行数 N = 5, 列数 M = 4) ---
        // 画像で提示されている問題例をハードコードで再現
        // '#' が黒マス（島）、'.' が白マス
        int n = 5; // 行の数 (N)
        int m = 4; // 列の数 (M)

        char[][] grid = {
            {'.', '#', '#', '.'}, // 1行目
            {'#', '.', '#', '.'}, // 2行目
            {'.', '.', '.', '.'}, // 3行目
            {'.', '.', '#', '#'}, // 4行目
            {'.', '#', '#', '#'}  // 5行目
        };

        // --- 2. 探索の準備 ---
        boolean[][] visited = new boolean[n][m]; // 各マスが探索済みかを記録する配列
        int islandCount = 0;                     // 島の数を数えるカウンター

        // 上下左右に移動するための方向ベクトル（行の変化量 dr、列の変化量 dc）
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // --- 3. グリッド全体の走査と幅優先探索 (BFS) ---
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // まだ訪れておらず、かつマスが黒（'#'）の場合、新しい「島」の起点とみなす
                if (grid[i][j] == '#' && !visited[i][j]) {
                    islandCount++; // 発見した島の数を増やす

                    // BFS用のキューを作成し、現在の黒マスを投入
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true; // 訪問済みにマーク

                    // キューが空になるまで（繋がっている黒マスをすべて辿り切るまで）ループ
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int r = curr[0];
                        int c = curr[1];

                        // 上下左右の4方向をチェック
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            // グリッドの範囲内であり、未訪問かつ黒マスである場合
                            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
                                if (grid[nr][nc] == '#') {
                                    visited[nr][nc] = true; // 訪問済みにマーク
                                    queue.add(new int[]{nr, nc}); // キューに追加して次を探索
                                }
                            }
                        }
                    }
                }
            }
        }

        // --- 4. 結果の出力 ---
        // 問題文の図に示された通り、3つの島が存在するため「3」が出力される
        System.out.println(islandCount);
    }
}
