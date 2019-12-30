/*import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

    * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

    길이가 짧은 것부터  //comparable
    길이가 같으면 사전 순으로 //comparator
    입력
    첫째 줄에 단어의 개수 N이 주어진다. (1≤N≤20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.

    출력
    조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
    *
public class BaekJoon_wordSort{ //단순 comparator 사용 중복은 허용

    static String[] str;

    public static void main(String[] args){
        int wordCount;
        Scanner sc=new Scanner(System.in);

        wordCount=sc.nextInt();
        str=new String[wordCount];

        sc.nextLine(); //int 형 \n 막기위해서

        for(int i=0;i<str.length;i++){ //배열에 값 넣기
            System.out.print("이름입력: ");
            str[i]=sc.nextLine().trim();
            System.out.println();
        }

        Arrays.sort(str); // 순서대로 정렬 후
        Arrays.sort(str, new Comparator<String>() { //길이순 으로 정렬 해보리기
            @Override
            public int compare(String o1, String o2) {

                return Integer.compare(o1.length(),o2.length());
            }
        });

        for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }
    }//main
}
*/
import java.util.*;
/*
    * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

    길이가 짧은 것부터  //comparable
    길이가 같으면 사전 순으로 //comparator
    입력
    첫째 줄에 단어의 개수 N이 주어진다. (1≤N≤20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.

    출력
    조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
    * */
public class BaekJoon_wordSort{

    static String[] str;

    public static void main(String[] args){
        int wordCount; // 입력할 단어의 개수
        Scanner sc=new Scanner(System.in);
        Set set=new HashSet<String>();//중복을 허용하지 않기 위해서

        wordCount=sc.nextInt();
        sc.nextLine(); //int 형 \n 막기위해서

        for(int i=0;i<wordCount;i++){
            System.out.print("이름입력: ");
            String string=sc.nextLine();
            set.add(string);
            System.out.println("");
        }//for

        str=new String[set.size()]; //중복이 제거된 set 크기만큼의 string array 생성

        set.toArray(str); //set을 String 형태의 array로

        Arrays.sort(str); // 순서대로 정렬 후
        Arrays.sort(str, new Comparator<String>() { //길이순 으로 정렬 해보리기
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });

        for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }//for
    }//main
}//중복허용안함 중복허용안하는 코드작성해도되지만 hashset으로 해결
//이 문제 핵심 comparator , hashset