import java.time.Year;
import java.util.Date;
import java.util.Objects;

public class Person {

    private String name;
    private String surname;
    private Date birthDate;
    private String pesel;
    private Position position;

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public Date getBirthDate() { return birthDate; }
    String getPesel() { return pesel; }
    Position getPosition() { return position; }

    private void setName(String name){ this.name = name; }
    private void setSurname(String surname){ this.surname = surname; }
    private void setBirthDate(Date birthDate){ this.birthDate = birthDate; }
    private void setPesel(String pesel){ this.pesel = pesel; }
    private void setPosition(Position position) { this.position = position; }


    Person()throws Exception{
        this.name="";
        this.surname="";
        this.birthDate=new Date();
        this.pesel="99999999999";
        throw new Exception("Create Empty");
    }

    Person(String name, String surname, Date birthDate, String pesel, Position position) throws Exception {
        if(Company.getInstance().findEmployee(pesel) != null)
            throw new Exception("PERSON ALREADY IN DB");

        if(name.length()==0)throw new Exception("PERSON NAME IS EMPTY");
        if(surname.length()==0)throw new Exception("PERSON SURNAME IS EMPTY");

        PeselValidator peselValidator=new PeselValidator(pesel);
        if(!peselValidator.isValid()) throw new Exception("PESEL IS INVALID");
        int actualYear=Year.now().getValue();
        if((actualYear-birthDate.getYear())<=18) throw new Exception("PERSON IS UNDERAGE");
        setName(name);
        setSurname(surname);
        setBirthDate(birthDate);
        setPesel(pesel);
        setPosition(position);
        System.out.println(this.name);
        System.out.println(this.surname);
        System.out.println(this.birthDate);
        System.out.println(this.pesel);
        System.out.println(this.position);

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(birthDate, person.birthDate) &&
                Objects.equals(pesel, person.pesel) &&
                position == person.position;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", pesel='" + pesel + '\'' +
                ", position=" + position +
                '}';
    }
}
