import com.sun.media.jfxmediaimpl.HostUtils;

import java.util.Stack;

public class Programmers_StackQueue_Top {

    public static void main(String[] args){
        int[] heights={1,5,3,6,7,6,5}; //size 7
        int[] printArr;

      solution(heights);

    }

    public static int[] solution(int[] heights){
        int[] answer=new int[heights.length];

        for(int i=heights.length-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                if(heights[j]>heights[i]){
                    answer[i]=j+1;
                    break;
                }
            }
        }

        return answer;
    }
}
