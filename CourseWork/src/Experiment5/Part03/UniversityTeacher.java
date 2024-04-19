package Experiment5.Part03;

public class UniversityTeacher extends Teacher{

    public String major;

    public UniversityTeacher(String major) {
        this.major = major;
    }

    @Override
    public void title() {
        System.out.println("职称：" + major);
    }

    public void research() {
        System.out.println("进行科研");
    }
}