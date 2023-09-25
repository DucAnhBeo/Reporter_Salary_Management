package Statics;

public enum ItemType {

    ĐIỆN_TỬ("điện tử"),
    ĐIỆN_LẠNH("điện lạnh"),
    MÁY_TÍNH("máy tính"),
    THIẾT_BỊ_VĂN_PHÒNG("thiết bị văn phòng");

    public String value;

    ItemType(String value) {
        this.value = value;
    }
}
