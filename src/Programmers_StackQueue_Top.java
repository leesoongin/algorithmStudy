import com.sun.media.jfxmediaimpl.HostUtils;

import java.util.Stack;

public class Programmers_StackQueue_Top {

    public static void main(String[] args){
        int[] heights={6,9,5,7,4}; //size 7
        int[] arr;

      arr=solution(heights);

      for(int i=0;i<arr.length;i++){
          System.out.println(arr[i]);
      }

    }

    public static int[] solution(int[] heights){
        int[] answer=new int[heights.length];
        Stack<Integer> stack=new Stack<Integer>();

        for(int i=0;i< heights.length;i++){ //arr -> stack
            stack.push(heights[i]);
        }

        int origin,target,count; //오리지날, 비교대상, 몇개까지 stack에서 빠졌는지 count

        for(int index=heights.length -1 ;index>=0;index--){ // stack상의 데이터를 index 역순으로 위치를 찾자.
            origin=stack.pop();
            count=0;

            while(!stack.empty()){ // stack이 다 빌 때 까지
                target=stack.pop();
                count++;

                if(target > origin){ //"나보다 높은 탑" 이라는 조건을 성립한다면,
                    answer[index]=index-count+1;//인덱스로 하고 있었으니 요소의 위치를 +1 해주자
                    break;
                }//if
            }//while
            //stack 다시 원상 복구
            for(int i=index-count;i<index;i++){
                stack.push(heights[i]);
            }//inner for
        }//for

        return answer;
    }//solution
}
