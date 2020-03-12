package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_DFS_7576 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int flag = 0;
    static int max = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1)
                    q.offer(new int[]{i, j});
                if (map[i][j] == 0)
                    flag = 1;
            }
        }
        if (flag == 0)//flag가 0이라는건 전부다 익은 토마토라는 ㅇㅇ
            System.out.println(0);
        else {
            bfs(q);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) { //bfs로 작업 완료했는데도 익지않은 토마토가 있다면 return -1
                        System.out.println(-1);
                        return;
                    }//inner if
                }//inner for
            }//for

            System.out.println(max - 1);
        }//else
    }//main

    public static void bfs(Queue<int[]> queue) {
        Queue<int[]> q = queue;

        while (!q.isEmpty()) {
            int[] location = q.poll();
            visited[location[0]][location[1]] = true;

            for (int dir = 0; dir < 4; dir++) {
                int r = location[0] + dr[dir];
                int c = location[1] + dc[dir];

                if (r >= 0 && c >= 0 && r < N && c < M) {//좌표값은 인덱스니까 r,c의 최대값은 n,m의 -1값
                    //map[r][c] != -1으로 할 시 오류!
                    if (map[r][c] == 0 && !visited[r][c]) { //익지않았고, 방문하지 않았다면
                        q.offer(new int[]{r, c});
                        visited[r][c] = true;
                        map[r][c] = map[location[0]][location[1]] + 1;

                        max = map[r][c];
                    }//inner if
                }//if
            }//for
        }//while
    }//bfs

    public static void printMap() {
        for (int i = 0; i < N; i++)
            System.out.println(Arrays.toString(map[i]));
    }
}
