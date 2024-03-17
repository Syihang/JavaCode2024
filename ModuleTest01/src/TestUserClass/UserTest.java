package TestUserClass;

public class UserTest {
    public static void main(String[] args) {
        User u = new User();
        User u2 = new User();
        User u3 = new User();
        System.out.println(u);
        System.out.println(u2);
        System.out.println(u3);
        System.out.println(u.getAge() + " " + u.getEmail());
        u.setAge(10);
        u.setEmail("124");
        System.out.println(u.getAge() + " " + u.getEmail());
        u2 = u;
        System.out.println(u);
        System.out.println(u2);
        System.out.println(u2.getAge() + " " + u2.getEmail());
        u2 = u;
        u = null;
        System.out.println(u);
        System.out.println(u2);
        System.out.println(u2.getAge() + " " + u2.getEmail());
    }
}
