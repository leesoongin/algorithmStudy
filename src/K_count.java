/*
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
}  ***********************이 전 코 드 *************
*/
/*
* 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.
입출력 예
array   commands   return
[1, 5, 2, 6, 3, 7, 4]   [[2, 5, 3], [4, 4, 1], [1, 7, 3]]   [5, 6, 3]
입출력 예 설명
[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
* */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class K_count {
    public static void main(String[] args){
        int[] arr={1,5,2,6,3,7,4};
        int[][] commands={{2,5,3},{4,4,1},{1,7,3}}; //[3][3]
        int[] answer;

        answer=solution(arr,commands);

        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i]);
        }
    }
    public static int[] solution(int[] arr,int[][] commands){
        int[] answer=new int[commands.length];
        int answerIndex=0;
        List<Integer> list;

        for(int i=0;i<commands.length;i++){
            list=new ArrayList<Integer>();
            for(int j=commands[i][0]-1;j<commands[i][1];j++) { // 2 - 5 , 4 - 4 , 1 - 7
                list.add(arr[j]);
            }//inner for
            Collections.sort(list); //오름차순이니까 comparator 는 딱히 필요없을듯. 오름차순정렬 후
            answer[answerIndex++]=list.get(commands[i][2]-1); //정렬 된 배열에서 찾고자하는 순서의 수를 찾아서 answer배열에 저장
        }//for
        return answer;
    }
}
/*
    깨알 tip !

    2차원 배열의 크기
    int arr[5][3];
    arr.length=5
    arr[i].length=3

* */