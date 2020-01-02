import java.util.Arrays;

public class testPro {
    public static void main(String[] args){
        Student[] st=new Student[2];

      st[0]=new Student("A");
      st[1]=new Student("B");

        Arrays.sort(st);

        for(int i=0;i<st.length;i++){
            System.out.println(st[i].name);
        }
    }

}
class Student implements Comparable<Student>{
    int age=0;
    String name;

    Student(){

    }
    Student(String _name){
        this.name=_name;
    }
    @Override
    public int compareTo(Student o1) {
        return name.compareTo(o1.name);
    }
}//class
