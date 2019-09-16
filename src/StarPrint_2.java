import java.util.Scanner;

public class StarPrint_2 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int line;

        System.out.println("몇줄짜리 별 찍을?");

        line=input.nextInt();

        for(int i=0;i<line;i++) {
            for(int j=line-1;j>=0;j--) {
                if(i>=j)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
