import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.ArrayList;

public class K_count {

    public static void main(String[] args){
        int[] arr={1,5,2,6,3,7,4};
        int[][] commands={{2,5,3},{4,4,1},{1,7,3}};
        int[] result=new int[3];

        result=solution(arr,commands);

        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
        public static int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[3];  //0 -> 253 1-> 441 2-> 173
            ArrayList<Integer> cutArr=new ArrayList<Integer>();

            for(int i=0;i<3;i++) {//array
                for (int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++) //cutArr에 값넣을거
                    cutArr.add(array[j]); // 값 넣고

                cutArr.sort(null);//정렬

                answer[i] = cutArr.get(commands[i][2] - 1);

                cutArr.clear();
            }
            return answer;
        }
}
