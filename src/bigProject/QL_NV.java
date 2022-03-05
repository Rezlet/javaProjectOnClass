package bigProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class QL_NV {
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

    public void appendToDataNV(NV nv) {
        try{
            FileWriter fw = new FileWriter("DSNV.txt",true);
            fw.write(nv.toString() + "\n");
            fw.close();
        } catch (Exception e) {

        }
    }

    public ArrayList<NV> FetchNV () {
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
        QL_NV DSNV = new QL_NV();
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
        DSNV.writeToDataNV(dsnv);
    }

    public void createPasswordAdmin(String id, String password) {
        try{
            FileWriter fw = new FileWriter("DSAD.txt", true);
            fw.write(id + "," + password + "\n");
            fw.close();
        } catch (Exception e) {

        }
    }


}
