package LogicHandle;

import entity.Reader;

import java.util.Scanner;

public class ReaderLogicManagement {

    private Reader[] readers = new Reader[100];

    public void showReader() {
        for (int i = 0; i < readers.length; i++) {
            if (readers[i] != null) {
                System.out.println(readers[i]);
            }
        }
    }

    public void inputReader() {
        System.out.print("Có bao nhiêu bạn đọc muốn thêm mới: ");
        int readerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < readerNumber; i++) {
            System.out.println("Nhập thông tin cho bạn đọc thu" + (i + 1));
            Reader reader = new Reader();
            reader.inputInfor();
            saveReader(reader);
        }
    }

    private void saveReader(Reader reader) {
        for (int j = 0; j < readers.length; j++) {
            if (readers[j] == null) {
                readers[j] = reader;
                break;
            }
        }

    }

    public Reader searchReaderById(int readerId) {
        for (int j = 0; j < readers.length; j++) {
            if (readers[j] != null && readers[j].getId() == readerId) {
                return readers[j];
            }
        }
        return null;
    }
}
