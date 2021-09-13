import stuffs.Student;
import stuffs.Teacher;

public class Main {

    public static void main(String [] args){
        Student s1 = new Student("Dipesh");

        s1.setName("Dipesh Paul");
        s1.setAge(19);
        s1.setPhone_no(123456789);
        s1.setResult(true);
        s1.display();


        Student s2 = new Student("Messi");

        s2.setName("Lionel Messi");
        s2.setAge(33);
        s2.setPhone_no(998547217);
        s2.setResult(false);
        s2.display();


        Student s3 = new Student("Ronaldo");

        s3.setName("Cristiano Ronaldo");
        s3.setAge(36);
        s3.setPhone_no(546987123);
        s3.setResult(false);
        s3.display();

        Teacher t1 = new Teacher("Mia","female" );
        t1.setName("Mia Khalifa");
        t1.setAge(32);
        t1.display();

    }
}
