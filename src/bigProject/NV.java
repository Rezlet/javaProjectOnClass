package bigProject;

public class NV extends Person {
    private float salary, timeWork;

    public NV(String name, String date, String id, float salary, float timeWork, String chucVu) {
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

    private String chucVu;

}
