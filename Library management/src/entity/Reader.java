package entity;

import entity.Person;
import statics.ReaderType;

import java.util.Scanner;

public class Reader extends Person {

    private static int AUTO_ID = 10000;
    private int id;
    private ReaderType readerType;

    public Reader() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ReaderType getReaderType() {
        return readerType;
    }

    public void setReaderType(ReaderType readerType) {
        this.readerType = readerType;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", readerType=" + readerType.value +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public void inputInfor() {
        super.inputInfor();
        System.out.println("Nhập loại bạn đọc, chọn 1 trong các loại dưới đây");
        System.out.println("1. Sinh viên");
        System.out.println("2. Học viên cao học");
        System.out.println("3. Giảng viên");
        int type = new Scanner(System.in).nextInt();
        switch (type) {
            case 1:
                this.setReaderType(ReaderType.STUDENT);
                break;
            case 2:
                this.setReaderType(ReaderType.POST_STUDENT);
                break;
            case 3:
                this.setReaderType(ReaderType.TEACHER);
                break;
        }
    }
}