package bigProject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QLXang {
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

    public void appendToData(Xang xang) {
        try{
            FileWriter fw = new FileWriter("DSXang.txt",true);
            fw.write(xang.toString() + "\n");
            fw.close();
        } catch (Exception e) {

        }
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
        ArrayList<Xang> dsXang = new ArrayList<>();
        QLXang qlXang = new QLXang();
        Scanner scanner = new Scanner(System.in);
        float Sum = 0;
        dsXang = qlXang.FetchXang();
        for (Xang x: dsXang) {
            Sum = Sum + x.getRevenue();
        }

        return Sum;
    }
}
