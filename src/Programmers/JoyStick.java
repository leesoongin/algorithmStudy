package Programmers;

import java.util.Scanner;

//알파벳 총 개수 26개
public class JoyStick {
    public static void main(String[] args) {
        final int alphaSize = 26; //대문자 알파벳의 총 개수

        String name;//입력받는 이름
        char[] nameArr;//받은이름의 크기만큼의 기본 캐릭터를 만든다.

        int answer = 0; //최소 이동 횟수.
        int F_cnt = 0;
        int L_cnt = 0;
        int F_alpha_cnt = 0;
        int L_alpha_cnt = 0; //앞부터 탐색 뒤부터 탐색, 알파벳 change카운트
        int cursor = 0;
        Boolean[] isCheck;
        int check_cnt = 0;
        Boolean isFinish = false;

        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();

        nameArr = new char[name.length()]; // char 형 배열 생성
        isCheck = new Boolean[name.length()];

        for (int i = 0; i < nameArr.length; i++)//초기화
            nameArr[i] = 'A';

        for (int i = 0; i < isCheck.length; i++) {
            if (name.charAt(i) != 'A') // A가 아닌 녀석이면 체크안했다 표시  나중에 바꾸면 true로 바꿀예정
                isCheck[i] = false;
            else
                isCheck[i] = true;
        }

        while (!isFinish) {
            check_cnt = 0;F_cnt=0; L_cnt=0;

            if (cursor == 0) {//첫번째 커서일때
                if (name.charAt(cursor) != 'A') {
                    for (int j = 1; j < alphaSize; j++) {//a-b-c ..방식으로 앞에서 찾기 시작
                        if (name.charAt(cursor) == (char) (nameArr[cursor] + j)) {
                            F_alpha_cnt = j;
                            break;
                        }
                    }//for
                    for (int k = alphaSize - 1; k >= 0; k--) { // z-y-x ..방식으로 뒤에서 찾기시작 Z시작이므로
                        if (name.charAt(cursor) == (char) (nameArr[cursor] + k)) {
                            L_alpha_cnt = alphaSize - k;
                            break; //ex. if Q -> 25-16
                        }
                    }
                    if (F_alpha_cnt > L_alpha_cnt)
                        answer += L_alpha_cnt;
                    else
                        answer += F_alpha_cnt;

                    isCheck[cursor] = true;
                }//inner if
            }
                /** a가 아닌곳의 인덱스를 찾아 F_cnt,L_cnt에 저장 **/
                for (int i = 0; i < name.length(); i++) {//위치가 0인 커서를 기준으로 첨부터 탐색
                    if (name.charAt(i) != 'A' && !isCheck[i]) {
                        F_cnt = i;
                        break;
                    }
                }
                for (int i = name.length()-1; i >= 0; i--) { //i를 index로 생각해
                    if (name.charAt(i) != 'A' && !isCheck[i]) {
                        L_cnt = (name.length()-1) - i + 1;  //여긴 이동횟수의 값 인덱스 찾으려면 식 정리 해줘야함
                        break;
                    }
                }//for

                if(F_cnt ==0 && L_cnt ==0)//둘다 체크다한상태 (끝)이면
                    break; //while문 break
                /** 두개 비교 후  더 가까운곳 찾고, 그 인덱스를 커서에 넣고 이동횟수 더하고 isCheck 체크  **/

                if (F_cnt >= L_cnt) { //카운트 횟수 비교
                    answer += L_cnt;
                    cursor = name.length()-L_cnt;

                    if (name.charAt(cursor) != 'A' && !isCheck[cursor]) {
                        for (int j = 1; j < alphaSize; j++) {//a-b-c ..방식으로 앞에서 찾기 시작
                            if (name.charAt(cursor) == (char) (nameArr[cursor] + j)) {
                                F_alpha_cnt = j;
                                break;
                            }
                        }//for
                        for (int k = alphaSize - 1; k >= 0; k--) { // z-y-x ..방식으로 뒤에서 찾기시작 Z시작이므로
                            if (name.charAt(cursor) == (char) (nameArr[cursor] + k)) {
                                L_alpha_cnt = alphaSize - k; //ex. if Q -> 25-16
                                break;
                            }
                        }
                        if (F_alpha_cnt > L_alpha_cnt)
                            answer += L_alpha_cnt;
                        else
                            answer += F_alpha_cnt;

                        isCheck[cursor] = true;
                    }//inner if
                } else {
                    answer += F_cnt;
                    cursor = F_cnt;
                    if (name.charAt(cursor) != 'A' && !isCheck[cursor]) {
                        for (int j = 1; j < alphaSize; j++) {//a-b-c ..방식으로 앞에서 찾기 시작
                            if (name.charAt(cursor) == (char) (nameArr[cursor] + j)) {
                                F_alpha_cnt = j;
                                break;
                            }
                        }//for
                        for (int k = alphaSize - 1; k >= 0; k--) { // z-y-x ..방식으로 뒤에서 찾기시작 Z시작이므로
                            if (name.charAt(cursor) == (char) (nameArr[cursor] + k)) {
                                L_alpha_cnt = alphaSize - k; //ex. if Q -> 25-16
                                break;
                            }
                        }
                        if (F_alpha_cnt > L_alpha_cnt)
                            answer += L_alpha_cnt;
                        else
                            answer += F_alpha_cnt;

                        isCheck[cursor] = true;
                    }//inner if
                }

                for (int i = 0; i < isCheck.length; i++) {
                    if (isCheck[i])
                        check_cnt++;
                }

                if (check_cnt == isCheck.length)
                    isFinish = true;
        }//while
        System.out.println(answer);
    }//main
}//class
