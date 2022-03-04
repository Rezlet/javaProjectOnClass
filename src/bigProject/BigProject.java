package bigProject;

import java.util.ArrayList;
import java.util.Scanner;

public class BigProject {
    private void methodRefreshData (){
        DSXang dsXang1 = new DSXang();
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
        dsXang1.writeToData(dsXang);

    }
    public static void main(String[] args) {
       DSXang dsXang1 = new DSXang();

        ArrayList<Xang> list = new ArrayList<>();
        list = dsXang1.FetchXang();
        for (Xang x: list) {
            System.out.print("Ten Xang la: " + x.getTenXang());
        }
    }
}
