import java.util.*;

public class BaekJoon_AgeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int personCount= sc.nextInt();

        String arr[][]=new String[personCount][2]; // 나이, 이름

        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<2;j++) {
                arr[i][j] = sc.next();
            }//inner for
        }

        Arrays.sort(arr,new Comparator<String[]>() { // 0:나이 , 1:이름
            @Override
            public int compare(String[] o1,String[] o2) {
                return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0])); //3항 연산
                /*
                if x > y 양수
                else if x == y  0
                else if x < y 음수

                return.
                * */
            }
        });

        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }//for

    }//main
}//class
