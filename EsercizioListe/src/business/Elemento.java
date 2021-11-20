package business;

public class Elemento {

    private String name;
    private String lastName;
    private Elemento next = null;

    public Elemento(String name , String lastName)
    {
        this.name = name;
        this.lastName = lastName;
    }

    public void setNext(Elemento next) {
        this.next = next;
    }

    public Elemento getNext() {return next;}
    public String getName() {return name;}
    public String getLastName() {return lastName;}

    @Override
    public String toString()
    {
        return "Esercizio{" +
                "nome='" + name + '\'' +
                ", cognome='" + lastName + '\'' +
                '}';
    }

}
