package com.example;

public class Test002 {
    public static void main(String[] args) {
        // 入力をハードコードしたテスト用データ
        int startX = 3;
        int startY = 3;
        int n =18;

        int x = startX;
        int y = startY;

        // 移動方向: 0(右: x+1), 1(下: y+1), 2(左: x-1), 3(上: y-1)
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        //右に 1 歩進む
        //下に 1 歩進む（ここで方向転換が2回目になり、歩数が 2 に増える）
        //左に 2 歩進む
        //上に 2 歩進む（ここで方向転換が4回目になり、歩数が 3 に増える）
        //右に 3 歩進む
        //下に 3 歩進む（ここで方向転換が6回目になり、歩数が 4 に増える）


        int dir = 0;                  // 現在の移動方向インデックス
        int stepLen = 1;              // 同じ方向へ進むべき現在の規定歩数
        int stepsInCurrentLen = 0;    // 現在の方向で実際に進んだ歩数
        int changeCount = 0;          // 方向転換を行った回数（2回曲がるごとに stepLen が増える）

        for (int i = 0; i < n; i++) {
            // 指定された方向に1歩進む
            x += dx[dir];
            y += dy[dir];
            stepsInCurrentLen++;

            // 現在の方向での規定歩数に達した場合、方向を転換する
            if (stepsInCurrentLen == stepLen) {
                stepsInCurrentLen = 0;        // 歩数カウンターをリセット
                dir = (dir + 1) % 4;          // 次の方向に回転 (右 -> 下 -> 左 -> 上 -> 右...)
                changeCount++;                // 方向転換回数を加算

                // 2回方向転換するごとに、同じ歩数で進む距離（stepLen）を1増やす
                // （例: 右1 -> 下1 -> 左2 -> 上2 -> 右3 -> 下3... という渦巻きの性質を再現）
                if (changeCount % 2 == 0) {
                    stepLen++;
                }
            }
        }

        System.out.println(x + " " + y);
    }
}