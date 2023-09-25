package Logic;

import Entity.Seller;
import Entity.Item;

import java.util.Scanner;

public class MenuLogic {

    private final ItemLogic itemLogic = new ItemLogic();
    private final SellerLogic sellerLogic = new SellerLogic();
    private final SaleManagementLogic saleManagementLogic = new SaleManagementLogic(itemLogic,sellerLogic);


    public void menu() {
        while (true) {
            printMenu();
            int functionChoose = chooseFunction();

            switch (functionChoose) {
                case 1:
                    itemLogic.inputItem();
                    break;
                case 2:
                    itemLogic.showItem();
                    break;
                case 3:
                    sellerLogic.inputSeller();
                    break;
                case 4:
                    sellerLogic.showSeller();
                    break;
                case 5:
                    saleManagementLogic.inputSale();
                    break;
                case 6:
                    saleManagementLogic.showSale();
                    break;
                case 7:
                    saleManagementLogic.listBySellerName();
                    break;
                case 8:
                    saleManagementLogic.listByItemNumber();
                    break;
                case 9:
                    saleManagementLogic.salarySeller();
                    break;
                case 10:
                    return;

            }
        }
    }

    private  int chooseFunction() {
        int choice = 0;
        System.out.println("Xin mời nhập lựa chọn ");
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 10) {
                break;
            }
            System.out.println("Chức năng không hợp lệ, xin mời nhập lại ");
        } while (true);

        return choice;
    }

    private void printMenu() {
        System.out.println("--------------PHẦN MỀM QUẢN LÍ BÁN HANG---------------");
        System.out.println("1. Nhập măt hàng mới");
        System.out.println("2. In danh sách các mặt hàng đã có");
        System.out.println("3. Nhập thông tin nhân viên");
        System.out.println("4. In danh sách nhân viên đã có");
        System.out.println("5. Lập bảng bán hàng");
        System.out.println("6. In danh sach bán hàng");
        System.out.println("7. Sắp xếp danh sach theo tên nhân viên");
        System.out.println("8. Sắp xếp danh sách theo nhóm mặt hàng ");
        System.out.println("9. Tính doanh thu cho từng nhân viên");
        System.out.println("10. Thoát");

    }


}
