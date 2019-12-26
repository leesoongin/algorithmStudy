import java.util.Arrays;

public class testPro {
    public static void main(String[] args){
        int arr[]=new int[3];

        arr[0]=2;
        arr[1]=1;
        arr[2]=3;

        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
