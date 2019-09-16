import java.util.Scanner;

public class algorithmMinimum {
        //x보다 작은값
        public static void main(String[] args) {
            Scanner input=new Scanner(System.in);
            int size;//배열size
            int x; //x값

            System.out.println("만들 정수의 개수 , x값 입력.");
            size=input.nextInt();
            x=input.nextInt();

            if(!(x >= 1 && x <= 10000)) {
                System.out.println("x값 다시입력.");
                x=input.nextInt();
            }

            int[] arr=new int[size];

            System.out.println("수열을 이루는 정수 "+size+"개 를 입력.");

            for(int i=0;i<arr.length;i++) {
                arr[i]=input.nextInt();

                if(!(arr[i] >=1 && arr[i] <= 10000)) {// 정수의 범위를 벗어난다면 다시입력
                    System.out.println("다시입력. 1이상 10000이하의 수를 입력.");
                    arr[i]=input.nextInt();
                }

                if(arr[i] < x)
                    System.out.print(" "+arr[i]+" ");
            }//for
        }//main
    }

