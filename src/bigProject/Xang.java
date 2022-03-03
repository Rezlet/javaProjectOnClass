package bigProject;

public class Xang {
    private String idXang, tenXang;

    public String getIdXang() {
        return idXang;
    }

    public void setIdXang(String idXang) {
        this.idXang = idXang;
    }

    public String getTenXang() {
        return tenXang;
    }

    public void setTenXang(String tenXang) {
        this.tenXang = tenXang;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getInventory() {
        return inventory;
    }

    public void setInventory(float inventory) {
        this.inventory = inventory;
    }

    public float getSold() {
        return sold;
    }

    public void setSold(float sold) {
        this.sold = sold;
    }

    private float cost, price, inventory, sold;

}
