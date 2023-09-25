package Logic;

import Entity.Item;


import java.util.Scanner;

public class ItemLogic {

    private Item[] items = new Item[100];

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public void showItem() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.println(items[i]);
            }
        }
    }

    public void inputItem() {
        System.out.println("Nhập số lượng mặt hàng mới");
        int itemNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < itemNumber; i++) {
            System.out.println("Nhập thông tin cho mặt hàng thứ " + (i + 1));
            Item item = new Item();
            item.inputInfor();
            saveItem(item);
        }
    }

    private void saveItem(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                break;
            }
        }
    }


    public Item searchItemById(int itemId) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId() == itemId) {
                return items[i];
            }
        }
        return null;
    }

}
