import org.junit.Test;
import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void validArgument() {
        try {
            new Person("Karolina", "Widz", new Date(1997, Calendar.DECEMBER, 25), "97082509673", Position.JAVA_DEVELOPER);
        } catch (Exception e) {
            fail("Exception thrown");
        }
    }

    @Test
    public void invalidArgument(){
        Throwable exception= assertThrows(Exception.class, () -> {
            new Person();
        });
        assertEquals("Create Empty", exception.getMessage());
    }

    @Test
    public void incorrectName(){
        Throwable exception=assertThrows(Exception.class, () -> {
            new Person("", "Widz", new Date(1997, Calendar.DECEMBER, 25), "97122500000", Position.CPP_DEVELOPER);
        });
        assertEquals("PERSON NAME IS EMPTY", exception.getMessage());
    }

    @Test
    public void incorrectSurname(){
        Throwable exception=assertThrows(Exception.class, () -> {
            new Person("Karolina", "", new Date(1997, Calendar.DECEMBER, 25), "97122500000", Position.CPP_DEVELOPER);
        });
        assertEquals("PERSON SURNAME IS EMPTY", exception.getMessage());
    }

    @Test
    public void underage(){
        Throwable exception=assertThrows(Exception.class, () -> {
            new Person("Karolina", "Widz", new Date(2015, Calendar.DECEMBER, 25), "97122503681", Position.CPP_DEVELOPER);
        });
        assertEquals("PERSON IS UNDERAGE", exception.getMessage());
    }

    @Test
    public void incorrectPesel(){
        Throwable exception=assertThrows(Exception.class, () -> {
            new Person("Karolina", "Widz", new Date(1997, Calendar.DECEMBER, 25), "971225", Position.CPP_DEVELOPER);
        });
        assertEquals("PESEL IS INVALID", exception.getMessage());
    }



}
