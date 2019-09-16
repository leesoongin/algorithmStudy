public class WordCount {
    public static void main(String[] args) {
        String str_1 = " lee soong in";
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

        System.out.println("단어의 총 개수는 "+total+" 개");
    }//main
}
