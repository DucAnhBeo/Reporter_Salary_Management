package Entity;

public class SaleManagementDetail {

    private Item item;
    private int SL;

    public SaleManagementDetail(Item item, int SL) {
        this.item = item;
        this.SL = SL;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    @Override
    public String toString() {
        return "SaleManagementDetail{" +
                "item=" + item +
                ", SL=" + SL +
                '}';
    }
}
