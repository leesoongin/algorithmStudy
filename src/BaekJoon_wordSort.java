import java.util.*;

/*
    길이가 짧은 것부터  //comparable
    길이가 같으면 사전 순으로 //comparator

    조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
*/
public class BaekJoon_wordSort{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count=0;
        Set set=new HashSet<String>(); //중복으로 입력이 들어오는걸 방지하기위해서

        count=sc.nextInt();
        sc.nextLine();

        String str="";
        for(int i=0;i<count;i++){
            str=sc.nextLine();
            set.add(str);
        } // 다 입력

        String[] arr=new String[set.size()];
        set.toArray(arr); // HashSet ->  array

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){ //길이가 같다면 사전순
                    return o1.compareTo(o2);
                }
                return Integer.compare(o1.length(),o2.length()); //길이 짧은순 -> 길이 오름차순
                //return o1.length() - o2.length();   위와 동일
            }
        });

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }//main
}

//중복허용안함 중복허용안하는 코드작성해도되지만 hashset으로 해결
//이 문제 핵심 comparator , hashset