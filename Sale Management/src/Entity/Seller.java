package Entity;

import java.util.Scanner;

public class Seller extends Person {

    private static int AUTO_ID = 1000;
    private int id;
    private String contractDay;

    public Seller() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContractDay() {
        return contractDay;
    }

    public void setContractDay(String contractDay) {
        this.contractDay = contractDay;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", contractDay='" + contractDay + '\'' +
                '}';
    }

    @Override
    public void inputInfor() {
        super.inputInfor();
        System.out.println("Nhập ngày kí hợp đông ");
        this.setContractDay(new Scanner(System.in).nextLine());
    }

}
