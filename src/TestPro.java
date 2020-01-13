import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class TestPro {
    public static void main(String[] args){
        int[] height={6,9,5,7,4};
        int[] answer;

        answer=solution(height);

        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
    }
    public static int[] solution(int[] height){
        int[] answer={};
        int[] searchArr=new int[height.length]; //발견했을때 순서를 찾기 위한 arr

        Stack<Integer> stack=new Stack<Integer>();
        Stack<Integer> saveStack=new Stack<Integer>(); //임시 저장 스택

        for(int i=0;i<height.length;i++){//stack
            stack.push(height[i]);
        }

        return answer;
    }
}
