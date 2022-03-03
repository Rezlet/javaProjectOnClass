package bigProject;

import java.util.Scanner;

public class NV extends Person {
    private float salary, timeWork;

    public NV(String name, int date, String id, float salary, float timeWork, String chucVu) {
        super(name, date, id);
        this.salary = salary;
        this.timeWork = timeWork;
        this.chucVu = chucVu;
    }




    public NV(NV person) {
        super(person.getName(), person.getDate(), person.getId());
        this.salary = salary;
        this.timeWork = timeWork;
        this.chucVu = chucVu;
    }

    public NV() {
        super();
        this.chucVu = "";
        this.salary = 0;
        this.timeWork = 0;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(float timeWork) {
        this.timeWork = timeWork;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Import position: ");
        this.setChucVu(scanner.nextLine());
        System.out.print("Import salary: ");
        this.setSalary(scanner.nextFloat());
        System.out.print("Import time to work: ");
        this.setTimeWork(scanner.nextInt());
    }

    private String chucVu;

}
