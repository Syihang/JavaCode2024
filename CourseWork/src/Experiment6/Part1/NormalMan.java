package Experiment6.Part1;

class NormalMan implements Mankind {
    private String name;

    public NormalMan() {
        this.name = "John Doe";
    }

    public NormalMan(String name) {
        this.name = name;
    }

    @Override
    public void breath() {
        System.out.println(name + " is breathing.");
    }

    @Override
    public void move() {
        System.out.println(name + " is moving.");
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating.");
    }

    @Override
    public void study() {
        System.out.println(name + " is studying.");
    }

    @Override
    public void think() {
        System.out.println(name + " is thinking.");
    }
}
