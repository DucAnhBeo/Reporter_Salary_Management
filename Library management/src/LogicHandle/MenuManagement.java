package LogicHandle;

import entity.Book;
import entity.BookBorrowManagement;
import entity.BookBorrowManagementDetail;
import entity.Reader;

import java.util.Scanner;

public class MenuManagement {

    private BookLogicManagement bookLogicManagement = new BookLogicManagement();
    private ReaderLogicManagement readerLogicManagement = new ReaderLogicManagement();
    private BookBorrowManagementLogic bookBorrowManagementLogic = new BookBorrowManagementLogic(bookLogicManagement, readerLogicManagement);
    public void run(){
        while (true) {
            printMenu();
            int functionChoice = chooseFunction();

            switch (functionChoice) {
                case 1:
                    readerLogicManagement.inputReader();
                    break;
                case 2:
                    readerLogicManagement.showReader();
                    break;
                case 3:
                    bookLogicManagement.inputBook();
                    break;
                case 4:
                    bookLogicManagement.showBook();
                    break;
                case 5:
                    bookBorrowManagementLogic.borrowBook();
                    break;
                case 6:
                    bookBorrowManagementLogic.showBorrow();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    return;

            }
        }
    }

    private static int chooseFunction() {
        System.out.print("Xin mời chọn chức năng:  ");
        int functionChoice;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 9) {
                break;
            }
            System.out.println("Chức năng không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return functionChoice;
    }

    private static void printMenu() {
        System.out.println("-----------------PHẦN MỀN QUẢN LÍ MƯỢN SÁCH-----------");
        System.out.println("1. Nhập bạn đọc mới.");
        System.out.println("2. In danh sách bạn đọc");
        System.out.println("3. Nhập sách mới");
        System.out.println("4. In danh sách các cuốn sách");
        System.out.println("5. Lập bảng mượn sách");
        System.out.println("6. In danh sách mượn sách");
        System.out.println("7. Sắp xếp danh sách mượn sách");
        System.out.println("8. Tìm kiếm trong danh sách mượn sách");
        System.out.println("9. Thoát");
    }
}

