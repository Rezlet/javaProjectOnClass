package bigProject;

import java.util.Scanner;

public class Xang {



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

    public float getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(float price) {
        this.marketPrice = price;
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

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Import ID: ");
        setIdXang(scanner.nextLine());
        System.out.print("Import name gasoline: ");
        setTenXang(scanner.nextLine());
        System.out.print("Import cost: ");
        setCost(scanner.nextFloat());
        System.out.print("Import market price: ");
        setMarketPrice(scanner.nextFloat());
        System.out.print("Import inventory: ");
        setInventory(scanner.nextFloat());

    }

    @Override
    public String toString() {
        return getIdXang() + "," + getTenXang() + "," +getCost() + "," +getMarketPrice() + "," +getInventory() + "," +getSold();
    }

    private float cost, marketPrice, inventory, sold;
    private String idXang, tenXang;

    public Xang(String idXang, String tenXang, float cost, float marketPrice, float inventory, float sold ) {
        this.cost = cost;
        this.marketPrice = marketPrice;
        this.inventory = inventory;
        this.sold = sold;
        this.idXang = idXang;
        this.tenXang = tenXang;
    }

    public Xang() {
        this("", "", 0,0,0,0);
    }

    public Xang(Xang xang) {
        this(xang.getIdXang(), xang.getTenXang(), xang.getCost(), xang.getMarketPrice(), xang.getInventory(), xang.getSold());
    }
}
