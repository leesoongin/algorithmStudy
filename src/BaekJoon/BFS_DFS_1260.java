package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class BFS_DFS_1260 {
    static ArrayList<Integer>[] map; //vertex에 연결 되어있는
    static boolean[] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertexCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int startPoint = Integer.parseInt(st.nextToken());

        map = new ArrayList[vertexCount + 1]; //index 1부터 사용 예정
        visited = new boolean[vertexCount + 1];//boolean's default value is false

        for (int i = 0; i <= vertexCount; i++) { //arraylist init
            map[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x].add(y);
            map[y].add(x);
        }

        for(int i=0;i<=vertexCount;i++){ //작은거부터 방문할거니까
            Collections.sort(map[i]);
        }

        System.out.println("bfs");
        bfs(visited,startPoint);

        Arrays.fill(visited,false); //boolean값 다시 초기화
        System.out.println("");

        System.out.println("dfs");
        dfs(visited,startPoint);

    }//main

    static void dfs(boolean[] visited, int startPoint){
        visited[startPoint]=true;
        System.out.print(startPoint+" ");

        for(int element : map[startPoint]){
            if(!visited[element]){
                dfs(visited,element);
            }
        }//for
    }//dfs

    static void bfs(boolean[] visited,int startPoint){
        Queue<Integer> queue=new LinkedList<>();

        queue.offer(startPoint);
        visited[startPoint]=true;

        while(!queue.isEmpty()){
            startPoint=queue.poll();
            System.out.print(startPoint+" ");

            for(int element : map[startPoint]){
                if(!visited[element]){//방문하지 않은 vertex라면 ,
                    queue.offer(element);
                    visited[element]=true;
                }

            }//for
        }//while
    }//bfs
}//class
