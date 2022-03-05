package bigProject;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMethods {
    public void soldGas() {
        ArrayList<Xang> dsXang = new ArrayList<>();
        QLXang qlXang = new QLXang();
        Scanner scanner = new Scanner(System.in);
        dsXang = qlXang.FetchXang();
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
        gasGuest.setSold(gasGuest.getSold() + lit);
        qlXang.writeToData(dsXang);
    }


//    if return true is admin else is staff
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

}
