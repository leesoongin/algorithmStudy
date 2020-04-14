package Programmers;

import java.util.Arrays;
import java.util.Comparator;

/*
* [6, 10, 2]	6210
[3, 30, 34, 5, 9]	9534330
* */
public class Programmers_The_Greatest_best {
    public static void main(String[] args){
        int[] numbers={3,30,34,5,9};

        System.out.println(solution(numbers));
    }
    public static String solution(int[] numbers){
        String name="";
        Integer[] integer=new Integer[numbers.length];

        for(int i=0;i<integer.length;i++){
            integer[i]=numbers[i];
        }

        Arrays.sort(integer, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });

      for(int i=0;i<integer.length;i++){
          name+=integer[i];
      }
        return name;
    }
}
