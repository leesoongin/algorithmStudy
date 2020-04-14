package Programmers;

import java.util.*;

/*
* 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
입출력 예
numbers	return
[6, 10, 2]	6210
[3, 30, 34, 5, 9]	9534330
* */
public class The_Greatest_Best {
    public static void main(String[] args){
        int[] numbers={3,30,34,5,9};

        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers){
        String answer="";
        String[] str=new String[numbers.length];

        for(int i=0;i<numbers.length;i++){ // int -> String
            str[i]=Integer.toString(numbers[i]);
        }

        Arrays.sort(str,new Comparator<String>() { //정렬하고
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(str[0].equals("0")){ //모두 0일때 , 예외조건.
            return answer="0";
        }

        for(int i=0;i<str.length;i++){
            answer+=str[i];
        }
        return answer;
    }
}

/*
이 문제는 comparable , comparator 를 잘 아느냐 하는 문제
주요매서드 compare, compareTo  에 대해 잘 알고있어야 풀수있음.
별도로 String 메소드인 valueOf, stringBuffer 등 String 클래스의 메소드들을 알아놓으면 훨씬 쉽게 풀릴문제
* */