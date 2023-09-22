package LogicHandle;

import entity.Book;
import entity.BookBorrowManagement;
import entity.BookBorrowManagementDetail;
import entity.Reader;

import java.util.Scanner;

public class BookBorrowManagementLogic {

    private BookLogicManagement bookLogicManagement;
    private ReaderLogicManagement readerLogicManagement;
    private BookBorrowManagement[] bookBorrowManagements = new BookBorrowManagement[100];

    public BookBorrowManagementLogic(BookLogicManagement bookLogicManagement, ReaderLogicManagement readerLogicManagement) {
        this.bookLogicManagement = bookLogicManagement;
        this.readerLogicManagement = readerLogicManagement;

    }

    public void showBorrow() {
        for (int i = 0; i < bookBorrowManagements.length; i++) {
            if (bookBorrowManagements[i] != null) {
                System.out.println(bookBorrowManagements[i]);
            }
        }
    }

    public void borrowBook() {
        System.out.println("Co bao nhieu ban doc can muon sach");
        int readerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < readerNumber; i++) {
            System.out.println("Nhap thong tin cho ban doc thu " + (i + 1));
            Reader reader = inputReaderForBorrow();

            BookBorrowManagementDetail[] details = inputBookManagementDetail();

            BookBorrowManagement bookBorrowManagement = new BookBorrowManagement(reader, details);
            saveBookBorrow(bookBorrowManagement);
        }
    }

    private BookBorrowManagementDetail[] inputBookManagementDetail() {
        System.out.println("Ban doc nay muon muon bao nhieu dau sach");
        int bookNumber;
        do {
            bookNumber = new Scanner(System.in).nextInt();
            if (bookNumber > 0 && bookNumber < 6) {
                break;
            }
            System.out.println("So luong dau sach la mot so duong hon 6, vui long nhap lai");
        } while (true);
        BookBorrowManagementDetail[] details = new BookBorrowManagementDetail[bookNumber];
        int count = 0;
        for (int j = 0; j < bookNumber; j++) {
            System.out.println("Nhap thong tin cho dau sach" + (j + 1));
            System.out.println("Nhap id cua sach");

            int bookId;
            Book book = null;
            do {
                bookId = new Scanner(System.in).nextInt();

                book = bookLogicManagement.searchBookById(bookId);
                if (book != null) {
                    break;
                }
                System.out.println("Khong co dau sach mang ma " + bookId + "vui long nhap lai");
            } while (true);

            System.out.println("Ban muon muon dau sach " + book.getName() + "bao nhiue cuon");

            int quantity;

            do {
                quantity = new Scanner(System.in).nextInt();
                if (quantity > 0 && quantity < 4) {
                    break;
                }
                System.out.println("So luong cuon sach muon cua moi dau sach khong vuot qua 3, vui long nhap lai");
            } while (true);
            BookBorrowManagementDetail detail = new BookBorrowManagementDetail(book, quantity);
            details[count] = detail;
            count++;
        }
        return details;
    }

    private Reader inputReaderForBorrow() {
        System.out.println("Nhap ma ban doc muon muon sach");
        Reader reader = null;
        int readerId;
        do {
            readerId = new Scanner(System.in).nextInt();

            reader = readerLogicManagement.searchReaderById(readerId);
            if (reader != null) {
                break;
            }
            System.out.println("Khong ton tai ban doc mang ma" + readerId + "vui long nhap lai");
        } while (true);
        return reader;
    }

    private void saveBookBorrow(BookBorrowManagement bookBorrowManagement) {
        for (int j = 0; j < bookBorrowManagements.length; j++) {
            if (bookBorrowManagements[j] == null) {
                bookBorrowManagements[j] = bookBorrowManagement;
                break;
            }
        }
    }
}
