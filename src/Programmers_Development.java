import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.*;

public class Programmers_Development {
    public static  void main(String[] args){
        //93,30,55 / 1,30,5
        int[] progresses={93,30,55};
        int[] speeds={1,30,5};
        int[] answer;

        answer=solution(progresses,speeds);

        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int count=0;
        int index=0;

        List<Integer> list=new ArrayList<Integer>(); //answer에 옮길 answer list
        Queue<Integer> queue=new LinkedList<Integer>();


        for(int i=0;i<progresses.length;i++){ //queue -> 93 30 55
            queue.offer(progresses[i]);
        }

        ////////queue 내용 변경시키지 않고 조건만 .. 충족시키면 삭제시키자
        while(!queue.isEmpty()){ //queue가 empty되면 끝 조건 만족할때 queue에서 삭제
            for(int i=0;i<progresses.length;i++){ //하루마다 진행률 +
                progresses[i]+=speeds[i];
            }

            queue.clear();
            for(int i=index;i<progresses.length;i++){ // queue 계속 업데이트
                queue.offer(progresses[i]);
            }

            while(!queue.isEmpty()){
                int temp=(Integer)queue.peek();
                if(temp >= 100){
                    queue.poll();
                    count++;
                    index++;
                }else{
                    break;
                }
            }//inner while

            if(count != 0){// 없는경우는 안넣고
                list.add(count); //한번에 return 되는 작업
                count = 0;
            }
        }//while

        answer=new int[list.size()]; // answer size 지정
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }

        return answer;
    }
}
