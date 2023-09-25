package Logic;


import Entity.SaleManagement;
import Entity.SaleManagementDetail;
import Entity.Seller;

import java.util.Scanner;

public class SellerLogic {
    private Seller[] sellers = new Seller[100];

    public Seller[] getSellers() {
        return sellers;
    }

    public void setSellers(Seller[] sellers) {
        this.sellers = sellers;
    }

    public void inputSeller() {
        System.out.println("Nhập số nhân viên ");
        int sellerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < sellerNumber; i++) {
            System.out.println("Nhập nhân viên thứ " + (i + 1));
            Seller seller = new Seller();
            seller.inputInfor();
            saveSeller(seller);
        }
    }

    private void saveSeller(Seller seller) {
        for (int i = 0; i < sellers.length; i++) {
            if (sellers[i] == null) {
                sellers[i] = seller;
                break;
            }
        }
    }


    public void showSeller() {
        for (int i = 0; i < sellers.length; i++) {
            if (sellers[i] != null) {
                System.out.println(sellers[i]);
            }
        }
    }

    public Seller searchRSellerId(int sellerId) {
        for (int i = 0; i < sellers.length; i++) {
            if (sellers[i] != null && sellers[i].getId() == sellerId) {
                return sellers[i];
            }
        }
        return null;
    }
}


