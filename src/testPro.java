import java.util.*;

/*
* 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

길이가 짧은 것부터
길이가 같으면 사전 순으로
* */
public class testPro {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Set set=new HashSet<String>();
        int count=0;

        count=sc.nextInt();
        sc.nextLine();

        String str="";
        for(int i=0;i<count;i++){ //hashSet으로 중복 제거한 set을 만듬 set은 순서가 없다. 배열형태 아님
            str=sc.nextLine();
            set.add(str);
        }

        String[] arr=new String[set.size()]; // set size 만큼의 string 배열 생성
        set.toArray(arr); //set -> arr 로 변환

        Arrays.sort(arr,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){ // 만약 길이가 같다면 사전순
                    return o1.compareTo(o2);
                }
                return Integer.compare(o1.length(), o2.length()); //길이순 오름차순
            }
        });

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
