package TestUserClass;

public class User {
    // 属性
    private String username;
    private String passsword;
    private String email;
    private String gender;
    private int age;


    // 空参
    public User(){}
    // 带全部参数的构造
    public User(String username, String passsword, String email, String gender, int age){
        this.username = username;
        this.passsword = passsword;
        this.email = email;
        this.gender  = gender;
        this.age = age;
    }

    // get和set方法
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
