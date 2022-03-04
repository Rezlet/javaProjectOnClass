package bigProject;

import java.util.Scanner;

public class KH extends Person {
    public KH(String name, int date, String id, String numberCar, String company) {
        super(name, date, id);
        this.numberCar = numberCar;
        this.company = company;
    }

    public KH() {
        super();
        this.company = "";
        this.numberCar = "";
    }

    public KH(KH kh) {
        super(kh.getName(), kh.getDate(), kh.getId());
        this.numberCar = kh.numberCar;
        this.company = kh.company;
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

    public void input () {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Import your number car: ");
        this.setNumberCar(scanner.nextLine());
        System.out.print("Import company: ");
        this.setCompany(scanner.nextLine());
    }

    private String numberCar, company;
}
