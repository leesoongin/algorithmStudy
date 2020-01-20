import java.util.*;

public class TestPro {
    public static void main(String[] args){
       Queue<Integer> queue=new LinkedList<Integer>();

       queue.offer(1);
        System.out.println(queue.peek());
        queue.clear();
        queue.offer(2);
        System.out.println(queue.peek());
    }//main

}
