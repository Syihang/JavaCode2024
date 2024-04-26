package Experiment9;

public class Student{

    private String id;
    private String name;
    private int age;
    private String location;

    public Student(String id, String name, int age, String loc) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.location = loc;
    }

    public Student(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLoc(String loc) {
        this.location = loc;
    }
}
