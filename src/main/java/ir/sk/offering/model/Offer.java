package ir.sk.offering.model;

public class Offer {

    private int offerId;
    private String productTitle;
    private int vendorId;
    private double price;

    public Offer() {
    }

    public Offer(int offerId, String productTitle, int vendorId, double price) {
        this.offerId = offerId;
        this.productTitle = productTitle;
        this.vendorId = vendorId;
        this.price = price;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
