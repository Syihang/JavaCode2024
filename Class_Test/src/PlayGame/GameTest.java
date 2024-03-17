package PlayGame;

public class GameTest {
    public static void main(String[] args) {
        Role r1 = new Role("角色一", 100);
        Role r2 = new Role("角色二", 100);

        while (true) {

            r1.attact(r2);
            if (r1.getBlood() * r2.getBlood() == 0) {
                System.out.println(( r1.getBlood() != 0 ? r1.getName():r2.getName() ) + "获得了胜利");
                break;
            }
            r2.attact(r1);
            if (r1.getBlood() * r2.getBlood() == 0) {
                System.out.println(( r1.getBlood() != 0 ? r1.getName():r2.getName() ) + "获得了胜利。");
                break;
            }

        }
    }
}
