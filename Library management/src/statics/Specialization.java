package statics;

public enum Specialization {

    KHTN("KHoa hoc tu nhien"),
    VHNT("Van hoc nghe thuat"),
    DTVT("Dien tu vien thong"),
    CNTT("COng nghe thong tin") ;

    public String value;

    Specialization(String value) {
        this.value = value;
    }
}
