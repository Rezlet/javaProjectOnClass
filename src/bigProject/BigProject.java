package bigProject;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BigProject {
    public static void main(String[] args) {
        MainMethods main = new MainMethods();
        if(main.logInAdmin() == true){
            System.out.println("This is admin");
        }else {
            System.out.println("This is staff");

        };

    }
}
