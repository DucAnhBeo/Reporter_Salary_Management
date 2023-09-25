package Logic;

import Entity.Item;
import Entity.SaleManagement;
import Entity.SaleManagementDetail;
import Entity.Seller;

import java.util.Scanner;


public class SaleManagementLogic {

    private ItemLogic itemLogic;
    private SellerLogic sellerLogic;
    private SaleManagement[] saleManagements = new SaleManagement[100];

    public SaleManagementLogic(ItemLogic itemLogic, SellerLogic sellerLogic) {
        this.itemLogic = itemLogic;
        this.sellerLogic = sellerLogic;

    }


    public void inputSale() {
        if (!checkData()) {
            System.out.println("Chưa có thông tin nhân viên hoặc mặt hàng, vui lòng nhập danh sách nhân viên và mặt hàng trước");
            return;
        }
        System.out.println("Nhập số lượng nhân viên trong danh sách");
        int sellerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < sellerNumber; i++) {
            System.out.println("Nhập thông tin nhân viên thứ " + (i + 1));
            Seller seller = inputSaleSeller();

            SaleManagementDetail[] details = inputSaleManagementDetail();

            SaleManagement saleManagement = new SaleManagement(seller, details);
            saveSaleManagement(saleManagement);
        }
    }

    private void saveSaleManagement(SaleManagement saleManagement) {
        for (int j = 0; j < saleManagements.length; j++) {
            if (saleManagements[j] == null) {
                saleManagements[j] = saleManagement;
                break;
            }
        }
    }

    private SaleManagementDetail[] inputSaleManagementDetail() {
        System.out.println("Nhập số mặt hàng mà nhân viên bán");
        int itemNumber;
        do {
            itemNumber = new Scanner(System.in).nextInt();
            if (itemNumber > 0 && itemNumber < 6) {
                break;
            }
            System.out.println("Số lượng mặt hàng lớn hơn 5, vui long nập lại");
        } while (true);

        SaleManagementDetail[] details = new SaleManagementDetail[itemNumber];
        int count = 0;
        for (int j = 0; j < itemNumber; j++) {
            System.out.println("Nhập thông tin cho mặt hàng");
            System.out.println("Nhập ID của mặt hàng");

            int itemId;
            Item item = null;
            do {
                itemId = new Scanner(System.in).nextInt();

                item = itemLogic.searchItemById(itemId);
                if (item != null) {
                    break;
                }
                System.out.println("Không có thông tin mặt hàng " + itemId + "vui lòng nhập lại");
            } while (true);

            System.out.println("Nhân viên bán " + item.getNameItem() + "số lượng là bao nhiêu");

            int SL = new Scanner(System.in).nextInt();

            SaleManagementDetail detail = new SaleManagementDetail(item, SL);
            details[count] = detail;
            count++;
        }
        return details;
    }

    private Seller inputSaleSeller() {
        System.out.println("Nhâp mã nhân viên bán hàng");
        Seller seller = null;
        int sellerId;
        do {
            sellerId = new Scanner(System.in).nextInt();

            seller = sellerLogic.searchRSellerId(sellerId);
            if (seller != null) {
                break;
            }
            System.out.println("Không tồn tại nhân viên" + seller.getId() + "vui long nhập lại");
        } while (true);
        return seller;
    }


    public void showSale() {
        for (int i = 0; i < saleManagements.length; i++) {
            if (saleManagements[i] != null) {
                System.out.println(saleManagements[i]);
            }
        }
    }

    public void listBySellerName() {
        if (!checkData()) {
            System.out.println("Chưa có thông tin nhân viên hoặc mặt hàng, vui lòng nhập danh sách nhân viên và mặt hàng trước");
            return;
        }
        for (int i = 0; i < saleManagements.length - 1; i++) {
            if (saleManagements[i] == null) {
                continue;
            }
            for (int j = i + 1; j < saleManagements.length; j++) {
                if (saleManagements[j] == null) {
                    continue;
                }
                SaleManagement temp = saleManagements[i];
                saleManagements[i] = saleManagements[j];
                saleManagements[j] = temp;
            }
        }
        showSale();
    }

    public void listByItemNumber() {
        if (!checkData()) {
            System.out.println("Chưa có thông tin nhân viên hoặc mặt hàng, vui lòng nhập danh sách nhân viên và mặt hàng trước");
            return;
        }
        for (int i = 0; i < saleManagements.length - 1; i++) {
            if (saleManagements[i] == null) {
                continue;
            }
            for (int j = i + 1; j < saleManagements.length; j++) {
                if (saleManagements[j] == null) {
                    continue;
                }

                SaleManagement temp = saleManagements[i];
                saleManagements[i] = saleManagements[j];
                saleManagements[j] = temp;

            }
        }
        showSale();
    }

    public void salarySeller() {
        if (!checkData()) {
            System.out.println("Chưa có thông tin nhân viên hoặc mặt hàng, vui lòng nhập danh sách nhân viên và mặt hàng trước");
            return;
        }
        for (SaleManagement saleManagement : saleManagements) {
            if (saleManagement == null) {

                break;
            }
            double payment = 0;
            SaleManagementDetail[] list = saleManagement.getDetails();
            for (int j = 0; j < list.length; j++) {
                payment += list[j].getItem().getPrice() * list[j].getSL();
            }
            System.out.println("Tổng thu nhập của nhân viên " + saleManagement.getSeller().getName() + " là " + payment);
        }
    }

    private boolean checkData() {
        boolean checkDataSeller = false;
        for (int i = 0; i < sellerLogic.getSellers().length; i++) {
            if (sellerLogic.getSellers()[i] != null) {
                checkDataSeller = true;
                break;
            }
        }

        boolean checkDataItem = false;
        for (int i = 0; i < itemLogic.getItems().length; i++) {
            if (itemLogic.getItems()[i] != null) {
                checkDataItem = true;
                break;
            }
        }
        return checkDataSeller && checkDataItem;
    }
}


