package stuffs;

public class Teacher implements Person{
    private String name;
    private int age ;
    private Long phone_no= Long.valueOf(6546484);
    private int salary;

//    Constructor
    public Teacher(String name, String gender){
        if (gender == "MALE" || gender == "male" || gender == "Male")
            System.out.println("************These are the details of Mr. "+name+"************");
        else
            System.out.println("************These are the details of Mrs. "+name+"************");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {this.age = age; }
    public Long getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(Long phone_no) {
        this.phone_no = phone_no;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
    @Override
    public void display(){
        System.out.println("Name : "+name+"\nAge : "+age+"\nPhone No : "+phone_no+"\nSalary : "+salary);
    }

//    public void display_teacher(){
//        System.out.println("Name : "+name+"\nPhone No : "+phone_no);
//    }


//
    public void display_teacher() {
        System.out.println("Name : "+name+"\nAge : "+age+"\nPhone No : "+phone_no);
    }
}
