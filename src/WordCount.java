import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        String str_1 ;
        Scanner sc = new Scanner(System.in);
        str_1=sc.nextLine();

        int wordCount = 0;
        int total;
        int index=0;

        for(int i=0;i<str_1.length();i++){
            if(str_1.charAt(i) != ' ') {
                index=i;
                break;
            }
        }//for

        for(;index<str_1.length();index++){
            if(str_1.charAt(index) == ' ')
                wordCount++;
        }

        total=wordCount + 1;

        System.out.println(total);

    }//main
}
