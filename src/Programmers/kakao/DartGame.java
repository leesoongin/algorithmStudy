package Programmers.kakao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DartGame {
    public static void main(String[] args) {
        String dartResult = "1S2D*3T";

        System.out.println(solution(dartResult));
    }

    public static int solution(String dartResult) {
        int answer = 0;
        ArrayList<Integer> list=new ArrayList<Integer>();
        StringBuilder sb=new StringBuilder("");

        for(int i=0;i<dartResult.length();i++){
            if(dartResult.charAt(i) >=48 && dartResult.charAt(i)<=57){ //숫자라면, 아스키코드값 48 - 57 -> 0 ~ 9
                sb.append(dartResult.charAt(i));
            }else if(dartResult.charAt(i) == 'S'){
                list.add(Integer.parseInt(sb.toString()));
                sb.delete(0,sb.length());//sb 초기화
            }else if(dartResult.charAt(i) == 'D'){
                list.add( Integer.parseInt(sb.toString()) * Integer.parseInt(sb.toString()) );
                sb.delete(0,sb.length());//sb 초기화
            }else if(dartResult.charAt(i) == 'T'){
                list.add( Integer.parseInt(sb.toString()) * Integer.parseInt(sb.toString()) * Integer.parseInt(sb.toString()) );
                sb.delete(0,sb.length());//sb 초기화
            }else if(dartResult.charAt(i) == '*'){
                if(list.size() > 1){
                    list.set(list.size()-1,list.get(list.size()-1) * 2);//index  ,element
                    list.set(list.size()-2,list.get(list.size()-2) * 2);//index  ,element
                }else{
                    list.set(list.size()-1,list.get(list.size()-1) * 2);//index  ,element
                }

            }else if(dartResult.charAt(i) == '#'){
                list.set(list.size()-1,-list.get(list.size()-1));
            }
        }//for

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            answer+=list.get(i);
        }
        return answer;
    }
}
