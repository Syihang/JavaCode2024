package PlayGame;

import java.util.Random;

public class Role {
    private String name;
    private int blood;

    public void attact(Role r) {

        int hurt = RandomNum(1, 20);

        int remainBlood = r.getBlood() - hurt;
        remainBlood = Math.max(remainBlood, 0);

        r.setBlood(remainBlood);

        System.out.println(this.getName() + "攻击了" + r.getName() + "造成了" + hurt +
                "点伤害," + r.getName() + "还剩下" + remainBlood + "点血量");
    }

    Role(){}

    Role(String name, int blood){
        this.name = name;
        this.blood = blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public String getName() {
        return name;
    }

    // 生成[min, max]之间的随机数
    private int RandomNum(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }
}
