package bigProject;

public class Person {
    private String name;

    public Person(String name, String date, String id) {
        this.name = name;
        this.date = date;
        this.id = id;
    }

    public Person() {
        this("","","");
    }

    public Person(Person person) {
        this(person.name, person.date, person.id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    private String date;
    private String id;

}
