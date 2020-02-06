package Programmers;

/*              prices	return
        [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]*/

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_Stack_Queue_StockPrice {
    public static void main(String[] args){
        int[] prices={1,2,3,2,3};

        for(int i=0;i<prices.length;i++){
            System.out.println(solution(prices)[i]);
        }
    }
    public static int[] solution(int[] prices) {
        int[] answer =new int[prices.length];
        int target;
        int count;
        int index=0;
        Queue<Integer> queue=new LinkedList<Integer>();

        for(int i=0;i<prices.length;i++){
            queue.offer(prices[i]);
        }

        while(!queue.isEmpty()){
            target=queue.poll();
            count=0;
            for(int temp : queue){
                if(target > temp){
                    count++;
                    break;
                }else{
                    count++;
                }
            }//inner for
            answer[index++]=count;
        }//while

        return answer;
    }
}
