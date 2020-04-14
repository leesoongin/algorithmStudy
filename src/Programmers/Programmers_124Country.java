package Programmers;

/*ddd
124 나라의 숫자
문제 설명
124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.

124 나라에는 자연수만 존재합니다.
124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.

10진법	124 나라	10진법	124 나라
1	1	6	14
2	2	7	21
3	4	8	22
4	11	9	24
5	12	10	41
자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.

제한사항
n은 500,000,000이하의 자연수 입니다.
* */
import java.util.ArrayList;
import java.util.List;

public class Programmers_124Country {
    private static List<String> permuCombination=new ArrayList<String>();
    private static String[] registCombinationArray=new String[30];

    public static void main(String[] args){
        System.out.println(solution(13));
    }
    public static String solution(int n) {
        String answer = "";
        String[] arr={"1","2","4"};
        int exponent;//입력받은 숫자의 범위를 포함하는 지수. 이만큼 범위의 중복순열들을 저장하면끝날듯,

        exponent=ThreeCubic(n);

        for(int i=0;i<=exponent;i++){ //exponent 는 4라고 가정하자. 주의 ! exponent (지수)만큼의 범위가 지정되야하니까 <=
            perm(arr,0,arr.length,i);
        }

        answer=permuCombination.get(n);

        return answer;
    }
    public static int  ThreeCubic(int inputNumber){
        int MAX_EXPONENT=20; //지수의 최대값. why? n의 범위가 5억이하의 자연수이기때문.
        int exponent=1;

        for(int i=1;i<=MAX_EXPONENT;i++){
                if(inputNumber<Math.pow(3,i)){
                    exponent=i;//입력한 숫자의 범위까지를 포함하는 지수를 저장. return할거임
                    return exponent;
                }
        }//for
        System.out.println("여기나오면앙ㅇ대 ㅠㅠ");
        return -1; //해당하는범위가 아니라면 -1 return
    }
//3 squared
    public static void perm(String[] arr, int depth, int n, int k) {
        String str="";

        if (depth == k) {
            for(int i=0;i<k;i++){
                str+=registCombinationArray[i];
            }
            permuCombination.add(str);
            return;
        }
        for (int i = 0; i< n; i++) {//중복 허용하는 순열.
            registCombinationArray[depth]=arr[i];
            perm(arr, depth + 1, n, k);
        }
    }
}
