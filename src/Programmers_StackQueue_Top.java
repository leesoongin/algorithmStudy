import java.util.Stack;

public class Programmers_StackQueue_Top {
    private static Stack<Integer> registStack=new Stack<>();
    private static Stack<Integer> changeStack=new Stack<>();
    private static Stack<Integer> answerStack=new Stack<>();

    public static void main(String[] args){
        int[] heights={6,9,5,7,4};
        int[] printArr;

        printArr=solution(heights);

        for(int i=0;i<printArr.length;i++){
            System.out.println(printArr[i]);
        }
    }

    public static int[] solution(int[] heights){
        int[] answer=new int[heights.length];
        int findTop;

        for(int i=0;i<heights.length;i++){ //찾을 녀석들 스택에 저장
            registStack.push(heights[i]);
        }

        do{
           findTop=registStack.pop();
           if(registStack.isEmpty()){//가장 마지막친구가 pop일떄
               answerStack.push(0);
               break;
           }
           if(registStack.peek()>findTop){//찾기성공이라면,
               answerStack.push(registStack.search(registStack.peek()));
               while(!changeStack.isEmpty()){
                   registStack.push(changeStack.pop());
               }
           }else{
               changeStack.push(registStack.pop());
               if(registStack.isEmpty()){//뻈는데 비어버렸으면
                   answerStack.push(0);

                   while(!changeStack.isEmpty()){
                       registStack.push(changeStack.pop());
                   }
               }//if
           }

        }while(!registStack.isEmpty());
        int[] arr=new int[4];

        for(int i=0;i<arr.length;i++){
            arr[i]=answerStack.pop();
            System.out.println(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            answerStack.push( arr[i]);
        }

        for(int i=0;i<answer.length;i++){ //수신성공한 탑의 위치정보를 전달.
           // answer[i]=answerStack.pop();
        }

        return answer;
    }
}
