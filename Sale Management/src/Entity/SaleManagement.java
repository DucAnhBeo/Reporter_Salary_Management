package Entity;

import java.util.Arrays;

public class SaleManagement {

    private Seller seller;
    SaleManagementDetail[] details;

    public SaleManagement(Seller seller, SaleManagementDetail[] details) {
        this.seller = seller;
        this.details = details;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public SaleManagementDetail[] getDetails() {
        return details;
    }

    public void setDetails(SaleManagementDetail[] details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "SaleManagement{" +
                "seller=" + seller +
                ", details=" + Arrays.toString(details) +
                '}';
    }
}
