import java.sql.SQLOutput;
import java.util.Scanner;

/*
    양이 먹은 사료양 a 염소가 먹은 사료양 b 염소 , 양의 총 마리수 n , 양과 염소가 먹은 총 사료의 양 w

    a b n w가 주어질때 염소와 양의 마리수는?
    여러가지 해가 나오거나 해가 없는 경우는 -1로 출력하자
* */
public class ICPC_2019_Farm {
    public static void main(String[] args){
        int a; int b; int n; int w;

        Scanner sc=new Scanner(System.in);

        a=sc.nextInt();
        b=sc.nextInt();
        n=sc.nextInt();
        w=sc.nextInt();

        solution(a,b,n,w);
    }

    public static void solution(int a,int b,int n,int w){
        int sheep=0;
        int goat=0;
        int count=0;

        for(int i=1;i<n;i++){
            if((a*i)+(b*(n-i)) == w){
                sheep=i;
                goat=n-i;
                count++;
            }
        }

        if(count != 1){
            System.out.println(-1);
        }else{
            System.out.println(sheep);
            System.out.println(goat);
        }
    }
}
