import java.util.ArrayList;

public class Progarmmers_BruteForce_02 {
    static ArrayList<String> test=new ArrayList<String>();
    static ArrayList<Integer> testParseInt=new ArrayList<Integer>();

    static ArrayList<Integer> permitionNumber=new ArrayList<Integer>();

    public static int solution(String numbers){

        String[] arr=new String[numbers.length()];
        int numSize=10;
        int answer=0;
        boolean isCheck=false;

        for(int i=0;i<arr.length;i++) {
            arr[i]=""+numbers.charAt(i);
        }

        /** 길이에 따라 소수의 크기 찾기위해서 **/
        if(arr.length > 1) {//길이가 1보다 크다면
            for(int i=1;i<arr.length;i++) {
                numSize=numSize*10;
            }
        }

        int[] perNum=new int[numSize+1]; //소수를 찾을 범위만큼의 배열

        for(int i=2;i<perNum.length;i++) { //초기화
            perNum[i]=i;
        }

        for(int i=2;i<perNum.length;i++) {//찾고싶은 범위만큼의 소수를 찾기
            if(perNum[i] == 0)
                continue;
            for(int j=i+i;j<perNum.length;j+=i) {
                perNum[j]=0;
            }
        }

        for(int i=0;i<perNum.length;i++) { //찾은 소수를 arraylist에 저장 이걸로 비교할거임
            if(perNum[i] != 0)
                permitionNumber.add(perNum[i]);
        }

        for(int i=0;i<=arr.length;i++) {
            perm(arr,0,arr.length,i);
        }

        for(int i=0;i<test.size();i++) { //문자열로 저장되어있는걸 정수형으로 전환 . 밑에서 소수인지 판별할때 편하게 하기위해서.
            if(test.get(i) != "") {
                for(int j=0;j<testParseInt.size();j++) {
                    if(Integer.parseInt(test.get(i)) == testParseInt.get(j)) {
                        //System.out.println(Integer.parseInt(test.get(i)));
                        isCheck=true;//중복이 존재한다.
                        break;
                    }
                }//inner for
                if(!isCheck) { //중복이 존재하지 않는다면.
                    testParseInt.add(Integer.parseInt(test.get(i)));
                }//inner if
                isCheck=false;
            }//if
        }


        for(int i=0;i<permitionNumber.size();i++) {
            for (int j = 0; j < testParseInt.size(); j++) {
                if (permitionNumber.get(i) == testParseInt.get(j)) {
                    answer++;
                    //System.out.println(permitionNumber.get(i));
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String numbers="0000101";
        int result;

        result=solution(numbers);

        System.out.println(result);
    }

    public static void perm(String[] arr, int depth, int n, int k) {

        if (depth == k) { // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
            String str="";
            for(int i=0;i<k;i++) {
                str+=arr[i];
            }
            test.add(str);
            return;
        }

        for (int i = depth; i< n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k);
            swap(arr, i, depth);
        }

    }

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
