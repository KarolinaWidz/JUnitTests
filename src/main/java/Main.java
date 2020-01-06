import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        Company company = new Company();
        Person person = new Person("Karolina","Widz", new Date(1997, Calendar.DECEMBER, 25), "97082509673", Position.JAVA_DEVELOPER);
    }
}

