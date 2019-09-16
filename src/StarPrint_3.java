import java.util.Scanner;

public class StarPrint_3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int line;
        System.out.println("몇줄 만드실?");
        line=input.nextInt();

        for(int i=line-1;i>=0;i--) {
            for(int j=0;j<=i;j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
