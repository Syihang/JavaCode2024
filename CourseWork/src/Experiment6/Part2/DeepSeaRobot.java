// 苏一行
package Experiment6.Part2;

public class DeepSeaRobot implements Robot{
    private String manufactureDate;
    private String brandModel;

    public DeepSeaRobot(String manufactureDate, String brandModel) {
        this.manufactureDate = manufactureDate;
        this.brandModel = brandModel;
    }

    @Override
    public void work() {
        System.out.println("The deep sea robot is work.");
    }

    @Override
    public void charge() {
        System.out.println("The deep sea robot is charging.");
    }

    @Override
    public void place() {
        System.out.println("The deep sea robot is currently operating at the bottom of the ocean.");
    }

    public void printAttributes() {
        System.out.println("Manufacture Date: " + manufactureDate);
        System.out.println("Brand Model: " + brandModel);
    }
}
