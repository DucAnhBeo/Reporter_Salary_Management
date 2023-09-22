package entity;

import statics.Specialization;

import java.util.Scanner;

public class Book implements InputTable {

    public static int AUTO_ID = 10000;

    private int id;
    private String name;
    private String author;
    private Specialization specialization;
    private int publishedYear;


    public static int getAutoId() {
        return AUTO_ID;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", specialization=" + specialization.value +
                ", publishedYear=" + publishedYear +
                '}';
    }

    @Override
    public void inputInfor() {
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhap ten sach");
        this.name = new Scanner(System.in).nextLine();

        System.out.println("Nhap ten tac gia");
        this.author = new Scanner(System.in).nextLine();

        System.out.println("Chon chuyen nganh");
        System.out.println("1. Khoa hoc tu nhien");
        System.out.println("2. Van hoc nghe thuat ");
        System.out.println("3. Dien tu vien thong");
        System.out.println("4. Cong nghe thong tin");
        int choice = new Scanner(System.in).nextInt();
        switch (choice) {
            case 1:
                this.specialization= Specialization.KHTN;
                break;
            case 2:
                this.specialization = Specialization.VHNT;
                break;
            case 3:
                this.specialization = Specialization.DTVT;
                break;
            case 4:
                this.specialization = Specialization.CNTT;
                break;
        }

        System.out.println("Nhap nam xuat ban");
        this.publishedYear = new Scanner(System.in).nextInt();

    }
}
