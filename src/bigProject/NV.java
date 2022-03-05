package bigProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class NV extends Person {
    private float salary, timeWork;

    public String getPassword() {
        if(this.password == null)
            this.password = "";
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
    public NV(String id, String name, int date, float salary, float timeWork, String chucVu) {
        super(id, name, date);
        this.salary = salary;
        this.timeWork = timeWork;
        this.chucVu = chucVu;
    }


    public NV(String id, String name, int date, float salary, float timeWork, String chucVu, String password) {
        super(id, name, date);
        this.salary = salary;
        this.timeWork = timeWork;
        this.chucVu = chucVu;
        this.password = password;
    }


    public NV(NV person) {
        super(person.getId(), person.getName(), person.getDate());
        this.salary = person.getSalary();
        this.timeWork = person.getTimeWork();
        this.chucVu = person.getChucVu();
        this.password = person.getPassword();
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

    public float getMoney() {
        return this.salary * this.timeWork;
    }
    @Override
    public void input() {
        super.input();

        Scanner scanner = new Scanner(System.in);
        String tempPos = "";
        String password = "";

        do {
            System.out.print("Import position(AD or NV): ");
            tempPos = scanner.nextLine();
            if(!tempPos.equals("NV") && !tempPos.equals("AD"))
                System.out.println("Position doesn't exist, Please re-enter");
        }while(!tempPos.equals("NV") && !tempPos.equals("AD"));
        this.setChucVu(tempPos);
        System.out.print("Import salary per hours: ");
        this.setSalary(scanner.nextFloat());
        System.out.print("Import time to work per month: ");
        this.setTimeWork(scanner.nextInt());
        if(this.getChucVu().equals("AD")){
            System.out.print("Import password: ");
            scanner.nextLine();
            password = scanner.nextLine();
            this.createPasswordAdmin( this.getId(), password);
        }
        this.appendToDataNV(this);
    }

    public ArrayList<NV> fetchNVhavePassword() {
        ArrayList<NV> list ;
        list = this.fetchNVNonePassword();
        try {
            FileReader fr = new FileReader("DSAD.txt");
            BufferedReader br = new BufferedReader(fr);
            while(true) {
                String line = br.readLine();
                if (line == null)
                    break;
                String txt[] = line.split(",");
                String idAdmin = txt[0];
                String password = txt[1];
                for (NV nhanvien: list) {
                    if(nhanvien.getId().equals(idAdmin)){
                        nhanvien.setPassword(password);
                    }
                }
            }
        }catch (Exception e){

        }
        return list;
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + salary +
                "," + timeWork +
                "," + chucVu;
    }

    public void appendToDataNV(NV nv) {
        try{
            FileWriter fw = new FileWriter("DSNV.txt",true);
            fw.write(nv.toString() + "\n");
            fw.close();
        } catch (Exception e) {

        }
    }

    public boolean logInAdmin(){
        String tempId = "";
        boolean isRight = false;
        boolean isRight2 = false;

        NV nv = new NV();
        ArrayList<NV> listNV;
        listNV = nv.fetchNVhavePassword();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your ID: ");
        do {
            tempId = scanner.nextLine();
            for (NV nhanvien:listNV) {
                isRight = nhanvien.getId().equals(tempId);
                if (isRight){
                    nv = nhanvien;
                    break;
                }
            }

            if (!isRight){
                System.out.println("Your id doesn't exist, Please re-enter");
            }
        }while(!isRight);

        if (nv.getChucVu().equals("AD")){
            System.out.print("Enter your password: ");
            do {
                String password = "";
                password = scanner.nextLine();
                for (NV nhanvien: listNV) {
                    if(nhanvien.getPassword().equals(password)){
                        isRight2 = true;
                        System.out.println("Login Admin successful! ");
                    };
                }
                if (!isRight2){
                    System.out.println("Wrong password, Please re-enter");
                }
            }while(!isRight2);
        }

        return isRight2;
    }


    public ArrayList<NV> fetchNVNonePassword () {
        ArrayList<NV> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("DSNV.txt");
            BufferedReader br = new BufferedReader(fr);
            while(true)
            {
                String line = br.readLine();
                if ( line == null)
                    break;
                String txt[] =  line.split(",");
                String id = txt[0];
                String name = txt[1];
                int date = Integer.parseInt(txt[2]);
                float salary = Float.parseFloat(txt[3]);
                float timeToWork = Float.parseFloat(txt[4]);
                String pos = txt[5];
                NV tempNV = new NV(id, name,date,salary,timeToWork,pos);
                list.add(tempNV);
            }
        }
        catch (Exception e) {

        }
        return list;
    }



    public void refreshData(){
        ArrayList<NV> dsnv = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Nhap so nhan vien: ");
        n = scanner.nextInt();
        NV[] nv = new NV[n];
        for (int i = 0; i < n; i++) {
            nv[i] = new NV();
        }

        for (int i = 0; i < n; i++) {
            System.out.println("nhan vien thu " + (i + 1) + ": ");
            nv[i].input();
            dsnv.add(nv[i]);
        }
        this.writeToDataNV(dsnv);
    }


    public void createPasswordAdmin(String id, String password) {
        try{
            FileWriter fw = new FileWriter("DSAD.txt", true);
            fw.write(id + "," + password + "\n");
            fw.close();
        } catch (Exception e) {

        }
    }

    public void writeToDataNV(ArrayList<NV> dsNV) {
        try {
            FileWriter fw = new FileWriter("DSNV.txt");
            for (NV x: dsNV) {
                fw.write(x.toString() + "\n");
            }
            fw.close();
        } catch ( Exception e) {
        }
    }
    private String chucVu;

}
