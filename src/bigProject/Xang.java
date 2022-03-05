package bigProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
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
        this.appendToData(this);
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

    public float moneyToGas(float money) {
        return money / this.getCost();
    }

    public float getRevenue() {
        return (this.marketPrice * this.sold) - (this.cost * this.sold);
    }

    public Xang(Xang xang) {
        this(xang.getIdXang(), xang.getTenXang(), xang.getCost(), xang.getMarketPrice(), xang.getInventory(), xang.getSold());
    }

    public void writeToData(ArrayList<Xang> dsXang) {
        try {
            FileWriter fw = new FileWriter("DSXang.txt");
            for (Xang x: dsXang) {
                fw.write(x.toString() + "\n");
            }
            fw.close();
        } catch ( Exception e) {
        }
    }

    public void soldGas() {
        Xang xang = new Xang();
        ArrayList<Xang> dsXang =xang.FetchXang();
        Scanner scanner = new Scanner(System.in);
        int index = 1;
        float money, lit;
        int choice;
        Xang gasGuest;
        for (Xang x: dsXang) {
            System.out.println(index + ": " + x.getTenXang());
            index++;
        }

        System.out.print("Choice your gas: ");
        choice = scanner.nextInt();
        System.out.print("How much do you want to spend: ");
        money = scanner.nextFloat();
        lit = dsXang.get((choice - 1)).moneyToGas(money);
        System.out.println("You have " + lit + " liters gas");
        gasGuest = dsXang.get((choice - 1));
        gasGuest.setInventory(gasGuest.getInventory() - lit);
        gasGuest.setSold(gasGuest.getSold() + lit);
        xang.writeToData(dsXang);
    }


    public void methodRefreshData (){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Xang> dsXang = new ArrayList<>();
        int n;
        System.out.print("Nhap so luong xang: ");
        n = scanner.nextInt();
        Xang[] xang = new Xang[n];
        for (int i = 0; i < n; i++) {
            xang[i] = new Xang();
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Loai xang thu " + (i + 1) + ": ");
            xang[i].input();
            dsXang.add(xang[i]);
        }
        this.writeToData(dsXang);

    }


    public float getAllRevenue() {
        ArrayList<Xang> dsXang;
        float Sum = 0;
        dsXang = this.FetchXang();
        for (Xang x: dsXang) {
            Sum = Sum + x.getRevenue();
        }

        return Sum;
    }



    public ArrayList<Xang> FetchXang () {
        ArrayList<Xang> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("DSXang.txt");
            BufferedReader br = new BufferedReader(fr);
            while(true)
            {
                String line = br.readLine();
                if ( line == null)
                    break;
                String txt[] =  line.split(",");
                String id = txt[0];
                String name = txt[1];
                float cost = Float.parseFloat(txt[2]);
                float priceMarket = Float.parseFloat(txt[3]);
                float inventory = Float.parseFloat(txt[4]);
                float sold = Float.parseFloat(txt[5]);
                Xang tempXang = new Xang(id, name, cost, priceMarket, inventory, sold);
                list.add(tempXang);

            }
        } catch (Exception e) {
        }

        return list;
    }


    public void appendToData(Xang xang) {
        try{
            FileWriter fw = new FileWriter("DSXang.txt",true);
            fw.write(xang.toString() + "\n");
            fw.close();
        } catch (Exception e) {

        }
    }
}
