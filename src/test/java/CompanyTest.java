import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CompanyTest {

@Test
    public void numberOfPeople() throws Exception {
    int counter1=0;
    int counter2=0;
    Person person= new Person("Karolina", "Widz", new Date(1997, Calendar.DECEMBER, 25), "97082509673", Position.HR_ANALYST);
    Person person1= new Person("Karolina", "Widz", new Date(1997, Calendar.DECEMBER, 25), "97082509673", Position.MARKETING_RESEARCH_SPECIALIST);
    Person person2=new Person("Karolina", "Widz", new Date(1997, Calendar.DECEMBER, 25), "97082509673", Position.HR_ANALYST);
    Person person3=new Person("Karolina", "Widz", new Date(1997, Calendar.DECEMBER, 25), "97082509673", Position.MARKETING_RESEARCH_SPECIALIST);
    Department department1=new Department("Name1",DepartmentType.MARKETING);
    Department department2=new Department("Name2",DepartmentType.HR);
    Company company1=new Company();
    department1.addPerson(person);
    department2.addPerson(person1);
    department1.addPerson(person2);
    department2.addPerson(person3);
    List<Department> departmentList1 = new ArrayList<>();
    List<Department> departmentList2 = new ArrayList<>();
    Localisation localisation1 = new Localisation("Name1", "City1", departmentList1);
    Localisation localisation2 = new Localisation("Name2", "City2", departmentList2);
    localisation1.addDepartment(department1);
    localisation2.addDepartment(department2);
    company1.addLocalisation(localisation1);
    company1.addLocalisation(localisation2);

    //DEPARTAMENT 1 -person 2
    //DEPARTAMENT 2
        counter1 = company1.numberOfEmployees();
        localisation1.moveDepartment(localisation2,department1);
        department1.relocatePerson(person2,department2);
        counter2=company1.numberOfEmployees();

    assertEquals(counter1,counter2);
    }

}

