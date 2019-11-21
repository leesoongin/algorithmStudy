import java.util.Collections;
import java.util.PriorityQueue;

public class Programmers_StackQueue_Printer {
    public static void main(String[] args){
        int[] priorities={1,1,9,1,1,1};
        int location=0;

        System.out.println(solution(priorities,location));
    }

    public static int solution(int[] priorities, int location) {
        PriorityQueue<Integer> queue=new PriorityQueue<>(Collections.reverseOrder());
        int answer=0;

        for(int i=0;i<priorities.length;i++){
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
