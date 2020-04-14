package Programmers;

public class Programmers_Sorting_02 {

        public static void main(String[] args) {
            int[] numbers = { 3, 30, 34, 5, 9 };

            solution(numbers);
            // return값은 9534330 이 나와야한다.
        }

        public static String solution(int[] numbers) {
            String[] strNumbers= {};
            String answer = "";
            int priorityNumber; //비교시, 더 우선순위 (size)가 큰  녀석 임시 저장변수.

            for(int i=0;i<numbers.length;i++) {
                strNumbers[i]=Integer.toString(numbers[i]);
            }

            answer+=strNumbers[0];// 첫번째꺼를일단 answer에 저장.
            priorityNumber=Integer.parseInt(answer); // 첫번쨰값이 우선순위 값.

            for(int i=1;i<strNumbers.length;i++) {

            }

            //str + arr or arr + str ;
            //커야한다. 만약 같다면 다음 숫자와 비교, 작다면  뒷녀석이 우선.
            return answer;
        }
    }


