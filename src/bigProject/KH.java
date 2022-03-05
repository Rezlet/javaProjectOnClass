package bigProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class KH extends Person {
    public KH(String id, String name, int date, String numberCar, String company,String typeGas, float paid, float liters) {
        super(id, name, date);
        this.numberCar = numberCar;
        this.company = company;
        this.typeGas = typeGas;
        this.paid = paid;
        this.liters = liters;
    }

    public KH() {
        super();
        this.company = "";
        this.numberCar = "";
        this.typeGas = "";
        this.paid = 0;
        this.liters = 0;
    }

    public KH(KH kh) {
        super(kh.getId(), kh.getId(), kh.getDate());
        this.numberCar = kh.numberCar;
        this.company = kh.company;
        this.typeGas = kh.typeGas;
        this.paid = kh.paid;
        this.liters = kh.liters;
    }

    public String getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(String numberCar) {
        this.numberCar = numberCar;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + numberCar +
                "," + company +
                "," +  typeGas
                + "," + paid
                + "," + liters;
    }

    public void input() {
        super.input();
        int choice = 0;
        ArrayList<Xang> dsXang;
        Xang xang = new Xang();
        dsXang = xang.FetchXang();
        int index = 1;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Import your number car: ");
        this.setNumberCar(scanner.nextLine());
        System.out.print("Import company: ");
        this.setCompany(scanner.nextLine());

        for (Xang x: dsXang) {
            System.out.println(index + ": " + x.getTenXang());
            index++;
        }
        System.out.print("Choice your gas: ");
        choice = scanner.nextInt();
        Xang x =  dsXang.get(choice - 1);
        this.setTypeGas(dsXang.get(choice - 1).getIdXang());
        System.out.print("How many liters of gasoline do you want to put in: ");
        this.setLiters(scanner.nextFloat());
        this.setPaid(dsXang.get(choice - 1).getSold() * liters);
        x.setInventory(x.getInventory() - this.getLiters());
        x.setSold(x.getSold() + this.getLiters());
        xang.writeToData(dsXang);
        this.appendToDataKH(this);
    }

    public void appendToDataKH(KH nv) {
        try {
            FileWriter fw = new FileWriter("DSKH.txt", true);
            fw.write(nv.toString() + "\n");
            fw.close();
        } catch (Exception e) {

        }
    }

    public ArrayList<KH> FetchKH () {
        ArrayList<KH> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("DSKH.txt");
            BufferedReader br = new BufferedReader(fr);
            while(true) {
                String line = br.readLine();
                if (line == null)
                    break;
                String txt[] = line.split(",");
                String id = txt[0];
                String name = txt[1];
                int date = Integer.parseInt(txt[2]);
                String numberCar = txt[3];
                String company = txt[4];
                String typeGas = txt[5];
                float paid = Float.parseFloat(txt[6]);
                float litters = Float.parseFloat(txt[7]);
                KH tempKH = new KH(id,name,date,numberCar,company,typeGas,paid,litters);
                list.add(tempKH);
            }
        }catch (Exception e){

        }
        return list;
    }


    public void getBill() {
        KH kh = new KH();
        ArrayList<KH> list;
        list = kh.FetchKH();
        int index = 1;
        for (KH khach:list) {
            System.out.println("Bill so " + index);
            System.out.println("ID: " + khach.getId() + "\t\t\tName:" + khach.getName());
            System.out.println("Company: " + khach.getCompany() + "\t\t\tNumber Car:" + khach.getNumberCar());
            System.out.println("Liters: " + khach.getLiters() + "\t\t\tPaid: " + khach.getPaid());
            index++;
        }
    }

    public void getBill(KH kh) {
        KH guest = new KH();
        ArrayList<KH> list;
        list = guest.FetchKH();
        int index = 1;
        for (KH khach: list) {
            if(khach.getId().equals(kh.getId())){
                System.out.println("ID: " + khach.getId() + "\t\t\tName:" + khach.getName());
                System.out.println("Company: " + khach.getCompany() + "\t\t\tNumber Car:" + khach.getNumberCar());
                System.out.println("Liters: " + khach.getLiters() + "\t\t\tPaid: " + khach.getPaid());
            }
        }
    }

        public void getBill(String IdKhach) {
        KH kh = new KH();
        ArrayList<KH> list;
        list = kh.FetchKH();
        for (KH khach: list) {
            if(khach.getId().equals(IdKhach)){
                System.out.println("ID: " + khach.getId() + "\t\t\tName:" + khach.getName());
                System.out.println("Company: " + khach.getCompany() + "\t\t\tNumber Car:" + khach.getNumberCar());
                System.out.println("Liters: " + khach.getLiters() + "\t\t\tPaid: " + khach.getPaid());
            }
        }

    }


    private String numberCar;
    private String company;

    public float getPaid() {
        return paid;
    }

    public void setPaid(float paid) {
        this.paid = paid;
    }

    private float paid;

    public float getLiters() {
        return liters;
    }

    public void setLiters(float liters) {
        this.liters = liters;
    }

    private float liters;

    public String getTypeGas() {
        return typeGas;
    }

    public void setTypeGas(String typeGas) {
        this.typeGas = typeGas;
    }

    private String typeGas;
}
