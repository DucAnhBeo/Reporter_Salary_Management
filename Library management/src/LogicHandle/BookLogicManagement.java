package LogicHandle;

import entity.Book;
import entity.Reader;

import java.util.Scanner;

public class BookLogicManagement {

    private Book[] books = new Book[100];

    public void inputBook() {
        System.out.print("Có bao nhiêu dau sach thêm mới: ");
        int readerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < readerNumber; i++) {
            System.out.println("Nhập thông tin cho dau sach thu" + (i + 1));
            Book book = new Book();
            book.inputInfor();
            saveBook(book);
        }
    }

    private void saveBook(Book book) {
        for (int j = 0; j < books.length; j++) {
            if (books[j] == null) {
                books[j] = book;
                break;
            }
        }
    }

    public void showBook() {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.println(books[i]);
            }
        }
    }

    public Book searchBookById(int bookId){
        for (int j = 0; j < books.length; j++) {
            if (books[j] != null && books[j].getId() == bookId) {
                return books[j];
            }
        }
        return null;
    }
}
