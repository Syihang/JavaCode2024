package PlayGame;

import java.util.Random;

public class Role {
    private String name;
    private int blood;
    private char gender;
    private String face;

    String[] boyfaces= {"风流俊雅","气宇轩昂","相貌英俊","五官端正","相貌平平","一塌糊涂","面目狰狞"};
    String[] girlfaces ={"美奂绝伦","沉鱼落雁","婷婷玉立","身材娇好","相貌平平","相貌简陋","惨不忍睹"};

    String[] attacks_desc={
            "%s使出了一招【背心钉】，转到对方的身后，一掌向%s背心的灵台穴拍去。",
            "%s使出了一招【游空探爪】，飞起身形自半空中变掌为抓锁向%s。",
            "%s大喝一声，身形下伏，一招【劈雷坠地】，捶向%s双腿。",
            "%s运气于掌，一瞬间掌心变得血红，一式【掌心雷】，推向%s。",
            "%s阴手翻起阳手跟进，一招【没遮拦】，结结实实的捶向%s。",
            "%s上步抢身，招中套招，一招【劈挂连环】，连环攻向%s。"
    };

    String[] injureds_desc={
            "结果%s退了半步，毫发无损",
            "结果给%s造成一处瘀伤",
            "结果一击命中，%s痛得弯下腰",
            "结果%s痛苦地闷哼了一声，显然受了点内伤",
            "结果%s摇摇晃晃，一跤摔倒在地",
            "结果%s脸色一下变得惨白，连退了好几步",
            "结果『轰』的一声，%s口中鲜血狂喷而出",
            "结果%s一声惨叫，像滩软泥般塌了下去"
    };

    public void attact(Role r) {

        Random rand = new Random();
        int index_at = rand.nextInt(attacks_desc.length);
        int index_in = rand.nextInt(injureds_desc.length);

        int hurt = RandomNum(1, 20);

        if (index_in == 0) hurt = 0;
        else if (index_in == injureds_desc.length-1) hurt = r.getBlood();

        int remainBlood = r.getBlood() - hurt;
        remainBlood = Math.max(remainBlood, 0);

        r.setBlood(remainBlood);

        System.out.printf(attacks_desc[index_at], this.name, r.name);
        System.out.printf( injureds_desc[index_in], r.name);
        System.out.println(",受到了" + hurt + "点伤害," + "剩余生命为" + remainBlood + "点");
    }

    Role(){}

    Role(String name, int blood, char gender){
        this.name = name;
        this.blood = blood;
        this.gender = gender;

        setFace(gender);
    }

    public void show() {
        System.out.println("姓名:" + getName());
        System.out.println("性别:" + getGender());
        System.out.println("血量:" + getBlood());
        System.out.println("长相:" + getFace());
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFace() {
        return face;
    }

    public void setFace(char gender) {
        Random rand = new Random();

        if (gender == '男') {
            int index = rand.nextInt(boyfaces.length);
            this.face = boyfaces[index];
        }
        else if (gender == '女') {
            int index = rand.nextInt(girlfaces.length);
            this.face = girlfaces[index];
        }
        else {
            this.face = "神秘";
        }
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
