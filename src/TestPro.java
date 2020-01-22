import java.util.*;

public class TestPro {
    public static void main(String[] args){
       Queue<People> queue=new LinkedList<People>();

       People per=new People(15);

       queue.offer(per);

       for(People people : queue){
           System.out.println(people._age);
       }
    }//main
}
class People{
    int _age;

    People(int age){
        this._age=age;
    }
}