package Programmers.kakao;

public class Programmers_KAKAO_SecretMap {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9,20,28,18,11};
        int[] arr2 = {30,1,21,17,28};
        String[] str ;

        str = solution(n, arr1, arr2);

        for(int i=0; i<str.length; i++) {
            System.out.println(str[i]);
        }
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb;

        for(int i=0;i<n;i++){
            answer[i]=Integer.toBinaryString(arr1[i] | arr2[i]);
        }//for

        for(int i=0;i<n;i++){
            sb=new StringBuilder("");
            for(int j=0;j<answer[i].length();j++){
                if(answer[i].charAt(j) == '1'){
                    sb.append("#");
                }else if(answer[i].charAt(j) == '0'){
                    sb.append(" ");
                }
            }//inner for

            for(;sb.length()<n;){
                sb.insert(0," ");
            }//inner for
            answer[i]=sb.toString();
        }//for
        return answer;
    }
}
