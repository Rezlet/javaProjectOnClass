package bigProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    public void run(){
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are your :");
        System.out.println("1. Guest :");
        System.out.println("2. Staff :");
        System.out.println("0. Log out");
        System.out.print("Import your choice: ");
        do {
            choice = scanner.nextInt();
            if (!(choice >= 0) || !(choice <=2))
                System.out.println("Didn't have this choice, Please re-enter");
        }while(!(choice >= 0) || !(choice <=2));

        if(choice == 2) {
            NV nv = new NV();
            Xang xang = new Xang();
            KH kh = new KH();
            ArrayList<NV> list = nv.fetchNVNonePassword();
            if(nv.logInAdmin() == true){

                do {
                    System.out.println("You are admin: ");
                    System.out.println("1: Add 1 Staff ");
                    System.out.println("2: Refresh All Data and Import new Data: ");
                    System.out.println("3: Get all Salary of staff: ");
                    System.out.println("4: Refuel for guest: ");
                    System.out.println("5: Get all Revenue");
                    System.out.println("6: Add 1 type of gasoline ");
                    System.out.println("7: Get all bill guest: ");
                    System.out.println("8: Get bill guest by ID: ");
                    System.out.println("0: Log out: ");
                    System.out.print("Import your choice: ");
                    choice = scanner.nextInt();
                    if(choice == 0)
                        break;
                    else if (choice == 1) {
                        System.out.println("Import 1 staff");
                        nv.input();
                        try {
                            System.out.println("Imported");
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if (choice == 2){
                        System.out.println("If you active this choice all your all data will be deleted");
                        nv.refreshData();
                    } else if (choice == 3){
                        try {
                            for (NV nhanvien: list) {
                                System.out.println("Salary of " + nhanvien.getName() + " is " + nhanvien.getMoney());
                            }
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }  else if (choice == 4){
                        xang.soldGas();
                    } else if(choice == 5) {
                        try {
                            System.out.println("All Revenue is " + xang.getAllRevenue());
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if(choice == 6){
                        System.out.println("Import new type gasoline");
                        xang.input();
                    } else if (choice == 7){
                        try {
                            kh.getBill();
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        String temp = "";
                        System.out.print("Import guest ID:");
                        scanner.nextLine();
                        temp = scanner.nextLine();

                        try {
                            kh.getBill(temp);
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }while(true);

            }else {
                do {
                    System.out.println("You are staff");
                    System.out.println("1: Get all Salary of staff: ");
                    System.out.println("2: Refuel for guest: ");
                    System.out.println("0: Log out: ");
                    System.out.print("Import your choice: ");
                    choice = scanner.nextInt();
                    if(choice == 0)
                        break;
                    else if (choice == 1) {
                        try {
                            for (NV nhanvien: list) {
                                System.out.println("Salary of " + nhanvien.getName() + " is " + nhanvien.getMoney());
                            }
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        xang.soldGas();
                    }
                }while(true);

            }
        }

        if (choice == 1) {
            KH kh = new KH();
            do {
               System.out.println("You are guest");
               System.out.println("1: Buy gasoline: ");
               System.out.println("2: Take Bill: ");
               System.out.println("0: Log out");
               System.out.print("Import your choice: ");
               choice = scanner.nextInt();
               switch (choice){
                   case 1:
                       System.out.println("Import your info");
                       kh.input();
                       break;
                   case 2:
                       System.out.println("Your bill: ");
                       kh.getBill(kh);
                       break;
                   case 0:
                       break;
               }
               if (choice == 0)
                   break;
           }while(true);
        }
        System.out.println("Thank you to use");
    }
}
