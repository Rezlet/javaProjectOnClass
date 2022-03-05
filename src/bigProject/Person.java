package bigProject;

import java.util.Scanner;

public class Person {
    private String name;

    public Person(String id, String name, int date) {
        this.name = name;
        this.date = date;
        this.id = id;
    }

    public Person() {
        this("","",0);
    }

    public Person(Person person) {
        this(person.id, person.name, person.date);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Import id: ");
        this.setId(scanner.nextLine());
        System.out.print("Import name: ");
        this.setName(scanner.nextLine());
        System.out.print("Import year of birth: ");
        this.setDate(scanner.nextInt());
    }

    @Override
    public String toString() {
        return id +
                "," + name +
                "," + date;
    }

    private int date;
    private String id;

}
