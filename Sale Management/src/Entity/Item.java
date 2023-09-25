package Entity;

import Statics.ItemType;

import java.util.Scanner;

public class Item implements InputTable {

    private static int AUTO_ID = 1000;
    private int id;
    private String nameItem;
    private double price;
    private int quantity;
    private ItemType itemType;

    public Item() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", nameItem='" + nameItem + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", itemType=" + itemType +
                '}';
    }

    @Override
    public void inputInfor() {
        System.out.println("Nhập tên mặt hàng");
        this.setNameItem(new Scanner(System.in).nextLine());
        System.out.println("Nhập giá bán");
        this.setPrice(new Scanner(System.in).nextDouble());
        System.out.println("Nhập số lượng mặt hàng");
        this.setQuantity(new Scanner(System.in).nextInt());
        System.out.println("Xin chọn nhóm hàng");
        System.out.println("1. Điện tử");
        System.out.println("2. Điện lạnh");
        System.out.println("3. Máy tính");
        System.out.println("4. Thiết bị văn phòng");

        int temp = 0;
        System.out.println("Hãy nhập lựa chọn của bạn");
        do {
            temp = new Scanner(System.in).nextInt();
            if (temp >= 1 && temp <= 4) {
                break;
            }
            System.out.println("Lựa chọn không hợp lệ, xin mời nhập lại");
        } while (true);

        switch (temp) {
            case 1:
                this.itemType = ItemType.ĐIỆN_TỬ;
                break;
            case 2:
                this.itemType = ItemType.ĐIỆN_LẠNH;
                break;
            case 3:
                this.itemType = ItemType.MÁY_TÍNH;
                break;
            case 4:
                this.itemType = ItemType.THIẾT_BỊ_VĂN_PHÒNG;
                break;

        }
    }

}
