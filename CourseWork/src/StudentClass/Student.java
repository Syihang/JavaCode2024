package StudentClass;

public class Student {
    private String name;
    private boolean isMonitor;
    private double[] gender = new double[5];
    private double averiageScore;
    public void setName(String name){
        this.name = name;
    }

    public void setGender(int[] gender){
        for (int i = 0; i < gender.length ; i++){
            this.gender[i] = gender[i];
        }
    }

    public void setMonitor(String YESorNO){
        if (YESorNO.equals("是")) this.isMonitor = true;
        else this.isMonitor = false;
    }

    public double getAveriageScore(){
        int sum = 0;
        for (int i = 0 ; i < gender.length; i ++){
            sum += gender[i];
        }
        return sum/gender.length;
    }
}
