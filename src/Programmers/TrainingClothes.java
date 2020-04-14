package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TrainingClothes {
    static ArrayList <Integer> lostArr = new ArrayList<Integer>(); //도난당한 친구들
    static ArrayList<Integer> reserveArr=new ArrayList<Integer>(); // 여분 가지고온 친구들

    public static void main(String arg[]){
        int n;
        int[] lostS_num,reserveS_num;
        String lost,reserve;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        try{
            n = Integer.parseInt(bf.readLine());//총 학생수
            lost=bf.readLine();//도난 24
            reserve=bf.readLine();//여분 35

            bf.close();
            for(int i=0;i<lost.length();i++) // ex. 0 -> 2    1 -> 4
                lostArr.add(Integer.parseInt(""+lost.charAt(i)));
            lostS_num=new int[lostArr.size()];

            for(int i=0;i<reserve.length();i++)
                reserveArr.add(Integer.parseInt(""+reserve.charAt(i)));
            reserveS_num=new int[reserveArr.size()];

            System.out.println(solution(n,lostS_num,reserveS_num));
        }catch(IOException e){e.printStackTrace();}

    }//main

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] total = new int[n];
        boolean[] isLost = new boolean[n];
        boolean[] isReserve = new boolean[n];

        for(int i=0; i<total.length; i++){ //학생들의 번호 입력
            total[i]=i+1;
            answer++;
        }

        for(int i=0;i<isLost.length;i++)//분실 당했는지 여부 초기화
            isLost[i] = false;
        for(int i=0;i<isReserve.length;i++)//여벌의 옷이 있는지 초기화
            isReserve[i]=false;

        for(int i=0;i<lostArr.size();i++) {//분실한 친구 불리언 설정정
            isLost[lostArr.get(i) - 1] = true;
            answer--;
        }

        for(int i=0;i<reserveArr.size();i++)//여벌의 옷이 있는친구 불리언 설정
            isReserve[reserveArr.get(i)-1]=true;

        for(int i=0;i<total.length;i++){
            if(isLost[i]&& i>0 && i<total.length-1){//분실한 학생이 맨앞 맨뒤가 아닐경우
                if(isReserve[i-1]) {//앞사람 여벌이있다면
                    answer++;
                    isReserve[i-1]=false; //빌려줬으니 이제 없음
                }else if(isReserve[i+1]){//뒷사람 여벌이 있다면
                    answer++;
                    isReserve[i+1]=false;//이제없음
                }//else if
            }else{ //큰if의 else
                if(i == 0){ //분실한 학생이 가장 첫번째일때 예외 경우랑
                    if(isReserve[i+1]){
                        answer++;
                        isReserve[i+1]=false;
                    }else if(i == total.length-1){ //분실한 학생이 가장 마지막일때 예외 경우
                        answer++;
                        isReserve[i-1]=false;
                    }//else if
                }//inner if
            }//else
        }//for
        return answer;
    }
}//class
