import java.util.*;

public class TestPro {
    public static void main(String[] args){
        int[] priorities={2,1,3,2};
        int location=2;

        System.out.println(solution(priorities,location));
    }//main
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) { //arr -> queue
            queue.offer(priorities[i]);
        }

        while(!queue.isEmpty()){
            for(int i=0;i<priorities.length;i++){
                if(queue.peek() == priorities[i]){
                    if(i == location){
                        return answer+1;
                    }
                    queue.poll();
                    answer++;
                }//if
            }//for
        }//while

        return answer+1;
    }
}