package stuffs;

import stuffs.Course;

public class Student extends Course {
    private String name;
    private int age;
    private long phone_no;
    private boolean result;

    public Student(String name) {
        System.out.println("***********These are the details of "+name+"***********");
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    public void setPhone_no(long phone_no){
        this.phone_no = phone_no;
    }
    public long getPhone_no(){
        return phone_no;
    }

    public void setResult(boolean result){
        this.result = result;
    }
    public boolean getResult(){
        return result;
    }

    public void display(){
        if (result)
            System.out.println("Name: "+name +"\nAge: "+age+"\nPhone No: "+phone_no+"\nResult: Qualified\n");
        else
            System.out.println("Name: "+name +"\nAge: "+age+"\nPhone No: "+phone_no+"\nResult: Not Qualified\n");
    }
}
