import java.util.ArrayList;

public class Progarmmers_BruteForce_02 {

    ArrayList<String> combinationString = new ArrayList<String>();

    public static void main(String[] args) {
        String numbers = "17";

        solution(numbers);
    }

    public static int solution(String numbers) {
        int answer = 0;

        int[] numArr = new int[numbers.length()];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt("" + numbers.charAt(i));
        }

        dfs(numArr,0,"");

        return answer;
    }

    public static void findPerMutaion(int[] numArr, int index) {
        //전체 순회하면서 노드 만들고 노드를 하나씩 순회할때마다 검사합수 돌려서 해볼까?
    }

    public static void dfs(int[] numArr, int index, String combination) {
            if(numArr.length == combination.length()){ //길이가 같아지면 return
                return;
            }


    }//dfs
}
