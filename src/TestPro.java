import com.sun.org.apache.xpath.internal.operations.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TestPro{
    static int[][] map;
    static boolean[][] visited;
    static int row;
    static int cols;
    static int max;
    static int[] dr;
    static int[] dc;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        row=Integer.parseInt(st.nextToken());
        cols=Integer.parseInt(st.nextToken());

        for(int i=0;i<row;i++){
            st=new StringTokenizer(br.readLine());
            java.lang.String line=st.nextToken();
            for(int j=0;j<cols;j++){
                map[row][cols]=line.charAt(j)-'0'; //String -> int
            }//inner for
        }//for

        Queue<int[]> queue=new LinkedList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<cols;j++){
                if(map[row][cols] == 1){ //익은 토마토라면 queue에 offer
                    queue.offer(new int[] {i,j});
                }else if(map[row][cols] == 0){

                }
            }//inner for
        }//for
    }//main
}