import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class DepartmentTest {

    @Test
    public void isValid() {
    }

    @Test
    public void addPersonTest() throws Exception {
        Person person=new Person("Karolina", "Widz", new Date(1997, Calendar.DECEMBER, 25), "97082509673", Position.JAVA_DEVELOPER);
        Department department1 = new Department("Department1 Name",DepartmentType.DEVELOPMENT);
        boolean result=department1.addPerson(person);
        assertTrue(result);
        assertTrue(department1.getPersonList().contains(person));

    }

    @Test
    public void addPersonTestFail() throws Exception {
        Person person=new Person("Karolina", "Widz", new Date(1997, Calendar.DECEMBER, 25), "97082509673", Position.MARKETING_CONSULTANT);
        Department department1 = new Department("Department1 Name",DepartmentType.HR);
        boolean result=department1.addPerson(person);
        assertFalse(result);

    }

    @Test
    public void relocatePersonTest() throws Exception {
        Person person=new Person("Karolina", "Widz", new Date(1997, Calendar.DECEMBER, 25), "97082509673", Position.JAVA_DEVELOPER);
        Department department1 = new Department("Department1 Name",DepartmentType.DEVELOPMENT);
        department1.addPerson(person);
        Department department2 = new Department("Department2 Name",DepartmentType.DEVELOPMENT);
        boolean result = department1.relocatePerson(person, department2);
        assertTrue(result);
    }

    @Test
    public void relocatePersonTestFail() throws Exception {
        Person person=new Person("Karolina", "Widz", new Date(1997, Calendar.DECEMBER, 25), "97082509673", Position.JAVA_DEVELOPER);
        Department department1 = new Department("Department1 Name",DepartmentType.DEVELOPMENT);
        department1.addPerson(person);
        Department department2 = new Department("Department2 Name",DepartmentType.MARKETING);
        boolean result = department1.relocatePerson(person, department2);
        assertFalse(result);
    }
}